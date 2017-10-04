package com.sojson.open.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sojson.common.dao.AppAnswerRecordMapper;
import com.sojson.common.model.AppAnswerRecord;
import com.sojson.core.mybatis.BaseMybatisDao;
import com.sojson.open.service.AnswerRecordService;

@Service
public class AnswerRecordServiceImpl extends BaseMybatisDao<AppAnswerRecordMapper> implements AnswerRecordService{
	@Autowired
	private AppAnswerRecordMapper appAnswerRecordMapper;

	@Override
	public int insertBatch(List<AppAnswerRecord> list) {
		for(AppAnswerRecord item : list){
			Timestamp ts = new Timestamp(System.currentTimeMillis());   
	        String tsStr = item.getDatetimeStr();   
	        try {   
	            ts = Timestamp.valueOf(tsStr);   
	            System.out.println(ts);   
	        } catch (Exception e) {   
	            e.printStackTrace();   
	        } 
			item.setTime(ts);
		}
		return appAnswerRecordMapper.insertBatch(list);
	}
}
