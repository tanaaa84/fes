package com.fes.common.utils;

import java.util.List;

import javax.annotation.Resource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("pageUtil")
public class PageUtil {

	@Resource
	private JdbcTemplate jdbcTemplate;

	public List<Object> pageList(Class<?> objClass, String tableName, String dbType, String strSql, Pager pager) {
		String sql = "";
		if (dbType.trim().equalsIgnoreCase("mssql")) {
			if ("".equals(strSql) || strSql == null) {
				sql += "select top " + pager.getPagesize() + " * from " + tableName + " where id not in (select top " + pager.getPagesize() * (pager.getCurrentpage() - 1)
						+ " id from " + tableName + " order by id)";
			}
			else {
				sql += "select top " + pager.getPagesize() + " * from " + tableName + " where id not in (select top " + pager.getPagesize() * (pager.getCurrentpage() - 1)
						+ " id from " + tableName + " where " + strSql + " order by id)" + "and  " + strSql;
			}
		}
		else if (dbType.trim().equalsIgnoreCase("mysql")) {
			if ("".equals(strSql) || strSql == null) {
				sql += "select * from " + tableName + " order by id limit " + pager.getPagesize() * (pager.getCurrentpage() - 1) + "," + pager.getPagesize();
			}
			else {
				sql += "select * from " + tableName + " where " + strSql + " order by id limit " + pager.getPagesize() * (pager.getCurrentpage() - 1) + "," + pager.getPagesize();
			}
		}
		else if (dbType.trim().equalsIgnoreCase("oracle")) {

		}
		else {
			sql += "select * from " + tableName;
		}

		List list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(objClass));
		return list;
	}

	public int pageListCount(String tableName, String strSql) {
		String sql = "select count(*) from " + tableName;
		if (!("".equals(strSql) || strSql == null)) {
			sql += " where " + strSql;
		}
		return jdbcTemplate.queryForInt(sql);
	}
}
