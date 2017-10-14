package com.sojson.open.service;

import javax.servlet.http.HttpServletRequest;

public interface PubMsgService {

	int insertMsg(HttpServletRequest request);

	int deleteMsg(HttpServletRequest request);

}
