package com.sojson.common.model;

import java.sql.Timestamp;

public class AppAnswerRecord {
	/***自增主键*/
	private Integer id;
	/***用户主键*/
	private String uuid;
	/***问题表主键*/
	private Integer qid;
	/**开始答题时间，精确到秒**/
	private Timestamp time;
	/**答案是否正确：1正确0错误**/
	private String res;
	
	private String datetimeStr; //答题时间字符串
	
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
	public String getRes() {
		return res;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public void setRes(String res) {
		this.res = res;
	}
	public String getDatetimeStr() {
		return datetimeStr;
	}
	public void setDatetimeStr(String datetimeStr) {
		this.datetimeStr = datetimeStr;
	}
	
}
