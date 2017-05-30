package com.sojson.common.model;

import java.io.Serializable;

public class UDicCatalog implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String catalogId;
	private String catalogName;
	private String catalogType;
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
	public String getCatalogType() {
		return catalogType;
	}
	public void setCatalogType(String catalogType) {
		this.catalogType = catalogType;
	}
}
