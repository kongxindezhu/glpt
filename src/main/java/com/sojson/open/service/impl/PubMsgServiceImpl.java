package com.sojson.open.service.impl;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sojson.common.dao.AppPubMsgMapper;
import com.sojson.common.model.AppPubMsg;
import com.sojson.core.mybatis.BaseMybatisDao;
import com.sojson.open.service.PubMsgService;

@Service
public class PubMsgServiceImpl extends BaseMybatisDao<AppPubMsgMapper> implements PubMsgService{
	@Autowired
	private AppPubMsgMapper appPubMsgMapper;

	@Override
	public int insertMsg(HttpServletRequest request) {
		AppPubMsg item = new AppPubMsg();
		String uuid = request.getParameter("uuid");
		String pubWord = request.getParameter("pubWord");
		String pubTimeStr = request.getParameter("pubTime");
		Timestamp pubTime = new Timestamp(System.currentTimeMillis());   
        try {   
        	pubTime = Timestamp.valueOf(pubTimeStr);   
            System.out.println(pubTimeStr);   
        } catch (Exception e) {   
            e.printStackTrace();   
        }
        item.setUuid(uuid);
        item.setPubWord(pubWord);
        item.setPubTime(pubTime);
		return appPubMsgMapper.insertMsg(item);
	}

	@Override
	public int deleteMsg(HttpServletRequest request) {
		int pubId = Integer.valueOf(request.getParameter("pubId"));
		return appPubMsgMapper.deleteMsg(pubId);
	}
}
