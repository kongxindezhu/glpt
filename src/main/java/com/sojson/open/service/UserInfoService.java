package com.sojson.open.service;

import javax.servlet.http.HttpServletRequest;

import com.sojson.common.model.AppUserInfo;

public interface UserInfoService {
	public AppUserInfo queryUserInfoByPhone(String phone);

	public void insertUserInfo(String phone, String regDevice);

	public boolean updateUserInfo(HttpServletRequest request, String phone);

	public Integer queryUserNum();
}
