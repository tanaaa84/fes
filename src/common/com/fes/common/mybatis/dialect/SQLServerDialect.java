package com.fes.common.mybatis.dialect;

public class SQLServerDialect extends Dialect {

	public boolean supportsLimitOffset() {
		return false;
	}

	public boolean supportsLimit() {
		return true;
	}

	static int getAfterSelectInsertPoint(String sql) {
		int selectIndex = sql.toLowerCase().indexOf("select");
		final int selectDistinctIndex = sql.toLowerCase().indexOf("select distinct");
		return selectIndex + (selectDistinctIndex == selectIndex ? 15 : 6);
	}

	public String getLimitString(String sql, int offset, int limit) {
		return getLimitString(sql, offset, null, limit, null);
	}

	public String getLimitString(String querySelect, int offset, String offsetPlaceholder, int limit, String limitPlaceholder) {
		if (offset > 0) {
			throw new UnsupportedOperationException("sql server has no offset");
		}

		/*
		 * 仅支持>=sql2005
		 */
		// if(limitPlaceholder != null) {
		// throw new
		// UnsupportedOperationException(" sql server not support variable limit");
		// }

		/*
		 * select top limit * FROM
		 * 
		 * ( SELECT top 10 ROW_NUMBER() OVER (ORDER BY ReportID) AS RowNo FROM
		 * TABLE ) AS A WHERE RowNo > " + pageIndex*10
		 */

		return new StringBuffer(querySelect.length() + 8).append(querySelect).insert(getAfterSelectInsertPoint(querySelect), " top " + limit).toString();
	}

	// TODO add Dialect.supportsVariableLimit() for sqlserver
	// public boolean supportsVariableLimit() {
	// return false;
	// }

}
