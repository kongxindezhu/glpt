package com.sojson.user.service;

import java.util.List;
import java.util.Map;

import com.sojson.common.model.UDicCatalog;
import com.sojson.core.mybatis.page.Pagination;

public interface UDicCatalogService {

	/**
	 * 分页查询
	 * @param resultMap
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	Pagination<UDicCatalog> findByPage(Map<String, Object> resultMap, Integer pageNo, int pageSize);

	/**
	 * 新增单个字典类别
	 * @param record
	 * @return
	 */
	UDicCatalog insertSelective(UDicCatalog record);
	
	/**
	 * 删除单个字典类别
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * 批量删除多个类别
	 * @param ids
	 * @return
	 */
	Map<String, Object> deleteDicCatalogById(String ids);

	/**
	 * 查询所有的字典类别列表
	 * @return
	 */
	List<UDicCatalog> queryCatalogList();
	

}
