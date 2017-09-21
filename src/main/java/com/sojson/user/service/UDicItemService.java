package com.sojson.user.service;

import java.util.List;
import java.util.Map;

import com.sojson.common.model.UDicItem;
import com.sojson.core.mybatis.page.Pagination;

public interface UDicItemService {
	Pagination<UDicItem> findByPage(Map<String, Object> resultMap, Integer pageNo, int pageSize);

	UDicItem insertSelective(UDicItem uDicItem);

	List<UDicItem> queryDicItemByCatalogId(String catalogId);
}
