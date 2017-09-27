package com.sojson.open.service;

import java.util.List;

import com.sojson.common.model.AppCourse;

public interface CourseService {

	List<AppCourse> queryCourseByLevel(int level);

	List<AppCourse> queryCourseSetByCatalogId(int catalogId);

	Integer queryUserCourseSetNum(int catalogId, String uuid);

	List<AppCourse> queryCourseTaskByPid(Integer catalogId);

	List<AppCourse> queryCourseSetByTaskId(int taskId);

	int queryUserCourseSetNumByTaskId(int taskId, String uuid);

	List<AppCourse> queryCourseSetByPid(int taskId);

	int queryUserCourseSetNumBySetId(int courseSetId, String uuid);

	List<AppCourse> queryItemByPid(Integer pid);

}
