package com.sojson.open.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.sojson.common.model.AppQuestions;
import com.sojson.open.service.QuestionsService;

/**
 * @author huanjun
 * APP选项控制器
 * 三个接口：
 * 1.QuestionsController查询问题(关联选项列表)列表：涉及问题表、选项表
 * 2.AnswerRecordController存储用户回答每个问题的结果：涉及答题记录表(用户uuid,问题主键qid,开始答题时间time)，做法是将答题记录存储在本地，待全部答完批量提交到后台一次存储。
 * 3.ExeScoreController记录单次练习得分(用户uuid,课程集主键cid,开始答题时间time)：在客户端计算时长(从进入课程集到退出课程集的练习)和得分(已有得分计算方法)，然后将该用户的练习记录存储到数据库。
 */
@Controller
@Scope(value="prototype")
@RequestMapping("open/app")
public class QuestionsController {
	@Autowired
	QuestionsService questionsService;
	
	/**
	 * 查询问题(关联选项列表)列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="questions/queryAllQuestions",method=RequestMethod.GET)
	public @ResponseBody JSONObject queryAllCatalogState(HttpServletRequest request,HttpServletResponse response){
		JSONObject obj = new JSONObject();
		JSONObject data = new JSONObject();
		List<AppQuestions> QuestionsList = questionsService.queryAllQuestions();
		data.put("QuestionsList", QuestionsList);
		obj.put("data", data);
		return obj;
	}
}
