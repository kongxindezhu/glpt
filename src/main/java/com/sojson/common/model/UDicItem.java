package com.sojson.common.model;

import java.io.Serializable;

/**
 * 字典项实体类
 * @author huanjun
 *
 */
public class UDicItem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 自增主键
	 */
	private Integer id;
	
	/**
	 * 字典项ID
	 */
	private String itemId;
	
	/**
	 * 字典项名称
	 */
	private String itemName;
	
	private String catalogId;
	
	/**
	 * 所属字典类别
	 */
	private UDicCatalog uDicCatalog;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}
	public UDicCatalog getuDicCatalog() {
		return uDicCatalog;
	}
	public void setuDicCatalog(UDicCatalog uDicCatalog) {
		this.uDicCatalog = uDicCatalog;
	}
	
}
