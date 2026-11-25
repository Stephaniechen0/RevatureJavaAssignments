package com.cts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UseLogging {
	private static final Logger logger = LoggerFactory.getLogger(UseLogging.class);
	
	public static void main(String[] args) {
		System.out.println("App started");
		logger.trace("This is trace");
		logger.debug("This is debug");
		logger.info("This is info");
		logger.error("This is error");
		System.out.println("App completed");
	}

}
