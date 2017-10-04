package com.sojson.common.dao;

import java.util.List;

import com.sojson.common.model.AppAnswerRecord;

public interface AppAnswerRecordMapper {

	int insertBatch(List<AppAnswerRecord> answerRecordList);

}
