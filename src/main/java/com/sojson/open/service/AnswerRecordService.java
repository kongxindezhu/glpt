package com.sojson.open.service;

import java.util.List;

import com.sojson.common.model.AppAnswerRecord;


public interface AnswerRecordService {

	int insertBatch(List<AppAnswerRecord> list);

}
