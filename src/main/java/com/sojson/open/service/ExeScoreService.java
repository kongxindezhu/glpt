package com.sojson.open.service;

import com.sojson.common.model.AppExeScore;

public interface ExeScoreService {

	AppExeScore queryTotalTimeAndScore(int catalogId, String uuid);

	int queryUserRank(String uuid);

	/*int queryUserCourseSetById(int courseSetId, String uuid);*/

}
