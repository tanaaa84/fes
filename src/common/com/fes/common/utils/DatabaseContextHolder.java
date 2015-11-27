package com.fes.common.utils;

import org.springframework.util.Assert;

public class DatabaseContextHolder {

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	public static void setDatabaseType(String databaseType) {
		Assert.notNull(databaseType, "databaseType cannot be null");
		contextHolder.set(databaseType);
	}

	public static String getDatabaseType() {
		return (String) contextHolder.get();
	}

	public static void clearDatabaseType() {
		contextHolder.remove();
	}
}