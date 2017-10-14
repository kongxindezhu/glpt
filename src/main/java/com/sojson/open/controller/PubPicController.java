package com.sojson.open.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sojson.common.controller.BaseController;
import com.sojson.open.service.PubPicService;

@Controller
@Scope(value="prototype")
@RequestMapping("open/app")
public class PubPicController extends BaseController{
	@Autowired
	private PubPicService pubPicService;
}
