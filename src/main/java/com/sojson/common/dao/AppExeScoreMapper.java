package com.sojson.common.dao;

import java.util.HashMap;
import java.util.List;

import com.sojson.common.model.AppExeScore;

public interface AppExeScoreMapper {

	AppExeScore queryTotalTimeAndScore(HashMap<String, Object> params);

	int queryUserRank(String uuid);

	int insertExeScore(AppExeScore appExeScore);

	int queryUserSumTime(String uuid);

	List<AppExeScore> queryDateScoreData(String uuid);

	List<AppExeScore> queryDateTimeData(String uuid);

	/*int queryUserCourseSetById(HashMap<String, Object> params);*/

}
