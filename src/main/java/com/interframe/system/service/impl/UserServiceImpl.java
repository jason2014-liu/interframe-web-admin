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

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interframe.system.repository.mybatis.UserMapper;
import com.interframe.system.repository.mybatis.model.User;
import com.interframe.system.repository.mybatis.page.PageInfo;
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
	public List<User> findByPage(User user, PageInfo pageInfo) {
		// TODO Auto-generated method stub
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("orgId", user.getOrgId());
		params.put("page", pageInfo);
		List<User> users = userMapper.selectUsersByPage(params);
		return users;
	}

}
