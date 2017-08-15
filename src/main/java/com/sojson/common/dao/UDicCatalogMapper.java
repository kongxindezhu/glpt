package com.sojson.common.dao;

import java.util.List;

import com.sojson.common.model.UDicCatalog;

public interface UDicCatalogMapper {

	int insertSelective(UDicCatalog record);

	int deleteByPrimaryKey(Long id);

	List<UDicCatalog> queryCatalogList();
	
}
