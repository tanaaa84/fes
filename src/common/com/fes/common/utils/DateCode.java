package com.fes.common.utils;

import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("dateCode")
public class DateCode {
	@Resource
	private JdbcTemplate jdbc;

	public DateUtils dateUtils = new DateUtils();

	public long getDateAll(int num) {
		StringBuffer sb = new StringBuffer();
		Calendar CD = Calendar.getInstance();

		sb.append(CD.get(num));

		return Long.decode(sb.toString()).longValue();
	}

	public long getDateYear() {
		StringBuffer sb = new StringBuffer();
		Calendar CD = Calendar.getInstance();

		sb.append(CD.get(1));
		sb.toString().substring(2, 4);

		return Long.decode(sb.toString()).longValue();
	}

	public long getDateMonth() {
		StringBuffer sb = new StringBuffer();
		Calendar CD = Calendar.getInstance();

		sb.append(CD.get(2) + 1);

		return Long.decode(sb.toString()).longValue();
	}

	public long getDateDay() {
		StringBuffer sb = new StringBuffer();
		Calendar CD = Calendar.getInstance();

		sb.append(CD.get(5));

		return Long.decode(sb.toString()).longValue();
	}

	public long getDateNum(String str) {
		StringBuffer sb = new StringBuffer();

		sb.append(getDateYear());

		if (getDateMonth() < 10) {
			sb.append("0");
		}
		sb.append(getDateMonth());

		if (getDateDay() < 10) {
			sb.append("0");
		}
		sb.append(getDateDay());

		sb.append(str);

		return Long.decode(sb.toString()).longValue();
	}

	// 生成最大code
	public String getMaxCode(String str, String field, String tbname) {
		long code = getDateNum(str);
		String sql = "select max(" + field + ") from " + tbname + "";
		long a = jdbc.queryForLong(sql);
		if (a != 0 && a >= code) {
			code = a + 1L;
		}
		return String.valueOf(code);
	}

	// 生成当天最大code
	public String getMaxCode(String str, String field, String tbname, String datefield) {
		long code = 0;
		String nowdate = dateUtils.showDate("yyyy-MM-dd");
		String sql = "select max(" + field + ") from " + tbname + " where " + datefield + " = '" + nowdate + "'";
		long a = jdbc.queryForLong(sql);
		if (a != 0 && a >= code) {
			code = a + 1L;
		}
		return String.valueOf(code);
	}

	// 生成当天最大code
	public String getMaxCodeDay(String str, String field, String tbname, String datefield) {
		long code = getDateNum(str);
		String nowdate = dateUtils.showDate("yyyy-MM-dd");
		String sql = "select max(" + field + ") from " + tbname + " where " + datefield + " = '" + nowdate + "'";
		long a = jdbc.queryForLong(sql);
		if (a != 0 && a >= code) {
			code = a + 1L;
		}
		return String.valueOf(code);
	}

	// 产生几位随机字母
	public String getRanCode(int length) {
		int i = 0;
		String code = "";
		for (; i < length; i++) {
			char c = (char) (Math.random() * 26 + 'a');
			code = code + c;
		}
		return code;
	}

	// 生成入库单号
	public String getSheetId() {
		String sheetid = "";
		String rancode = getRanCode(4);
		sheetid = rancode + dateUtils.showDate("yyyyMMddHHmmssSSS");
		return sheetid;
	}

	// 生成挂号单号
	public String getnum() {
		String sheetid = "";
		String rancode = getRanCode(4);
		sheetid = rancode + dateUtils.showDate("yyyyMMddHHmmss");
		return sheetid;
	}

	// 生成住院单号
	public String getZycode() {
		String sheetid = "";
		String rancode = getRanCode(2);
		sheetid = rancode + dateUtils.showDate("yyyyMMddHHmmss");
		return sheetid;
	}
}
