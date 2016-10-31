package com.interframe.system.repository.mybatis.page;

public class MySqlDialect implements Dialect {

	public String getPageSql(String sql, int offset, int limit) {
		return MySqlPageHepler.getPageSql(sql, offset, limit);
	}

	public String getPageSql(String sql, PageInfo page) {
		// TODO Auto-generated method stub
		return MySqlPageHepler.getPageSql(sql, page.getCurrentResult(), page.getShowCount());
	}

}
