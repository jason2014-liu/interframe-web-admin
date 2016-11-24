/**
* TODO
* @Project: interframe-web-admin
* @Title: UserRowMapper.java
* @Package com.interframe.system.batch
* @author jason
* @Date 2016年11月9日 下午6:08:30
* @Copyright
* @Version 
*/
package com.interframe.system.batch;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.interframe.system.repository.mybatis.model.User;

/**
* TODO
* @ClassName: UserRowMapper
* @author jason
*/
public class UserRowMapper implements RowMapper<User> {
	
	public static final String ID_COLUMN = "id";
	public static final String NAME_COLUMN = "name";
	public static final String LOGINNAME_COLUMN = "login_name";
	public static final String PASSWORD_COLUMN = "password";
	public static final String VALID_COLUMN = "valid";

	@Override
	public User mapRow(ResultSet rs, int rownum) throws SQLException {
		// TODO Auto-generated method stub
		
		User user = new User();
		user.setId(rs.getString(ID_COLUMN));
		user.setName(rs.getString(NAME_COLUMN));
		user.setLoginName(rs.getString(LOGINNAME_COLUMN));
		user.setPassword(rs.getString(PASSWORD_COLUMN));
		user.setValid(rs.getString(VALID_COLUMN));
		
		return user;
	}

}
