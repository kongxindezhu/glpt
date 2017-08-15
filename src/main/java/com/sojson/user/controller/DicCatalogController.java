package com.sojson.user.controller;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.sojson.common.controller.BaseController;
import com.sojson.common.model.UDicCatalog;
import com.sojson.core.mybatis.page.Pagination;
import com.sojson.user.service.UDicCatalogService;

@Controller
@Scope(value="prototype")
@RequestMapping("dic")
public class DicCatalogController extends BaseController {
	
	@Autowired
	UDicCatalogService uDicService;
	
	@RequestMapping(value="catalog")
	public ModelAndView list(ModelMap map,Integer pageNo,String findContent){
		
		map.put("findContent", findContent);
		Pagination<UDicCatalog> page = uDicService.findByPage(map,pageNo,pageSize);
		map.put("page", page);
		return new ModelAndView("dic/catalog");
	}
	
	
	@RequestMapping(value="addDicCatalog",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addDicCatalog(UDicCatalog uDicCatalog){
		try {
			UDicCatalog entity = uDicService.insertSelective(uDicCatalog);
			resultMap.put("status", 200);
			resultMap.put("entity", entity);
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "添加失败，请刷新后再试！");
		}
		return resultMap;
	}
	
	@RequestMapping(value="deleteDicCatalogById",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> deleteDicCatalogById(String ids){
		return uDicService.deleteDicCatalogById(ids);
	}
	
	/**
	 * 查询所有的字典类别列表
	 */
	@RequestMapping(value="queryCatalogList",method=RequestMethod.GET)
	public void queryCatalogList(HttpServletRequest request,HttpServletResponse response){
		JSONObject obj = new JSONObject();
		List<UDicCatalog> res = uDicService.queryCatalogList();
		obj.put("catalogList", res);
		writeResponse(obj,response);
	}
}