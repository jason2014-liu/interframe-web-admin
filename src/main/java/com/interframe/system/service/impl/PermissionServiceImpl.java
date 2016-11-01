/**
* TODO
* @Project: interframe-web-admin
* @Title: PermissionServiceImpl.java
* @Package com.interframe.system.service.impl
* @author jason
* @Date 2016年10月11日 上午11:04:42
* @Copyright
* @Version 
*/
package com.interframe.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interframe.system.repository.mybatis.PermissionMapper;
import com.interframe.system.repository.mybatis.model.Permission;
import com.interframe.system.service.PermissionService;

/**
* TODO
* @ClassName: PermissionServiceImpl
* @author jason
*/
@Service
public class PermissionServiceImpl implements PermissionService {
	
	@Autowired
	private PermissionMapper permissionMapper;

	@Override
	public List<Permission> findModulesByUserId(String userId) {
		// TODO Auto-generated method stub
		return permissionMapper.findModulesByUserId(userId);
	}

	@Override
	public List<Permission> findMenusByUserId(String userId, String moduleId) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("moduleId", moduleId);
		return permissionMapper.findMenusByUserId(params);
	}

}
