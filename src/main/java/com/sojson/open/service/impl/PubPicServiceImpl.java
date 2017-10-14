package com.sojson.open.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sojson.common.dao.AppPubPicMapper;
import com.sojson.core.mybatis.BaseMybatisDao;
import com.sojson.open.service.PubPicService;

@Service
public class PubPicServiceImpl extends BaseMybatisDao<AppPubPicMapper> implements PubPicService{
	@Autowired
	private AppPubPicMapper appPubPicMapper;
}
