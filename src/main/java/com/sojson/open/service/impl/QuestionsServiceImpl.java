package com.sojson.open.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sojson.common.dao.AppQuestionsMapper;
import com.sojson.core.mybatis.BaseMybatisDao;
import com.sojson.open.service.QuestionsService;

@Service
public class QuestionsServiceImpl extends BaseMybatisDao<AppQuestionsMapper> implements QuestionsService{
	@Autowired
	private AppQuestionsMapper appQuestionsMapper;
}
