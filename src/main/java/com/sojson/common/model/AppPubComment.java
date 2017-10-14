package com.sojson.common.model;

import java.sql.Timestamp;

public class AppPubComment {
	private Integer id;
	private Integer pubId;
	private String uuid;
	private String pubWord;
	private Timestamp pubTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPubId() {
		return pubId;
	}
	public void setPubId(Integer pubId) {
		this.pubId = pubId;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getPubWord() {
		return pubWord;
	}
	public void setPubWord(String pubWord) {
		this.pubWord = pubWord;
	}
	public Timestamp getPubTime() {
		return pubTime;
	}
	public void setPubTime(Timestamp pubTime) {
		this.pubTime = pubTime;
	}
	
}
