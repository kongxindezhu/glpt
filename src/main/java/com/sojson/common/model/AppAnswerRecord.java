package com.sojson.common.model;

import java.sql.Date;

public class AppAnswerRecord {
	/***自增主键*/
	private Integer id;
	/***用户主键*/
	private String uuid;
	/***问题表主键*/
	private Integer qid;
	/**开始答题时间，精确到秒**/
	private Date datetime;
	/**答案是否正确：1正确0错误**/
	private String res;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Integer getQid() {
		return qid;
	}
	public void setQid(Integer qid) {
		this.qid = qid;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}
	
}
