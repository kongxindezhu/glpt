package com.sojson.user.service;

import java.util.Map;

import com.sojson.common.model.UDicCatalog;
import com.sojson.core.mybatis.page.Pagination;

public interface UDicCatalogService {

	Pagination<UDicCatalog> findByPage(Map<String, Object> resultMap, Integer pageNo, int pageSize);

	UDicCatalog insert(UDicCatalog record);

}
