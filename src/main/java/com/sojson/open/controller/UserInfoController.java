package com.sojson.open.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sojson.common.controller.BaseController;
import com.sojson.open.service.UserInfoService;


/**
 * @author huanjun
 * APP用户登录or注册控制器
 */
@Controller
@Scope(value="prototype")
@RequestMapping("open")
public class UserInfoController extends BaseController{
	
	@Autowired
	UserInfoService userInfoService;
	
	
	
	
}
