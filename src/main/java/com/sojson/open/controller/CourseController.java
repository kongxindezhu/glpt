package com.sojson.open.controller;

import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.sojson.common.controller.BaseController;
import com.sojson.common.model.AppCourse;
import com.sojson.common.model.AppExeScore;
import com.sojson.open.service.CourseService;
import com.sojson.open.service.ExeScoreService;
import com.sojson.open.service.UserInfoService;

/**
 * @author huanjun
 * APP课程控制器
 */
@Controller
@Scope(value="prototype")
@RequestMapping("open/app")
public class CourseController extends BaseController{
	@Autowired
	CourseService courseService;
	
	@Autowired
	ExeScoreService exeScoreService;
	
	@Autowired
	UserInfoService userInfoService;
	
	/**
	 * 查询当前用户的课程类别的状态(正在练习、已经完成&未开始)
	 * 涉及到三个表：app_course、app_exe_score
	 * 思路：
	 * 1.查询课程类别列表
	 * 2.查询课程类别下的课程集，并且统计课程集数量。
	 * 3.查询练习表中当前用户对应的课程集数量，若与上面的相等则是已完成状态，否则正在进行或者未开始（根据课程类别的序号来区分）。
	 * @param request
	 * @param response
	 * @param uuid
	 * @return
	 */
	@RequestMapping(value="course/queryAllCatalogState",method=RequestMethod.GET)
	public @ResponseBody JSONObject queryAllCatalogState(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="uuid",required=true)String uuid){
		JSONObject obj = new JSONObject();
		JSONObject data = new JSONObject();
		//DecimalFormat df=new DecimalFormat("0.00");
		DecimalFormat df=new DecimalFormat();
		//击败百分之几的人=(1-当前用户的“所有课程”总分排名/总人数)
		int personNum = userInfoService.queryUserNum();
		int rankNum = exeScoreService.queryUserRank(uuid);
		String rank = personNum!=0 ? (df.format((1-(float)rankNum/personNum)*100)+ "%" ):"0%";
		List<AppCourse> catalogList=courseService.queryCourseByLevel(1); //查询课程类别
		if(catalogList!=null && catalogList.size()>0){
			boolean flag = false;
			for(AppCourse catalog:catalogList){
				int catalogId = catalog.getId();
				//根据课程类别ID查询下属的所有的课程集列表
				List<AppCourse> courseSetList = courseService.queryCourseSetByCatalogId(catalogId);
				int setNum = courseSetList!=null?courseSetList.size():0;
				//根据课程类别ID+用户ID查询当前用户完成的课程集数量
				int userSetNum = courseService.queryUserCourseSetNum(catalogId,uuid);
				if(setNum==userSetNum && setNum!=0){ //已完成
					catalog.setCatalogState(2);
				}else if(flag==false){  //正在进行
					catalog.setCatalogState(1);
					flag=true;
					//开始计算正在进行的任务：进度、累计时长、得分
					//进度=当前用户在该课程类别下完成的课程集的数量userSetNum/当前课程大类下的课程集总数setNum
					String proCeed = setNum!=0 ? (df.format((float)userSetNum/setNum*100)+ "%") : "0%";
					catalog.setProCeed(proCeed);
					//累计时长=当前用户在该课程类别下完成的课程集的时长之和,得分==当前用户在该课程类别下完成的课程集的得分之和
					AppExeScore res = exeScoreService.queryTotalTimeAndScore(catalogId,uuid);
					if(res!=null){
						catalog.setTotalTime(res.getTotalTime());
						catalog.setTotalScore(res.getTotalScore());
					}
				}else if(flag==true){   //未开始
					catalog.setCatalogState(0);
				}
			}
		}
		data.put("catalogList", catalogList);
		data.put("rank", rank);
		obj.put("data", data);
		return obj;
	}
	
	/**
	 * 查询当前用户在某个课程下的任务列表及其完成状态(正在练习、已经完成&未开始)
	 * @param request
	 * @param response
	 * @param uuid
	 * @param catalogId
	 * @return
	 */
	@RequestMapping(value="course/queryAllTaskState",method=RequestMethod.GET)
	public @ResponseBody JSONObject queryAllTaskState(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="uuid",required=true)String uuid,
			@RequestParam(value="catalogId",required=true)Integer catalogId){
		JSONObject obj = new JSONObject();
		JSONObject data = new JSONObject();
		List<AppCourse> taskList=courseService.queryCourseTaskByPid(catalogId); //查询当前课程类别下的任务类别列表
		if(taskList!=null && taskList.size()>0){
			boolean flag = false;
			for(AppCourse task:taskList){
				int taskId = task.getId();
				//根据任务类别ID查询下属的所有的课程集列表
				List<AppCourse> courseSetList = courseService.queryCourseSetByTaskId(taskId);
				int setNum = courseSetList!=null?courseSetList.size():0;
				//根据课程类别ID+用户ID查询当前用户完成的课程集数量
				int userSetNum = courseService.queryUserCourseSetNumByTaskId(taskId,uuid);
				if(setNum==userSetNum && setNum>0){
					task.setTaskState(2);
				}else if(flag == false){
					task.setTaskState(1);
					flag=true;
				}else if(flag == true){
					task.setTaskState(0);
				}
			}
		}
		data.put("taskList", taskList);
		obj.put("data", data);
		return obj;
	}
	
	/**
	 * 查询当前用户在某个课程任务下的课程集列表及其完成状态(正在练习、已经完成&未开始)
	 * @param request
	 * @param response
	 * @param uuid
	 * @param taskId
	 * @return
	 */
	@RequestMapping(value="course/queryAllCourseSetState",method=RequestMethod.GET)
	public @ResponseBody JSONObject queryAllCourseSetState(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="uuid",required=true)String uuid,
			@RequestParam(value="taskId",required=true)Integer taskId){
		JSONObject obj = new JSONObject();
		JSONObject data = new JSONObject();
		List<AppCourse> courseSetList=courseService.queryCourseTaskByPid(taskId); //查询当前任务类别下的课程集列表
		if(courseSetList!=null && courseSetList.size()>0){
			boolean flag = false;
			for(AppCourse courseSet:courseSetList){
				int courseSetId = courseSet.getId();
				//int res = exeScoreService.queryUserCourseSetById(courseSetId,uuid);
				int res = courseService.queryUserCourseSetNumBySetId(courseSetId,uuid);
				if(res>0){
					courseSet.setCourseSetState(2);
				}else if(flag == false){
					courseSet.setCourseSetState(1);
					flag = true;
				}else if(flag == true){
					courseSet.setCourseSetState(0);
				}
			}
		}
		data.put("courseSetList", courseSetList);
		obj.put("data", data);
		return obj;
	}
	
	/**
	 * 查询当前用户在某个课程集的课程块列表
	 * @param request
	 * @param response
	 * @param uuid
	 * @param courseSetId
	 * @return
	 */
	@RequestMapping(value="course/queryAllCourseBlock",method=RequestMethod.GET)
	public @ResponseBody JSONObject queryAllCourseBlock(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="courseSetId",required=true)Integer courseSetId){
		JSONObject obj = new JSONObject();
		JSONObject data = new JSONObject();
		List<AppCourse> courseBlockList=courseService.queryItemByPid(courseSetId); //查询当前课程集下的课程块列表
		data.put("courseBlockList", courseBlockList);
		obj.put("data", data);
		return obj;
	}
	
	/**
	 * 查询当前用户在某个课程块的所有课程列表
	 * @param request
	 * @param response
	 * @param uuid
	 * @param courseSetId
	 * @return
	 */
	@RequestMapping(value="course/queryAllCourse",method=RequestMethod.GET)
	public @ResponseBody JSONObject queryAllCourse(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="blockId",required=true)Integer blockId){
		JSONObject obj = new JSONObject();
		JSONObject data = new JSONObject();
		List<AppCourse> courseList=courseService.queryItemByPid(blockId); //查询当前课程集下的课程块列表
		data.put("courseList", courseList);
		obj.put("data", data);
		return obj;
	}
}
