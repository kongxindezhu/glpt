package com.sojson.common.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sojson.common.model.AppCourse;

public interface AppCourseMapper {

	public List<AppCourse> queryCourseByLevel(Integer level);

	public List<AppCourse> queryCourseSetByCatalogId(int catalogId);

	//public Integer queryUserCourseSetNum(@Param("catalogId") int catalogId,@Param("uuid") String uuid);

	public Integer queryUserCourseSetNum(HashMap<String, Object> params);

	public List<AppCourse> queryCourseTaskByPid(Integer catalogId);

	public List<AppCourse> queryCourseSetByTaskId(int taskId);

	public Integer queryUserCourseSetNumByTaskId(HashMap<String, Object> params);

	public List<AppCourse> queryCourseSetByPid(Integer taskId);

	public Integer queryUserCourseSetNumBySetId(HashMap<String, Object> params);

	public List<AppCourse> queryItemByPid(Integer pid);

}
