package com.fes.common.utils;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

/**
 * 字符串操作类
 * @author Administrator
 *
 */
@Repository("stringUtils")
public class StringUtils {

	/**
	 * 判断String字段是否为空
	 * 
	 * @param field
	 * @param value
	 * @return
	 * */
	public String StringIsNull(String field, String value) {
		String returnValue = "";
		if (field == null || field == "null" || field == " " || field == "" || field.equals("") || field.equals(" ") || field.equals(null) || field.equals("null")) {
			returnValue = value;
		}
		else {
			returnValue = field;
		}

		return returnValue;
	}

	public Object ObjectIsNull(Object field, String value) {
		Object returnValue = "";
		if (field == null || field == "null" || field == " " || field == "" || field.equals("") || field.equals(" ") || field.equals(null) || field.equals("null")) {
			returnValue = value;
		}
		else {
			returnValue = field;
		}

		return returnValue;
	}

	public Integer IntegerIsNull(Integer field, Integer value) {
		Integer returnValue;
		if (field == null || field.equals("") || field.equals(" ") || field.equals(null) || field.equals("null")) {
			returnValue = value;
		}
		else {
			returnValue = field;
		}

		return returnValue;
	}

	public Double DoubleIsNull(Double field, Double value) {
		Double returnValue;
		if (field == null || field.equals("") || field.equals(" ") || field.equals(null) || field.equals("null")) {
			returnValue = value;
		}
		else {
			returnValue = field;
		}

		return returnValue;
	}

	public boolean StringIsNull(String field) {
		boolean flag = false;

		if (field == null || field == "null" || field == " " || field == "" || field.equals("") || field.equals(" ") || field.equals(null) || field.equals("null")) {
			flag = true;
		}
		else {
			flag = false;
		}

		return flag;
	}

	/**
	 * 统计指定字符串中某种字符个数
	 * @param s
	 * @param s1
	 * @return
	 */
	public int CountSmp(String s, String s1) {
		String as[] = s.split(s1);
		int i = 0;
		for (int j = 0; j < as.length; j++)
			i++;

		return i;
	}

	/**
	 * 自动转换数组字符串为字符串
	 * 
	 * @param arrStr
	 * @return
	 */
	public String arrStrToStr(String[] arrStr) {
		String tids = "";

		int i = 0;
		int arrStrLen = arrStr.length;
		for (; i < arrStrLen; i++) {
			tids += "'" + arrStr[i] + "'";
			if (i != arrStr.length - 1) {
				tids += ",";
			}
		}

		return tids;
	}

	public String arrStrToStr(Object[] arrStr) {
		String tids = "";

		int i = 0;
		int arrStrLen = arrStr.length;
		for (; i < arrStrLen; i++) {
			tids += "'" + arrStr[i] + "'";
			if (i != arrStr.length - 1) {
				tids += ",";
			}
		}

		return tids;
	}

	/**
	 * 判断session是否过期
	 * 
	 * @param session
	 * @param seval
	 * @return
	 */
	public boolean sessionIsVal(HttpSession session, String seval) {
		boolean flag = false;
		Object obj = (Object) session.getAttribute(seval);
		if (obj != null) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 截取字符串
	 * @param title
	 * @param num
	 * @return
	 */
	public String autoInterCept(String title, int num) {
		int tlength = title.length();
		if (tlength > num) {
			title = title.substring(0, num) + "...";
			return title;
		}
		else {
			return title;
		}
	}

	/**
	 * 替换手机号码前4位为星号
	 * @param tel
	 * @return
	 */
	public String telToStar(String tel) {
		String telstr = tel.substring(3, 7);
		String telstar = tel.replace(telstr, "****");

		return telstar;
	}

	/**
	 * 订单交易金额，单位为分，12位长度，左补0
	 * @param str
	 * @param strLength
	 * @return
	 */
	public String addZeroForNum(double price, int strLength) {
		java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
		String str = df.format(price);
		str = str.replace(".", "");
		str = String.format("%0" + strLength + "d", Integer.parseInt(str));

		/*
		int strLen = str.length();
		if (strLen < strLength) {
			while (strLen < strLength) {
				StringBuffer sb = new StringBuffer();
				sb.append("0").append(str);//左补0
				// sb.append(str).append("0");//右补0
				str = sb.toString();
				strLen = str.length();
			}
		}
		*/

		return str;
	}

	/**
	 * 使用java正则表达式去掉多余的.与0
	 * @param s
	 * @return 
	 */
	public String subZeroAndDot(String s) {
		if (s.indexOf(".") > 0) {
			s = s.replaceAll("0+?$", "");// 去掉多余的0
			s = s.replaceAll("[.]$", "");// 如最后一位是.则去掉
		}
		return s;
	}

}
