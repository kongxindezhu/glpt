package com.sojson.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sojson.common.controller.BaseController;
import com.sojson.common.model.UDicItem;
import com.sojson.core.mybatis.page.Pagination;
import com.sojson.user.service.UDicItemService;

@Controller
@Scope(value="prototype")
@RequestMapping("dic")
public class DicItemController extends BaseController{
	
	@Autowired
	UDicItemService uDicItemService;
	
	/**
	 * 进入字典项管理主页面-列表页
	 * @param map
	 * @param pageNo
	 * @param findContent
	 * @return
	 */
	@RequestMapping(value="item")
	public ModelAndView list(ModelMap map,Integer pageNo,String findContent){
		map.put("findContent", findContent);
		Pagination<UDicItem> page = uDicItemService.findByPage(map,pageNo,pageSize);
		map.put("page", page);
		return new ModelAndView("dic/item");
	}
	
	/**
	 * 新增单个字典项
	 * @param uDicItem
	 * @return
	 */
	@RequestMapping(value="addCatalogItem",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> addCatalogItem(UDicItem uDicItem){
		try {
			UDicItem entity = uDicItemService.insertSelective(uDicItem);
			resultMap.put("status", 200);
			resultMap.put("entity", entity);
			System.out.println(true);
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "添加失败，请刷新后再试！");
		}
		return resultMap;
	}
}
