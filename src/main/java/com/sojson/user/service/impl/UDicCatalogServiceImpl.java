package com.sojson.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sojson.common.dao.UDicCatalogMapper;
import com.sojson.common.model.UDicCatalog;
import com.sojson.common.utils.LoggerUtils;
import com.sojson.common.utils.StringUtils;
import com.sojson.core.mybatis.BaseMybatisDao;
import com.sojson.core.mybatis.page.Pagination;
import com.sojson.user.service.UDicCatalogService;

@Service
public class UDicCatalogServiceImpl extends BaseMybatisDao<UDicCatalogMapper> implements UDicCatalogService{
	
	@Autowired
	UDicCatalogMapper uDicCatalogMapper;
	
	/**
	 * 分页查询
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Pagination<UDicCatalog> findByPage(Map<String, Object> resultMap, Integer pageNo, int pageSize) {
		return super.findPage(resultMap, pageNo, pageSize);
	}
	
	/**
	 * 新增单个字典类别
	 */
	@Override
	public UDicCatalog insertSelective(UDicCatalog record) {
		//添加权限
		uDicCatalogMapper.insertSelective(record);
		//每添加一个权限，都往【系统管理员 	888888】里添加一次。保证系统管理员有最大的权限
		//executePermission(new Long(1), String.valueOf(record.getId()));
		return record;
	}
	
	/**
	 * 删除单个字典类别
	 */
	@Override
	public int deleteByPrimaryKey(Long id) {
		return uDicCatalogMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 批量删除字典类别
	 */
	@Override
	public Map<String, Object> deleteDicCatalogById(String ids) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			String[] idArray = new String[]{};
			if(StringUtils.contains(ids, ",")){
				idArray = ids.split(",");
			}else{
				idArray = new String[]{ids};
			}
			
			for (String idx : idArray) {
				Long id = new Long(idx);
				this.deleteByPrimaryKey(id);
			}
			resultMap.put("status", 200);
			String resultMsg = "操作成功";
			resultMap.put("resultMsg", resultMsg);
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "根据IDS删除记录出现错误，ids[%s]", ids);
			resultMap.put("status", 500);
			resultMap.put("message", "删除出现错误，请刷新后再试！");
		}
		return resultMap;
	}

	/**
	 * 查询字典类别列表
	 */
	@Override
	public List<UDicCatalog> queryCatalogList() {
		return uDicCatalogMapper.queryCatalogList();
	}
}
