package com.sojson.open.service.impl;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sojson.common.dao.AppUserInfoMapper;
import com.sojson.common.model.AppUserInfo;
import com.sojson.common.utils.UuidUtil;
import com.sojson.core.mybatis.BaseMybatisDao;
import com.sojson.open.service.UserInfoService;

@Service
public class UserInfoServiceImpl extends BaseMybatisDao<AppUserInfoMapper> implements UserInfoService{
	
	@Autowired
	private AppUserInfoMapper appUserInfoMapper;
	
	/**
	 * 根据手机号查询用户信息
	 */
	@Override
	public AppUserInfo queryUserInfoByPhone(String phone){
		return appUserInfoMapper.queryUserInfoByPhone(phone);
	}

	/**
	 * 新增注册用户信息
	 */
	@Override
	public void insertUserInfo(String phone, String regDevice) {
		String uuid = UuidUtil.generateUuid();
		Timestamp regTime = new Timestamp(System.currentTimeMillis());
		
		AppUserInfo user = new AppUserInfo();
		user.setUuid(uuid);
		user.setPhone(phone);
		user.setRegDevice(regDevice);
		user.setRegTime(regTime);
		
		appUserInfoMapper.insertUserInfo(user);
	}

	/**
	 * 修改用户基础信息
	 */
	@Override
	public boolean updateUserInfo(HttpServletRequest request,String phone) {
		AppUserInfo user = appUserInfoMapper.queryUserInfoByPhone(phone);
		String nickname=request.getParameter("nickname");
		String email=request.getParameter("email");
		String sex=request.getParameter("sex");
		String degree=request.getParameter("degree");
		String occupation=request.getParameter("occupation");
		String portrait=request.getParameter("portrait"); //头像图片名称
		//TODO 上传图片文件
		user.setNickname(nickname);
		user.setEmail(email);
		user.setSex(sex);
		user.setDegree(degree);
		user.setOccupation(occupation);
		user.setPortrait(portrait);
		int rs = appUserInfoMapper.updateUserInfo(user);
		if(rs>0)
			return true;
		return false;
	}

	/**
	 * 查询用户数量
	 */
	@Override
	public Integer queryUserNum() {
		return appUserInfoMapper.queryUserNum();
	}

	/**
	 * 更新用户印章信息
	 */
	@Override
	public boolean updateUserSealInfo(HttpServletRequest request, String uuid) {
		AppUserInfo user = appUserInfoMapper.queryUserInfoByUuid(uuid);
		String sealFontType=request.getParameter("sealFontType");
		String sealFontStyle=request.getParameter("sealFontStyle");
		String sealText=request.getParameter("sealText");
		String sealPic=request.getParameter("sealPic");
		user.setSealFontType(sealFontType);
		user.setSealFontStyle(sealFontStyle);
		user.setSealText(sealText);
		user.setSealPic(sealPic);
		int rs = appUserInfoMapper.updateUserSealInfo(user);
		if(rs>0)
			return true;
		return false;
	}

	@Override
	public AppUserInfo queryUserInfoByUuid(String uuid) {
		return appUserInfoMapper.queryUserInfoByUuid(uuid);
	}
}
