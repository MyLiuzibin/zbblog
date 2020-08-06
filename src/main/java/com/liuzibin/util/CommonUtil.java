package com.liuzibin.util;


import java.util.UUID;

public class CommonUtil {

	public synchronized static String buildUuid(){
		return UUID.randomUUID().toString().replaceAll(WebConstants.DASH, "").toUpperCase();
	}

}
