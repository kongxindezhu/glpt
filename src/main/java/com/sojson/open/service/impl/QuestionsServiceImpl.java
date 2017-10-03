package com.sojson.open.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sojson.common.dao.AppOptionsMapper;
import com.sojson.common.dao.AppQuestionsMapper;
import com.sojson.common.model.AppOptions;
import com.sojson.common.model.AppQuestions;
import com.sojson.core.mybatis.BaseMybatisDao;
import com.sojson.open.service.QuestionsService;

@Service
public class QuestionsServiceImpl extends BaseMybatisDao<AppQuestionsMapper> implements QuestionsService{
	@Autowired
	private AppQuestionsMapper appQuestionsMapper;
	
	@Autowired
	private AppOptionsMapper appOptionsMapper;

	@Override
	public List<AppQuestions> queryAllQuestions() {
		List<AppQuestions> list = appQuestionsMapper.queryAllQuestions();
		//List<AppOptions> options = appOptionsMapper.queryOptionsByQid(1001);
		for(AppQuestions item:list){
			Integer qid = item.getId();
			List<AppOptions> options = appOptionsMapper.queryOptionsByQid(qid);
			item.setOptions(options);
		}
		return list;
	}
}
