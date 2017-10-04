package com.sojson.open.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import net.sf.json.JSONObject;

import com.sojson.common.model.AppExeScore;
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
		
		
		/*String url1 = "http://localhost:8080/glpt/open/app/user/completeUserInfo.shtml";
        String para1 = "phone=123&nickname=和静清寂&email=kongxindezhu@163.com&sex=1&degree=1";
        String sr1=HttpRequestUtil.sendPost(url1,para1,true);
        System.out.println(sr1);*/
        
		/*String url1 = "http://localhost:8080/glpt/open/app/course/queryAllCatalogState.shtml";
        String para1 = "uuid=e18107e1f1bc4cfb969ca9538c4e9004";
        String sr1=HttpRequestUtil.sendGet(url1,para1);
        System.out.println(sr1);*/
		
		/*String url1 = "http://localhost:8080/glpt/open/app/course/queryAllTaskState.shtml";
        String para1 = "uuid=e18107e1f1bc4cfb969ca9538c4e9004&catalogId=1";
        String sr1=HttpRequestUtil.sendGet(url1,para1);
        System.out.println(sr1);*/
		
		/*String url1 = "http://localhost:8080/glpt/open/app/course/queryAllCourseSetState.shtml";
        String para1 = "uuid=e18107e1f1bc4cfb969ca9538c4e9004&taskId=20";
        String sr1=HttpRequestUtil.sendGet(url1,para1);
        System.out.println(sr1);*/
        
        /*String url1 = "http://localhost:8080/glpt/open/app/course/queryAllCourseBlock.shtml";
        String para1 = "courseSetId=1001";
        String sr1=HttpRequestUtil.sendGet(url1,para1);
        System.out.println(sr1);*/
		
		/*String url1 = "http://localhost:8080/glpt/open/app/course/queryAllCourse.shtml";
        String para1 = "blockId=1000101";
        String sr1=HttpRequestUtil.sendGet(url1,para1);
        System.out.println(sr1);*/
		
		/*String url1 = "http://localhost:8080/glpt/open/app/questions/queryAllQuestions.shtml";
        String para1 = "";
        String sr1=HttpRequestUtil.sendGet(url1,para1);
        System.out.println(sr1);*/
        
        //list--》》json字符串
		/**Timestamp ts = new Timestamp(System.currentTimeMillis());   
        String datetimeStr = "";   
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
        try {   
        	datetimeStr = sdf.format(ts);   
        } catch (Exception e) {   
            e.printStackTrace();   
        }  
        
        List<AppAnswerRecord> list = new ArrayList<AppAnswerRecord>();
        AppAnswerRecord item0=new AppAnswerRecord();
        item0.setQid(1);
        item0.setUuid("e18107e1f1bc4cfb969ca9538c4e9004");
        item0.setDatetimeStr(datetimeStr);
        item0.setRes("1");
        
        AppAnswerRecord item1=new AppAnswerRecord();
        item1.setQid(2);
        item1.setUuid("e18107e1f1bc4cfb969ca9538c4e9004");
        item1.setDatetimeStr(datetimeStr);
        item1.setRes("0");
        
        list.add(item0);
        list.add(item1);
        
        JSONArray jsonArray = JSONArray.fromObject(list);
        String jsonStr = jsonArray.toString();
        System.out.println(jsonStr);

        String url1 = "http://localhost:8080/glpt/open/app/answerRecord/insertAllAnswers.shtml";
        String para1 = "recordListJson="+jsonStr;
        String sr1=HttpRequestUtil.sendPost(url1,para1,true);
        System.out.println(sr1);
        **/
		
		/**
		Timestamp ts = new Timestamp(System.currentTimeMillis());   
        String datetimeStr = "";   
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
        try {   
        	datetimeStr = sdf.format(ts);   
        } catch (Exception e) {   
            e.printStackTrace();   
        }  
        
        AppExeScore item0=new AppExeScore();
        item0.setCid(1001);
        item0.setUuid("e18107e1f1bc4cfb969ca9538c4e9004");
        item0.setDatetimeStr(datetimeStr);
        item0.setCurTime(12458);
        item0.setCurScore(67);
        
        JSONObject obj = JSONObject.fromObject(item0);
        String jsonStr = obj.toString();
        System.out.println(jsonStr);
        
        String url1 = "http://localhost:8080/glpt/open/app/exeScore/insertExeScore.shtml";
        String para1 = "recordJson="+jsonStr;
        String sr1=HttpRequestUtil.sendPost(url1,para1,true);
        System.out.println(sr1);
        **/
		
		/*String url1 = "http://localhost:8080/glpt/open/app/exeScore/querySumUserInfo.shtml";
        String para1 = "uuid=e18107e1f1bc4cfb969ca9538c4e9004&taskId=20";
        String sr1=HttpRequestUtil.sendGet(url1,para1);
        System.out.println(sr1);*/
		
		String url1 = "http://localhost:8080/glpt/open/app/exeScore/queryDateScoreLine.shtml";
        String para1 = "uuid=e18107e1f1bc4cfb969ca9538c4e9004";
        String sr1=HttpRequestUtil.sendGet(url1,para1);
        System.out.println(sr1);
        
        /*String url1 = "http://localhost:8080/glpt/open/app/exeScore/queryDateTimeLine.shtml";
        String para1 = "uuid=e18107e1f1bc4cfb969ca9538c4e9004";
        String sr1=HttpRequestUtil.sendGet(url1,para1);
        System.out.println(sr1);*/
        
    }

}
