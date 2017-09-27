package com.sojson.open.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
