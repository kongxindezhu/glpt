package com.sojson.common.model;

import java.sql.Date;

public class AppExeScore {
	/***id*/
	private Integer id;
	/** 用户主键*/
	private String uuid;
	/***课程集主键cid*/
	private Integer cid;
	/**开始答题时间，精确到秒**/
	private Date datetime;
	/***本次练习得分*/
	private Integer curScore;
	/***本次练习时长*/
	private Integer curTime;
	
	private Integer totalTime; //用户在当前课程大类下的累计练习时长
	private Integer totalScore; //用户在当前课程大类下的累计得分
	
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
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public Integer getCurScore() {
		return curScore;
	}
	public void setCurScore(Integer curScore) {
		this.curScore = curScore;
	}
	public Integer getCurTime() {
		return curTime;
	}
	public void setCurTime(Integer curTime) {
		this.curTime = curTime;
	}
	public Integer getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(Integer totalTime) {
		this.totalTime = totalTime;
	}
	public Integer getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}
	
}
