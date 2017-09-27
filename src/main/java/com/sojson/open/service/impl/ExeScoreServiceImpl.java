package com.sojson.open.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sojson.common.dao.AppExeScoreMapper;
import com.sojson.common.model.AppExeScore;
import com.sojson.core.mybatis.BaseMybatisDao;
import com.sojson.open.service.ExeScoreService;

@Service
public class ExeScoreServiceImpl extends BaseMybatisDao<AppExeScoreMapper> implements ExeScoreService{
	@Autowired
	private AppExeScoreMapper appExeScoreMapper;

	@Override
	public AppExeScore queryTotalTimeAndScore(int catalogId, String uuid) {
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("catalogId", catalogId);
		params.put("uuid", uuid);
		return appExeScoreMapper.queryTotalTimeAndScore(params);
	}

	@Override
	public int queryUserRank(String uuid) {
		return appExeScoreMapper.queryUserRank(uuid);
	}

	/*@Override
	public int queryUserCourseSetById(int courseSetId, String uuid) {
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("courseSetId", courseSetId);
		params.put("uuid", uuid);
		return appExeScoreMapper.queryUserCourseSetById(params);
	}*/
}
