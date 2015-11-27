package com.fes.common.log;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LocationInfo;

import com.fes.common.utils.DateUtils;

public class MakeLog {

	public Logger logger = Logger.getLogger(MakeLog.class);

	DateUtils du = new DateUtils();

	// 获取方法名称和行数
	protected String getMethodName() {
		LocationInfo location = new LocationInfo(new Throwable(), this.getClass().getName());
		String info = location.getClassName();
		int index = info.lastIndexOf('.');
		if (index >= 0) {
			info = info.substring(index + 1);
		}
		String who = "ID-" + (Thread.currentThread()).hashCode();
		info = "[" + who + " ] " + "[ " + location.getFileName() + ":" + location.getLineNumber() + "\t ] " + location.getMethodName() + "(), ";
		return info;
	}

	// 打印错误日志
	public void errorLog(Exception io_ex) {
		StringBuffer msg = new StringBuffer();
		if (io_ex != null) {
			java.io.StringWriter s = new java.io.StringWriter();
			java.io.PrintWriter p = new java.io.PrintWriter(s);
			io_ex.printStackTrace(p);
			msg.append("\r\n");
			msg = s.getBuffer();
		}
		this.logger.error(this.getMethodName() + ", Exception=" + msg.toString());
	}

	// 打印需要的信息
	public void infoLog(String io_msg) {
		logger.info(this.getMethodName() + io_msg);
	}

	// 简单SQL打印
	public void sqlLogOut(String sql) {
		String nowdatetime = du.showDate("yyyy年MM月dd日_HH时mm分ss秒");
		if (sql != null) {
			logger.info(nowdatetime + "SQL语句: " + sql);
		}
	}

	// 打印SQL语句
	public void sqlLogOutForEasyMethod(String sql, String methodName, String IP) {
		if (sql != null) {
			logger.info(du.showDate("yyyy年MM月dd日_HH时mm分ss秒") + " " + methodName + " " + this.getMethodName() + IP + "开始");
			logger.info("SQL语句: " + sql);
			logger.info(du.showDate("yyyy年MM月dd日_HH时mm分ss秒") + " " + methodName + " " + this.getMethodName() + IP + "结束");
		}
	}

	// 打印带占位符的SQL
	public void sqlLogOutWithPlaceholder(String sql, Object params[]) {
		String nowdatetime = du.showDate("yyyy年MM月dd日_HH时mm分ss秒");
		if (sql != null) {
			// 如果SQL中没有占位符则按普通SQL输出
			if (sql.indexOf("?") < 0) {
				logger.info(nowdatetime + " SQL语句: " + sql);
			}
			else {
				String sqltmp = "";
				// 循环替换SQL中的问号
				for (int i = 0; i < params.length; i++) {
					// 如果参数为INT型
					if (params[i] instanceof Integer) {
						params[i] = Integer.toString((Integer) params[i]);
						sqltmp = sql.replaceFirst("\\?", (String) params[i]);
						sql = sqltmp;
					}
					else if (params[i] instanceof Float) { // 如果参数为Float
						params[i] = Float.toString((Float) params[i]);
						sqltmp = sql.replaceFirst("\\?", (String) params[i]);
						sql = sqltmp;
					}
					else if (params[i] instanceof Double) { // 如果参数为Float
						params[i] = Double.toString((Double) params[i]);
						sqltmp = sql.replaceFirst("\\?", (String) params[i]);
						sql = sqltmp;
					}
					else { // 如果参数为String
						sqltmp = sql.replaceFirst("\\?", "'" + (String) params[i] + "'");
						sql = sqltmp;
					}
				}
				logger.info(nowdatetime + " SQL语句: " + sql);
			}
		}
	}

	// 简单带占位符的SQL打印
	public void sqlLogOutWithPlaceholderForEasyMethod(String sql, Object params[], String methodName, String IP) {
		logger.info(du.showDate("yyyy年MM月dd日_HH时mm分ss秒") + " " + methodName + " " + this.getMethodName() + IP + "开始");
		if (sql != null) {
			// 如果SQL中没有占位符则按普通SQL输出
			if (sql.indexOf("?") < 0) {
				logger.info("SQL语句: " + sql);
			}
			else {
				String sqltmp = "";
				// 循环替换SQL中的问号
				for (int i = 0; i < params.length; i++) {
					// 如果参数为INT型
					if (params[i] instanceof Integer) {
						params[i] = Integer.toString((Integer) params[i]);
						sqltmp = sql.replaceFirst("\\?", (String) params[i]);
						sql = sqltmp;
					}
					else { // 如果参数为String
						sqltmp = sql.replaceFirst("\\?", "'" + (String) params[i] + "'");
						sql = sqltmp;
					}
				}
				logger.info("SQL语句: " + sql);
			}
		}
		logger.info(du.showDate("yyyy年MM月dd日_HH时mm分ss秒") + " " + methodName + " " + this.getMethodName() + IP + "结束");
	}

	// 打印方法开始
	public void beginMethod(String methodName, String IP) {
		logger.info(du.showDate("yyyy年MM月dd日_HH时mm分ss秒") + " " + methodName + " " + this.getMethodName() + IP + "开始");
	}

	// 打印方法结束
	public void endMethod(String methodName, String IP) {
		logger.info(du.showDate("yyyy年MM月dd日_HH时mm分ss秒") + " " + methodName + " " + this.getMethodName() + IP + "结束");
	}
}
