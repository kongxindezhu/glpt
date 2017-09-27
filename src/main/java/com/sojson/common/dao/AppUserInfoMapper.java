package com.sojson.common.dao;

import com.sojson.common.model.AppUserInfo;

public interface AppUserInfoMapper {

	public AppUserInfo queryUserInfoByPhone(String phone);

	public void insertUserInfo(AppUserInfo user);

	public int updateUserInfo(AppUserInfo user);

	public Integer queryUserNum();

}
