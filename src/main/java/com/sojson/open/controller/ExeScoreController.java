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
import com.sojson.common.model.AppExeScore;
import com.sojson.common.utils.JsonUtils;
import com.sojson.open.service.ExeScoreService;

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
}
