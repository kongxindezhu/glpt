package com.sojson.common.dao;

import java.util.HashMap;

import com.sojson.common.model.AppExeScore;

public interface AppExeScoreMapper {

	AppExeScore queryTotalTimeAndScore(HashMap<String, Object> params);

	int queryUserRank(String uuid);

	/*int queryUserCourseSetById(HashMap<String, Object> params);*/

}
