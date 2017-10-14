package com.sojson.open.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.sojson.open.service.PubMsgService;

@Controller
@Scope(value="prototype")
@RequestMapping("open/app")
public class PubMsgController{
	@Autowired
	private PubMsgService pubMsgService;
	
	/**
	 * 存储用户发布的说说
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="pubMsg/insertMsg",method=RequestMethod.POST)
	public @ResponseBody JSONObject insertMsg(HttpServletRequest request,HttpServletResponse response){
		JSONObject obj = new JSONObject();
		JSONObject data = new JSONObject();
		
		int num = pubMsgService.insertMsg(request); //待添加说说图片的方法
		data.put("num", num);
		obj.put("data", data);
		return obj;
	}
	
	/**
	 * 删除用户发布的说说
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="pubMsg/deleteMsg",method=RequestMethod.GET)
	public @ResponseBody JSONObject deleteMsg(HttpServletRequest request,HttpServletResponse response){
		JSONObject obj = new JSONObject();
		JSONObject data = new JSONObject();
		
		int num = pubMsgService.deleteMsg(request);
		data.put("num", num);
		obj.put("data", data);
		return obj;
	}
	
}
