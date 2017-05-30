package com.sojson.user.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sojson.common.dao.UDicCatalogMapper;
import com.sojson.common.dao.UPermissionMapper;
import com.sojson.common.model.UDicCatalog;
import com.sojson.core.mybatis.BaseMybatisDao;
import com.sojson.core.mybatis.page.Pagination;
import com.sojson.user.service.UDicCatalogService;

@Service
public class UDicCatalogServiceImpl extends BaseMybatisDao<UDicCatalogMapper> implements UDicCatalogService{
	
	@Autowired
	UDicCatalogMapper uDicCatalogMapper;
	
	@SuppressWarnings("unchecked")
	@Override
	public Pagination<UDicCatalog> findByPage(Map<String, Object> resultMap, Integer pageNo, int pageSize) {
		return super.findPage(resultMap, pageNo, pageSize);
	}
	
	@Override
	public UDicCatalog insert(UDicCatalog record){
		//uDicCatalogMapper.insert(record);
		return record;
	}
}
