package com.sojson.open.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sojson.common.dao.AppOptionsMapper;
import com.sojson.core.mybatis.BaseMybatisDao;
import com.sojson.open.service.OptionsService;

@Service
public class OptionsServiceImpl extends BaseMybatisDao<AppOptionsMapper> implements OptionsService{
	@Autowired
	private AppOptionsMapper appOptionsMapper;
}
