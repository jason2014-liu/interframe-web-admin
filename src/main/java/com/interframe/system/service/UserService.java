/**
* TODO
* @Project: interframe-web-admin
* @Title: UserService.java
* @Package com.interframe.system.service
* @author jason
* @Date 2016年10月11日 上午9:33:15
* @Copyright
* @Version 
*/
package com.interframe.system.service;

import com.interframe.system.repository.mybatis.Page;
import com.interframe.system.repository.mybatis.model.User;

/**
* TODO
* @ClassName: UserService
* @author jason
*/
public interface UserService {

	User findByLoginName(String name);
	
	Page<User> findByPage(String orgId, Page<User> page);
}
