package com.sojson.common.dao;

import java.util.List;

import com.sojson.common.model.UDicItem;


public interface UDicItemMapper {

	int insertSelective(UDicItem record);

	List<UDicItem> queryDicItemByCatalogId(String catalogId);
	
}