package com.sojson.open.controller;

import com.sojson.common.utils.HttpRequestUtil;

public class TestApi {

	public static void main(String[] args) {
        //demo:代理访问
        /*String url1 = "http://www.zhanghenginfo.com/glpt/open/test/api1.shtml";
        String para1 = "name=zhangheng&company=zhanghenginfo";
        String sr1=HttpRequestUtil.sendGet(url1,para1);
        System.out.println(sr1);
        
        System.out.println("******************************");
        
        String url2 = "http://www.zhanghenginfo.com/glpt/open/test/api2.shtml";
        String para2 = "name=zhangheng&company=zhanghenginfo";
        //String sr2=HttpRequestUtil.sendPost(url2,para2,true);
        String sr2=HttpRequestUtil.sendPost(url2,para2,false);
        System.out.println(sr2);
        
        String url3 = "http://localhost:8080/glpt/open/test/api2.shtml";
        String para3 = "name=zhangheng&company=zhanghenginfo";
        String sr3=HttpRequestUtil.sendPost(url3,para3,true);
        System.out.println(sr3);*/
        
        /*String url1 = "http://localhost:8080/glpt/open/app/user/generateVerifyCode.shtml";
        String para1 = "";
        String sr1=HttpRequestUtil.sendGet(url1,para1);
        System.out.println(sr1);*/
        
        /*String url2 = "http://localhost:8080/glpt/open/app/user/validatePhoneAndCode.shtml";
        String para2 = "phone=123456&verifyCode=555";
        String sr2=HttpRequestUtil.sendGet(url2,para2);
        System.out.println(sr2);*/
		
		/*String url1 = "http://localhost:8080/glpt/open/app/user/login.shtml";
        String para1 = "phone=123&phoneVerifyCode=1111&regDevice=dev1";
        String sr1=HttpRequestUtil.sendPost(url1,para1,true);
        System.out.println(sr1);*/
		
		/*String url1 = "http://localhost:8080/glpt/open/app/user/queryDegreeTypes.shtml";
        String para1 = "";
        String sr1=HttpRequestUtil.sendGet(url1,para1);
        System.out.println(sr1);*/
		
		
		String url1 = "http://localhost:8080/glpt/open/app/user/completeUserInfo.shtml";
        String para1 = "phone=123&nickname=和静清寂&email=kongxindezhu@163.com&sex=1&degree=1";
        String sr1=HttpRequestUtil.sendPost(url1,para1,true);
        System.out.println(sr1);
        
    }

}
