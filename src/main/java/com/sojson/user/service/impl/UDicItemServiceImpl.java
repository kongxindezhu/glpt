package com.sojson.user.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sojson.common.dao.UDicItemMapper;
import com.sojson.common.model.UDicItem;
import com.sojson.core.mybatis.BaseMybatisDao;
import com.sojson.core.mybatis.page.Pagination;
import com.sojson.user.service.UDicItemService;

@Service
public class UDicItemServiceImpl extends BaseMybatisDao<UDicItemMapper>  implements UDicItemService {

	@Autowired
	private UDicItemMapper uDicItemMapper;
	
	@SuppressWarnings("unchecked")
	@Override
	public Pagination<UDicItem> findByPage(Map<String, Object> resultMap,
			Integer pageNo, int pageSize) {
		return super.findPage(resultMap, pageNo, pageSize);
	}

	@Override
	public UDicItem insertSelective(UDicItem record) {
		uDicItemMapper.insertSelective(record);
		return record;
	}

	@Override
	public List<UDicItem> queryDicItemByCatalogId(String catalogId) {
		return uDicItemMapper.queryDicItemByCatalogId(catalogId);
	}

}
