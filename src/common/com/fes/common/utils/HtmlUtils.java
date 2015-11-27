package com.fes.common.utils;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 生产HTML文件的操作类
 * 
 * @author Administrator
 * 
 */
@Repository("htmlUtils")
public class HtmlUtils {
	@Resource
	private JdbcTemplate jdbc;

	/**
	 * 模版标签替换
	 * 
	 * @param curContent
	 * @param oldStr
	 * @param newStr
	 * @return
	 */
	public String str_var(String curContent, String oldStr, String newStr) {
		oldStr = "{" + oldStr + "}"; // 自动匹配括号

		String tempContent = curContent;
		String newContent = "";
		try {
			while (tempContent.length() > 0) {
				if (tempContent.indexOf(oldStr) != -1) {
					newContent = (new StringBuilder(String.valueOf(newContent))).append(tempContent.substring(0, tempContent.indexOf(oldStr))).toString();
					newContent = (new StringBuilder(String.valueOf(newContent))).append(newStr).toString();
					tempContent = tempContent.substring(tempContent.indexOf(oldStr) + oldStr.length());
				}
				else {
					newContent = (new StringBuilder(String.valueOf(newContent))).append(tempContent).toString();
					tempContent = "";
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return newContent;
	}

	/**
	 * SQL转化模版功能
	 * 
	 * @param sql
	 * @param mb
	 * @return
	 */
	public String sqlto(String sql, String mb) {
		String temp = "";
		String mbtmp = "";

		List<?> list = jdbc.query(sql, new HashtableRowMapper());

		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				mbtmp = mb;

				// 注意没做空值处理,所以String转换可能有异常
				Hashtable<?, ?> hst = (Hashtable<?, ?>) list.get(i);

				for (Iterator<?> itr = hst.keySet().iterator(); itr.hasNext();) {
					String key = (String) itr.next();
					Object value = hst.get(key);

					mbtmp = str_var(mbtmp, key, delHTML(String.valueOf(value), "js"));
				}

				temp += mbtmp;
			}
		}

		return temp;
	}

	/**
	 * SQL转化模版功能,支持自定义数据库
	 * 
	 * @param sql
	 * @param mb
	 * @param dataType
	 * @return
	 */
	public String sqlto(String sql, String mb, String dataType) {
		String temp = "";
		String mbtmp = "";

		if (dataType.equals("0")) {
			// 默认数据库
		}
		else {
			DatabaseContextHolder.setDatabaseType(dataType); // 调用其他数据源
		}

		List<?> list = jdbc.query(sql, new HashtableRowMapper());

		if (list != null && list.size() > 0) {
			int i = 0;
			int listlen = list.size();
			for (; i < listlen; i++) {
				mbtmp = mb;

				// 注意没做空值处理,所以String转换可能有异常
				Hashtable<?, ?> hst = (Hashtable<?, ?>) list.get(i);

				for (Iterator<?> itr = hst.keySet().iterator(); itr.hasNext();) {
					String key = (String) itr.next();
					Object value = hst.get(key);

					mbtmp = str_var(mbtmp, key, delHTML(String.valueOf(value), "js"));
				}

				temp += mbtmp;
			}
		}

		if (dataType.equals("0")) {
			// 默认数据库
		}
		else {
			DatabaseContextHolder.clearDatabaseType();
		}

		return temp;
	}

	public String ListToStrOpt(String sql) {
		String strOpt = "";

		List<?> list = jdbc.query(sql, new HashtableRowMapper());

		if (list != null && list.size() > 0) {
			int i = 0;
			int listlen = list.size();
			for (; i < listlen; i++) {
				Hashtable<?, ?> hst = (Hashtable<?, ?>) list.get(i);

				Object classid = hst.get("suppid");
				Object classname = hst.get("qyname");

				strOpt = strOpt + "<option value=\"" + classid + "\">";
				strOpt = strOpt + classname;
				strOpt = strOpt + "</option>";
			}
		}

		return strOpt;
	}

	/**
	 * 转化特殊字符
	 * 
	 * @param Str
	 * @param Type
	 * @return
	 */
	public String delHTML(String Str, String Type) {
		if (Type == "html") {
			Str = Str.replace("&", "&amp;");
			Str = Str.replace("<", "&lt;");
			Str = Str.replace(">", "&gt;");
			Str = Str.replace("\r\n", "\n");
			Str = Str.replace("\t", "    ");
		}
		else if (Type == "rhtml") {
			Str = Str.replace("&amp;", "&");
			Str = Str.replace("&lt;", "<");
			Str = Str.replace("&gt;", ">");
			Str = Str.replace("\n", "\r\n");
			Str = Str.replace("    ", "\t");
		}
		else if (Type == "js") {
			Str = Str.replace("\"", "\\\"");
			Str = Str.replace("\'", "\\\'");
			Str = Str.replace("\r\n", "\n'");
			Str = Str.replace("\t", "    ");
			Str = Str.replace("\n", "");
		}
		else {
			String regEx_html = "<[^>]+>";
			Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			Matcher m_html = p_html.matcher(Str);
			Str = m_html.replaceAll(""); // 过滤html标签
		}
		return Str.trim();
	}

	/**
	 * 过滤特殊字符
	 * 
	 * @param htmlStr
	 * @return
	 */
	public String delHTMLTag(String htmlStr) {
		String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
		String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
		String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式

		Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
		Matcher m_script = p_script.matcher(htmlStr);
		htmlStr = m_script.replaceAll(""); // 过滤script标签

		Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
		Matcher m_style = p_style.matcher(htmlStr);
		htmlStr = m_style.replaceAll(""); // 过滤style标签

		Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
		Matcher m_html = p_html.matcher(htmlStr);
		htmlStr = m_html.replaceAll(""); // 过滤html标签

		htmlStr = htmlStr.replaceAll("&nbsp;", "");

		return htmlStr.trim(); // 返回文本字符串
	}

	public String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}

}
