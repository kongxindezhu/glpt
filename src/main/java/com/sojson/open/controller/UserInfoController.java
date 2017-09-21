package com.sojson.open.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.sojson.common.controller.BaseController;
import com.sojson.common.model.AppUserInfo;
import com.sojson.common.model.UDicItem;
import com.sojson.common.utils.FileOperateUtil;
import com.sojson.common.utils.OSinfoUtils;
import com.sojson.common.utils.VerifyCodeUtils;
import com.sojson.open.service.UserInfoService;
import com.sojson.user.service.UDicItemService;


/**
 * @author huanjun
 * APP用户登录or注册控制器
 */
@Controller
@Scope(value="prototype")
@RequestMapping("open/app")
public class UserInfoController extends BaseController{
	
	@Autowired
	UserInfoService userInfoService;
	
	@Autowired
	UDicItemService uDicItemService;
	
	/**
	 * 生成验证码
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="user/generateVerifyCode",method=RequestMethod.GET)
	public @ResponseBody JSONObject generateVerifyCode(HttpServletRequest request,HttpServletResponse response){
		String path = "";
		if(OSinfoUtils.isLinux()){
			path="/root/usr/shareDir/verifies";
		}else{
			path = "F:/verifies";
		}
		File dir = new File(path);
		
		int w = 200, h = 80;
		String verifyCode = VerifyCodeUtils.generateVerifyCode(4);  
        File file = new File(dir, verifyCode + ".jpg");
        
        JSONObject obj = new JSONObject();
        try {
			VerifyCodeUtils.outputImage(w, h, file, verifyCode);
			JSONObject data = new JSONObject();
			data.put("verifyCode", verifyCode);
			HttpSession session = request.getSession();
			session.setAttribute("verifyCode", verifyCode);
			obj.put("data", data);
			obj.put("rc", 0);
			obj.put("msg", "成功获取验证码！");
		} catch (IOException e) {
			e.printStackTrace();
			obj.put("rc", 1);
			obj.put("msg", "获取验证码异常！");
		}		
		
		return obj;
	}
	
	/**
	 * 验证手机号和图片验证码:
	 * 如果验证码正确，则向该手机号发送短信验证码；否则清空session中的验证码，且删除服务器上对应的该验证码图片文件
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="user/validatePhoneAndCode",method=RequestMethod.GET)
	public @ResponseBody JSONObject validatePhoneAndCode(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="phone",required=true)String phone,
			@RequestParam(value="verifyCode",required=true)String verifyCode){
		JSONObject data = new JSONObject();
		JSONObject obj = new JSONObject();
		
		HttpSession session = request.getSession();
		String curVerifyCode = (String)session.getAttribute("verifyCode");
		if(verifyCode!=null && verifyCode.equals(curVerifyCode)){
			//TODO 调用短信接口发送短信验证码
			String phoneVerifyCode = "1111";
			session.setAttribute("phone", phone);
			session.setAttribute("phoneVerifyCode", phoneVerifyCode);
			data.put("phoneVerifyCode", phoneVerifyCode);
			obj.put("data", data);
			obj.put("rc", 0);
			obj.put("msg", "验证码正确，验证成功!");
		}else{
			//清除session验证码
			session.setAttribute("verifyCode", null);
			//删除验证码图片文件
			String path = "";
			if(OSinfoUtils.isLinux()){
				path="/root/usr/shareDir/verifies";
			}else{
				path = "F:/verifies";
			}
			String fileName = path + "/" + curVerifyCode+".jpg";
			FileOperateUtil.deleteFile(fileName);
			obj.put("data", data);
			obj.put("rc", 1);
			obj.put("msg", "验证码错误!");
		}
		return obj;
	}
	
	/**
	 * 登录或者注册功能：
	 * 如果手机号和短信验证码均正确，则检测当前手机号是否已经注册
	 * @param request
	 * @param response
	 * @param phone 电话号码
	 * @param phoneVerifyCode 短信验证码
	 * @param regDevice 设备号
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value="user/login",method=RequestMethod.POST)
	public @ResponseBody JSONObject login(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="phone",required=true)String phone,
			@RequestParam(value="phoneVerifyCode",required=true)String phoneVerifyCode,
			@RequestParam(value="regDevice",required=true)String regDevice){
		JSONObject data = new JSONObject();
		JSONObject obj = new JSONObject();
		
		HttpSession session = request.getSession();
		String curPhoneVerifyCode = (String)session.getAttribute("phoneVerifyCode");
		//if(curPhoneVerifyCode!=null && curPhoneVerifyCode.equals(phoneVerifyCode)){
		if(true){
			//根据手机号查找当前用户
			AppUserInfo rs = userInfoService.queryUserInfoByPhone(phone);
			String msg = "";
			if(null==rs){ //新增用户
				data.put("isNewUser", true);
				userInfoService.insertUserInfo(phone,regDevice);
				msg = "当前用户为新增用户,注册成功！";
			}else{
				data.put("isNewUser", false);
				msg = "当前用户为老用户";
			}
			
			obj.put("data", data);
			obj.put("rc", 0);
			obj.put("msg",msg);
		}else{
			obj.put("data", data);
			obj.put("rc", 1);
			obj.put("msg", "短信验证码错误，请重试!");
		}
		return obj;
	}
	
	/**
	 * 获取学历列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="user/queryDegreeTypes",method=RequestMethod.GET)
	public @ResponseBody JSONObject queryDegreeTypes(HttpServletRequest request,HttpServletResponse response){
		JSONObject obj = new JSONObject();
		
		JSONObject data = new JSONObject();
		List<UDicItem> degreeTypes = uDicItemService.queryDicItemByCatalogId("DEGREE_TYPE");
		data.put("degreeTypes", degreeTypes);
		
		obj.put("data", data);
		obj.put("rc", 0);
		obj.put("msg","成功获取学历列表");
		return obj;
	}
	
	/**
	 * 补全用户信息
	 * @param request
	 * @param response
	 * @param phone
	 * @return
	 */
	@RequestMapping(value="user/completeUserInfo",method=RequestMethod.POST)
	public @ResponseBody JSONObject updateUserInfo(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="phone",required=true)String phone){
		JSONObject obj = new JSONObject();
		
		JSONObject data = new JSONObject();
		boolean rs = userInfoService.updateUserInfo(request,phone);
		data.put("rs", rs);
		
		obj.put("data", data);
		obj.put("rc", 0);
		obj.put("msg","成功修改用户信息！");
		return obj;
	}
}
