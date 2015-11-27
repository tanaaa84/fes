package com.fes.common.utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Hashtable;

import org.springframework.jdbc.core.RowMapper;

public class HashtableRowMapper implements RowMapper<Object> {

	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Hashtable<String, Object> hst = new Hashtable<String, Object>();

		StringUtils su = new StringUtils();
		
		ResultSetMetaData rmd = rs.getMetaData();
		int count = rmd.getColumnCount();

		for (int i = 0; i < count; i++) {
			//System.out.println("columnName:" + rmd.getColumnName(i + 1));
			//System.out.println("columnLabel:"+rmd.getColumnLabel(i+1));
			//System.out.println("columnCatalog:"+rmd.getCatalogName(i+1));
			//System.out.println(rs.getObject(i + 1).toString());
			//System.out.println(rmd.getColumnName(i + 1) + "   " + rs.getObject(i + 1));
			hst.put(rmd.getColumnName(i + 1), su.ObjectIsNull(rs.getObject(i + 1), ""));
		}

		return hst;
	}
}