package com.sojson.open.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

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

	@Override
	public int insertExeScore(AppExeScore item) {
		Timestamp ts = new Timestamp(System.currentTimeMillis());   
        String tsStr = item.getDatetimeStr();   
        try {   
            ts = Timestamp.valueOf(tsStr);   
            System.out.println(ts);   
        } catch (Exception e) {   
            e.printStackTrace();   
        } 
		item.setTime(ts);
		return appExeScoreMapper.insertExeScore(item);
	}

	@Override
	public int queryUserSumTime(String uuid) {
		return appExeScoreMapper.queryUserSumTime(uuid);
	}

	@Override
	public List<AppExeScore> queryDateScoreData(String uuid) {
		return appExeScoreMapper.queryDateScoreData(uuid);
	}

	@Override
	public List<AppExeScore> queryDateTimeData(String uuid) {
		return appExeScoreMapper.queryDateTimeData(uuid);
	}

	/*@Override
	public int queryUserCourseSetById(int courseSetId, String uuid) {
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("courseSetId", courseSetId);
		params.put("uuid", uuid);
		return appExeScoreMapper.queryUserCourseSetById(params);
	}*/
}
