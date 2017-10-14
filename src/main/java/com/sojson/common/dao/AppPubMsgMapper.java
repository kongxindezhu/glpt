package com.sojson.common.dao;

import com.sojson.common.model.AppPubMsg;

public interface AppPubMsgMapper {

	int insertMsg(AppPubMsg item);

	int deleteMsg(int pubId);

}
