package com.sojson.open.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sojson.common.dao.AppAnswerRecordMapper;
import com.sojson.core.mybatis.BaseMybatisDao;
import com.sojson.open.service.AnswerRecordService;

@Service
public class AnswerRecordServiceImpl extends BaseMybatisDao<AppAnswerRecordMapper> implements AnswerRecordService{
	@Autowired
	private AppAnswerRecordMapper appAnswerRecordMapper;
}
