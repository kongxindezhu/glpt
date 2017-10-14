package com.sojson.open.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
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
import com.sojson.common.model.AppExeScore;
import com.sojson.common.utils.JsonUtils;
import com.sojson.open.service.ExeScoreService;
import com.sojson.open.service.UserInfoService;

/**
 * @author huanjun
 * APP单次练习记录控制器
 */
@Controller
@Scope(value="prototype")
@RequestMapping("open/app")
public class ExeScoreController {
	@Autowired
	ExeScoreService exeScoreService;
	
	@Autowired
	UserInfoService userInfoService;
	
	/**
	 * 存储用户单次练习得分和练习时长
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="exeScore/insertExeScore",method=RequestMethod.POST)
	public @ResponseBody JSONObject insertExeScore(HttpServletRequest request,HttpServletResponse response){
		JSONObject obj = new JSONObject();
		JSONObject data = new JSONObject();
		
		String recordData = request.getParameter("recordJson");
		System.out.println("后台数据："+recordData);
		AppExeScore item = JsonUtils.json2Ojbect(recordData, AppExeScore.class);
		int num = exeScoreService.insertExeScore(item);
		data.put("num", num);
		obj.put("data", data);
		return obj;
	}
	
	/**
	 * 查询用户的统计信息：
	 * 展示在"我"的页面：总时长、练习币、勤奋指数、勤奋指数星级。
	 * 总时长是指的某个用户在所有课程上面的练习时间总和sumTime。
	 * 练习币是指的money=[sumTime/20]取整。
	 * 勤奋指数计算方法：采用击败百分之几的人=(1-当前用户的“所有课程”总分排名/总人数)，记该值为M。
	 *             [80%,100%]=五星；[60%,80%]=四星；[40%,60%]=三星；[20%,40%]=二星；[0%,20%]=一星
	 * @param request
	 * @param response
	 * @param uuid
	 * @return
	 */
	@RequestMapping(value="exeScore/querySumUserInfo",method=RequestMethod.GET)
	public @ResponseBody JSONObject querySumUserInfo(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="uuid",required=true)String uuid){
		JSONObject obj = new JSONObject();
		JSONObject data = new JSONObject();
		
		//1.计算总时长
		int sumTime = exeScoreService.queryUserSumTime(uuid);
		//2.计算练习币
		int money = sumTime/20;
		//3.计算勤奋指数
		//击败百分之几的人=(1-当前用户的“所有课程”总分排名/总人数)
		int personNum = userInfoService.queryUserNum();
		int rankNum = exeScoreService.queryUserRank(uuid);//排名
		//勤奋指数=击败百分之几的人
		DecimalFormat df=new DecimalFormat();
		String rank = personNum!=0 ? (df.format((1-(float)rankNum/personNum)*100)+ "%" ):"0%";
		//4.勤奋指数星级
		float percent = (1-(float)rankNum/personNum)*100;
		int star = 0;
		if(0<=percent && percent<20){
			star = 1;
		}else if(20<=percent && percent<40){
			star = 2;
		}else if(40<=percent && percent<60){
			star = 3;
		}else if(60<=percent && percent<80){
			star = 4;
		}else if(80<=percent && percent<=100){
			star = 5;
		}
		
		data.put("sumTime", sumTime);
		data.put("money", money);
		data.put("rank", rank);
		data.put("star", star);
		obj.put("data", data);
		return obj;
	}
	
	/**
	 * (按天)查询用户的日期-积分曲线：
	 * @param request
	 * @param response
	 * @param uuid
	 * @return
	 */
	@RequestMapping(value="exeScore/queryDateScoreLine",method=RequestMethod.GET)
	public @ResponseBody JSONObject queryDateScoreLine(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="uuid",required=true)String uuid){
		JSONObject obj = new JSONObject();
		JSONObject data = new JSONObject();
		
		//计算用户的时间-积分曲线
		List<AppExeScore> dateScoreList = exeScoreService.queryDateScoreData(uuid);
		//获取需要的字段<datetimeStr,totalScore>
		List<HashMap<String,Integer>> dateScoreData = new ArrayList<HashMap<String,Integer>>();
		for(AppExeScore item : dateScoreList){
			HashMap<String,Integer> map = new HashMap<String,Integer>();
			map.put(item.getDatetimeStr(), item.getTotalScore());
			dateScoreData.add(map);
		}
		data.put("dateScoreData", dateScoreData);
		obj.put("data", data);
		return obj;
	}
	
	/**
	 * (按天)查询用户的日期-时长曲线：
	 * @param request
	 * @param response
	 * @param uuid
	 * @return
	 */
	@RequestMapping(value="exeScore/queryDateTimeLine",method=RequestMethod.GET)
	public @ResponseBody JSONObject queryDateTimeLine(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="uuid",required=true)String uuid){
		JSONObject obj = new JSONObject();
		JSONObject data = new JSONObject();
		
		//计算用户的时间-积分曲线
		List<AppExeScore> dateTimeList = exeScoreService.queryDateTimeData(uuid);
		//获取需要的字段<datetimeStr,totalTime>
		List<HashMap<String,Integer>> dateTimeData = new ArrayList<HashMap<String,Integer>>();
		for(AppExeScore item : dateTimeList){
			HashMap<String,Integer> map = new HashMap<String,Integer>();
			map.put(item.getDatetimeStr(), item.getTotalTime());
			dateTimeData.add(map);
		}
		data.put("dateTimeData", dateTimeData);
		obj.put("data", data);
		return obj;
	}
	
}
