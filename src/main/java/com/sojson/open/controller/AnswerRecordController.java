package com.sojson.open.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.sojson.common.model.AppAnswerRecord;
import com.sojson.common.utils.JsonUtils;
import com.sojson.open.service.AnswerRecordService;

/**
 * @author huanjun
 * APP答题记录控制器
 */
@Controller
@Scope(value="prototype")
@RequestMapping("open/app")
public class AnswerRecordController {
	@Autowired
	AnswerRecordService answerRecordService;
	
	/**
	 * 存储用户回答每个问题的结果
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="answerRecord/insertAllAnswers",method=RequestMethod.POST)
	public @ResponseBody JSONObject insertAllAnswers(HttpServletRequest request,HttpServletResponse response){
		JSONObject obj = new JSONObject();
		JSONObject data = new JSONObject();
		
		String recordData = request.getParameter("recordListJson");
		System.out.println("后台数据："+recordData);
		//List<AppAnswerRecord> list = converFormString(recordData);
		List<AppAnswerRecord> list = JsonUtils.json2List(recordData, AppAnswerRecord.class);
		int num = answerRecordService.insertBatch(list);
		data.put("num", num);
		obj.put("data", data);
		return obj;
	}
	
	/** 
	  * 将一个json字串转为list 
	  * @param props 
	  * @return 
	  */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<AppAnswerRecord> converFormString(String str){ 
	  if (str == null || str.equals("")) 
		  return new ArrayList(); 
	  
	  JSONArray jsonArray = JSONArray.fromObject(str); 
	  List<AppAnswerRecord> list = (List) JSONArray.toCollection(jsonArray,AppAnswerRecord.class); 
	  return list; 
	 }

	
}
