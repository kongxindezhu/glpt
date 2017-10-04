package com.sojson.open.service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

import com.sojson.common.model.AppExeScore;

public interface ExeScoreService {

	AppExeScore queryTotalTimeAndScore(int catalogId, String uuid);

	int queryUserRank(String uuid);

	int insertExeScore(AppExeScore item);

	int queryUserSumTime(String uuid);

	List<AppExeScore> queryDateScoreData(String uuid);

	List<AppExeScore> queryDateTimeData(String uuid);

	/*int queryUserCourseSetById(int courseSetId, String uuid);*/

}
