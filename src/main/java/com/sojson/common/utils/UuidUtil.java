package com.sojson.common.utils;

import java.util.UUID;

/**
 * 生成UUID
 * @author huanjun
 */
public class UuidUtil {
	/**
	 * 生成UUID
	 * @return
	 */
	public static String generateUuid(){
		UUID uuid=UUID.randomUUID();
	    String str = uuid.toString(); 
	    String uuidStr=str.replace("-", "");
	    return uuidStr;
	}
	
}
