package com.fes.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Repository;

/**
 * 日期操作类
 * 
 * @author Administrator
 * 
 */
@Repository("dateUtils")
public class DateUtils {
	public DateUtils() {

	}

	/**
	 * 自定义时间格式
	 * 
	 * @param format
	 *            格式 如：yyyy-MM-dd HH:mm:ss,yyyy年MM月dd日_HH时mm分ss秒
	 * @return String
	 */
	public String showDate(String format) {
		Date dNow = new Date();
		SimpleDateFormat myformat = new SimpleDateFormat(format);
		String mydate = myformat.format(dNow);

		return mydate;
	}

	/**
	 * 格式化日期
	 * 
	 * @param String
	 *            data 格式化日期
	 * @return 格式化后日期
	 */
	public static String formatDate(String date) {

		return date.substring(5, 10);

	}

	/**
	 * 自定义格式化时间
	 * 
	 * @param format
	 *            格式 如：yyyy-MM-dd HH:mm:ss,yyyy年MM月dd日_HH时mm分ss秒
	 * @param datetime
	 *            需要格式的时间
	 * @return
	 */
	public String DateFormat(String format, String datetime) {
		SimpleDateFormat myformat = new SimpleDateFormat(format);
		DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.CHINESE);
		String mydatetime;
		try {
			mydatetime = myformat.format(df.parse(datetime));
		}
		catch (ParseException e) {
			e.printStackTrace();
			return "";
		}

