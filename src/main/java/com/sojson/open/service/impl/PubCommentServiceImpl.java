package com.sojson.open.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sojson.common.dao.AppPubCommentMapper;
import com.sojson.core.mybatis.BaseMybatisDao;
import com.sojson.open.service.PubCommentService;

@Service
public class PubCommentServiceImpl extends BaseMybatisDao<AppPubCommentMapper> implements PubCommentService{
	@Autowired
	private AppPubCommentMapper appPubCommentMapper;
	
}
