package com.fes.common.log;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class LogPool {

	private static Logger log = Logger.getLogger("bqlogger");
	private static Map<Long, StringBuffer> LogMap = new HashMap<Long, StringBuffer>();

	
	public static Logger getLog() {
		return log;
	}
	
	public static Map<Long, StringBuffer> getLogMap() {
		return LogMap;
	}
}
