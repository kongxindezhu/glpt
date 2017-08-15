package com.sojson.common.model;

import java.io.Serializable;

/**
 * 字典类别实体类
 * @author huanjun
 *
 */
public class UDicCatalog implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 自增主键
	 */
	private Integer id;
	
	/**
	 * 字典类别ID
	 */
	private String catalogId;
	
	/**
	 * 字典类别名称
	 */
	private String catalogName;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}
	public String getCatalogName() {
		return catalogName;
	}
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}
}
