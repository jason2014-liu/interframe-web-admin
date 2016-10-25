/**
* TODO
* @Project: interframe-web-admin
* @Title: UserServiceImpl.java
* @Package com.interframe.system.service.impl
* @author jason
* @Date 2016年10月20日 下午3:47:28
* @Copyright
* @Version 
*/
package com.interframe.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interframe.system.repository.mybatis.Page;
import com.interframe.system.repository.mybatis.UserMapper;
import com.interframe.system.repository.mybatis.model.User;
import com.interframe.system.service.UserService;

/**
* TODO
* @ClassName: UserServiceImpl
* @author jason
*/
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findByLoginName(String name) {
		// TODO Auto-generated method stub
		return userMapper.SelectByLoginName(name);
	}

	@Override
	public Page<User> findByPage(String orgId, Page<User> page) {
		// TODO Auto-generated method stub
		List<User> users = userMapper.selectUsersByPage(orgId, page);
		page.setResultList(users);
		return page;
	}

}
