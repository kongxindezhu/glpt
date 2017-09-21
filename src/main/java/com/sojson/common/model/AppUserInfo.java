package com.sojson.common.model;

import java.sql.Timestamp;

public class AppUserInfo {
	
	/**
	 * 用户主键
	 */
	private String uuid;

	/**
	 * 昵称
	 */
	private String nickname;
	
	/**
	 * 手机号码
	 */
	private String phone;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 性别：男1女0
	 */
	private String sex;
	
	/**
	 * 学历：1研究生、2本科、3高中、4初中、5小学、6其他
	 */
	private String degree;
	
	/**
	 * 职业
	 */
	private String occupation;
	
	/**
	 * 头像图片存储路径
	 */
	private String portrait;
	
	/**
	 * 用户注册的设备ID
	 */
	private String regDevice;
	
	/**
	 * 注册时间
	 */
	private Timestamp regTime;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public String getRegDevice() {
		return regDevice;
	}

	public void setRegDevice(String regDevice) {
		this.regDevice = regDevice;
	}

	public Timestamp getRegTime() {
		return regTime;
	}

	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}
	
}
