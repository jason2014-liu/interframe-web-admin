/**
* TODO
* @Project: interframe-web-admin
* @Title: UserServiceImpl.java
* @Package com.interframe.hr.service.impl
* @author jason
* @Date 2016年10月10日 下午4:38:20
* @Copyright
* @Version 
*/
package com.interframe.hr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interframe.hr.repository.mybatis.SysUserMapper;
import com.interframe.hr.repository.mybatis.model.SysUser;
import com.interframe.hr.service.UserService;

/**
* TODO
* @ClassName: UserServiceImpl
* @author jason
*/
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private SysUserMapper userMapper;
	
	@Override
	public SysUser selectById(String id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id);
	}

}
