package com.uilzzw.common;

import org.apache.log4j.Logger;

public class ConstantUtils {
	private static final Logger LOGGER = Logger.getLogger(ConstantUtils.class);
	
	public static Logger getLogger() {
		return LOGGER;
	}
	public static String getUserHome(){
		return System.getProperty("user.home");
	}
}