		return mydatetime;
	}

	/**
	 * 自定义日期格式前后n天
	 * 
	 * @param n
	 *            -1前一天; 1后一天
	 * @param format
	 *            日期格式
	 * @return String
	 */
	public String afterNDay(int n, String format) {
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat(format);
		c.setTime(new Date());
		c.add(Calendar.DATE, n);
		Date d2 = c.getTime();
		String s = df.format(d2);
		return s;
	}

	/**
	 * 自定义选定日期格式前后n天
	 * 
	 * @param n
	 *            -1前一天; 1后一天
	 * @param format
	 *            日期格式
	 * @param mydate
	 *            选定日期
	 * @return String
	 * @throws ParseException
	 */
	public String afterNDay(int n, String format, String mydate) throws ParseException {
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat(format);
		c.setTime(df.parse(mydate));
		c.add(Calendar.DATE, n);
		Date d2 = c.getTime();
		String s = df.format(d2);
		return s;
	}

	/**
	 * 自定义月份格式前后n月
	 * 
	 * @param n
	 *            -1前一月; 1后一月
	 * @param format
	 *            月份格式
	 * @return String
	 */
	public String afterNMonth(int n, String format) {
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat(format);
		c.setTime(new Date());
		c.add(Calendar.MONTH, n);
		Date d2 = c.getTime();
		String s = df.format(d2);
		return s;
	}

	/**
	 * 自定义选定月份格式前后n月
	 * 
	 * @param n
	 *            -1前一月; 1后一月
	 * @param format
	 *            月份格式
	 * @param mydate
	 *            选定月份
	 * @return String
	 * @throws ParseException
	 */
	public String afterNMonth(int n, String format, String mydate) throws ParseException {
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat(format);
		c.setTime(df.parse(mydate));
		c.add(Calendar.MONTH, n);
		Date d2 = c.getTime();
		String s = df.format(d2);
		return s;
	}

	/**
	 * 自定义年份格式前后n年
	 * 
	 * @param n
	 *            -1前一年; 1后一年
	 * @param format
	 *            年份格式
	 * @return String
	 */
	public String afterNYear(int n, String format) {
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat(format);
		c.setTime(new Date());
		c.add(Calendar.YEAR, n);
		Date d2 = c.getTime();
		String s = df.format(d2);
		return s;
	}

	/**
	 * 自定义选定年份格式前后n年
	 * 
	 * @param n
	 *            -1前一年; 1后一年
	 * @param format
	 *            年份格式
	 * @param mydate
	 *            选定年份
	 * @return String
	 * @throws ParseException
	 */
	public String afterNYear(int n, String format, String mydate) throws ParseException {
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat(format);
		c.setTime(df.parse(mydate));
		c.add(Calendar.YEAR, n);
		Date d2 = c.getTime();
		String s = df.format(d2);
		return s;
	}

	/**
	 * 计算时间差 (时间单位,开始时间,结束时间) 调用方法
	 * howLong("h","2007-08-09 10:22:26","2007-08-09 20:21:30") ///9小时56分 返回9小时
	 * 
	 * @param unit
	 * @param time1
	 * @param time2
	 * @return
	 * @throws ParseException
	 */
	public long howLong(String unit, String time1, String time2) throws ParseException {
		// 时间单位(如：不足1天(24小时) 则返回0)，开始时间，结束时间
		Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time1);
		Date date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time2);
		long ltime = date1.getTime() - date2.getTime() < 0 ? date2.getTime() - date1.getTime() : date1.getTime() - date2.getTime();
		if (unit.equals("s")) {
			return ltime / 1000; // 返回秒
		}
		else if (unit.equals("m")) {
			return ltime / 60000; // 返回分钟
		}
		else if (unit.equals("h")) {
			return ltime / 3600000; // 返回小时
		}
		else if (unit.equals("d")) {
			return ltime / 86400000; // 返回天数
		}
		else {
			return 0;
		}
	}

	/**
	 * 以格式输出 howLong 方法的结果 小写单位符号 m 代表以分结尾 ，大写单位符号 M 代表以分开头 Hm 代表 以小时开头 以分结尾
	 * 
	 * @param unit
	 * @param time1
	 * @param time2
	 * @return
	 * @throws ParseException
	 */
	public String howLong2(String unit, String time1, String time2) throws ParseException {
		long Dnum = howLong("d", time1, time2);
		long Secnum = howLong("s", time1, time2);
		long Hnum = 0;
		long Mnum = 0;
		long Snum = 0;
		if (Secnum < 86400) {
			Dnum = 0;
		}
		long sd = Dnum * 24 * 3600;
		long sh = Secnum - sd;
		Hnum = sh / 3600;
		long sm = sh - Hnum * 3600;
		Mnum = sm / 60;
		Snum = sm - Mnum * 60;
		if (unit.equals("d")) {
			return Dnum + "天";
		}
		else if (unit.equals("h")) {
			return Dnum + "天" + Hnum + "小时";
		}
		else if (unit.equals("m")) {
			return Dnum + "天" + Hnum + "小时" + Mnum + "分";
		}
		else if (unit.equals("s")) {
			return Dnum + "天" + Hnum + "小时" + Mnum + "分" + Snum + "秒";
		}
		else if (unit.equals("H")) {
			return Dnum * 24 + Hnum + "小时" + Mnum + "分" + Snum + "秒";
		}
		else if (unit.equals("M")) {
			return (Dnum * 24 + Hnum) * 60 + "分" + Snum + "秒";
		}
		else if (unit.equals("Hm")) {
			return Dnum * 24 + Hnum + "小时" + Mnum + "分";
		}
		else {
			return Dnum + "天" + Hnum + "小时" + Mnum + "分" + Snum + "秒";
		}
	}

	/**
	 * 计算时间差 (时间单位,开始时间,结束时间) 调用方法
	 * howLong("h","2007-08-09 10:22:26","2007-08-09 20:21:30") ///9小时56分 返回9小时
	 * 
	 * @param unit
	 * @param time1
	 * @param time2
	 * @return
	 * @throws ParseException
	 */
	public long howLong3(String unit, String time1, String time2) throws ParseException {
		// 时间单位(如：不足1天(24小时) 则返回0)，开始时间，结束时间
		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(time1);
		Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(time2);
		long ltime = date1.getTime() - date2.getTime() < 0 ? date2.getTime() - date1.getTime() : date1.getTime() - date2.getTime();
		if (unit.equals("s")) {
			return ltime / 1000; // 返回秒
		}
		else if (unit.equals("m")) {
			return ltime / 60000; // 返回分钟
		}
		else if (unit.equals("h")) {
			return ltime / 3600000; // 返回小时
		}
		else if (unit.equals("d")) {
			return ltime / 86400000; // 返回天数
		}
		else {
			return 0;
		}
	}

	/**
	 * 计算时间差 (时间单位,开始时间,结束时间) 调用方法
	 * howLong("h","2007-08-09 10:22:26","2007-08-09 20:21:30") ///9小时56分 返回9小时
	 * 
	 * @param unit
	 * @param time1
	 * @param time2
	 * @return
	 * @throws ParseException
	 */
	public long howLong4(String time1, String time2) throws ParseException {
		// 时间单位(如: 不足1天(24小时) 则返回0), 开始时间,结束时间
		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(time1);
		Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(time2);
		long ltime = date2.getTime() - date1.getTime();
		return ltime / 86400000; // 返回天数
	}

	// 通过生日获取年龄
	public String getAge(String birthday) {
		int age = 0;
		String newAge = "0";
		if (birthday != null && birthday != "null" && birthday != " " && birthday != "" && !birthday.equals("") && !birthday.equals(" ") && !birthday.equals(null) && !birthday.equals("null")) {
			int year = Integer.parseInt(showDate("yyyy"));// 当前年份
			int month = Integer.parseInt(showDate("MM"));// 当前月份
			int date = Integer.parseInt(showDate("dd"));// 当前日期
			int byear = Integer.parseInt(birthday.substring(0, 4));// 生日年份
			int bmonth = Integer.parseInt(birthday.substring(5, 7));// 生日月份
			int bdate = Integer.parseInt(birthday.substring(8, 10));// 生日年份

			if (year - byear == 1 && month < bmonth) {
				age = (12 - bmonth) + month;
				newAge = age + "月";

			}
			else if (year - byear == 0) {
				if (bmonth < month) {
					age = month - bmonth;
					newAge = age + "月";
				}
				else {
					age = date - bdate;
					newAge = age + "天";
				}
			}
			else {
				age = (bmonth <= month) ? (year - byear) : (year - byear - 1);// 获取年龄
				newAge = age + "岁";
			}
		}
		return newAge;
	}

	/**
	 * 取得当月天数
	 * */
	public int getCurrentMonthLastDay() {
		Calendar a = Calendar.getInstance();
		a.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		a.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}

	/**
	 * 得到指定月的天数
	 * */
	public int getMonthLastDay(int year, int month) {
		Calendar a = Calendar.getInstance();
		a.set(Calendar.YEAR, year);
		a.set(Calendar.MONTH, month - 1);
		a.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		a.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}
}
