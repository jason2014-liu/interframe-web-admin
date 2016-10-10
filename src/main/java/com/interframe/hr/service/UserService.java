/**
* TODO
* @Project: interframe-web-admin
* @Title: UserService.java
* @Package com.interframe.hr.service
* @author jason
* @Date 2016年10月10日 下午4:37:36
* @Copyright
* @Version 
*/
package com.interframe.hr.service;

import com.interframe.hr.repository.mybatis.model.SysUser;

/**
* TODO
* @ClassName: UserService
* @author jason
*/
public interface UserService {

	SysUser selectById(String id);
}
