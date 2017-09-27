package com.sojson.open.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sojson.common.dao.AppCourseMapper;
import com.sojson.common.model.AppCourse;
import com.sojson.core.mybatis.BaseMybatisDao;
import com.sojson.open.service.CourseService;

@Service
public class CourseServiceImpl extends BaseMybatisDao<AppCourseMapper> implements CourseService{
	@Autowired
	private AppCourseMapper appCourseMapper;

	@Override
	public List<AppCourse> queryCourseByLevel(int level) {
		return appCourseMapper.queryCourseByLevel(level);
	}

	@Override
	public List<AppCourse> queryCourseSetByCatalogId(int catalogId) {
		return appCourseMapper.queryCourseSetByCatalogId(catalogId);
	}

	@Override
	public Integer queryUserCourseSetNum(int catalogId, String uuid) {
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("catalogId", catalogId);
		params.put("uuid", uuid);
		return appCourseMapper.queryUserCourseSetNum(params);
	}

	@Override
	public List<AppCourse> queryCourseTaskByPid(Integer catalogId) {
		return appCourseMapper.queryCourseTaskByPid(catalogId);
	}

	@Override
	public List<AppCourse> queryCourseSetByTaskId(int taskId) {
		return appCourseMapper.queryCourseSetByTaskId(taskId);
	}

	@Override
	public int queryUserCourseSetNumByTaskId(int taskId, String uuid) {
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("taskId", taskId);
		params.put("uuid", uuid);
		return appCourseMapper.queryUserCourseSetNumByTaskId(params);
	}

	@Override
	public List<AppCourse> queryCourseSetByPid(int taskId) {
		return appCourseMapper.queryCourseSetByPid(taskId);
	}

	@Override
	public int queryUserCourseSetNumBySetId(int courseSetId, String uuid) {
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("courseSetId", courseSetId);
		params.put("uuid", uuid);
		return appCourseMapper.queryUserCourseSetNumBySetId(params);
	}

	@Override
	public List<AppCourse> queryItemByPid(Integer pid) {
		return appCourseMapper.queryItemByPid(pid);
	}
}
