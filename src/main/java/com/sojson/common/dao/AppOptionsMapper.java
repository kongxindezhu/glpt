package com.sojson.common.dao;

import java.util.List;

import com.sojson.common.model.AppOptions;

public interface AppOptionsMapper {

	List<AppOptions> queryOptionsByQid(Integer qid);

}
