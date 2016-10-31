package com.interframe.system.repository.mybatis.page;

public interface Dialect {
	
	@SuppressWarnings("unused")
	public static enum Type {
		MYSQL {
			public String getValue() {
				return "mysql";
			}
		},
		MSSQL {
			public String getValue() {
				return "sqlserver";
			}
		},
		ORACLE {
			public String getValue() {
				return "oracle";
			}
		}
	}

	public abstract String getPageSql(String sql, PageInfo page);
}
