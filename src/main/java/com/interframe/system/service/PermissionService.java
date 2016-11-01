/**
* TODO
* @Project: interframe-web-admin
* @Title: PermissionService.java
* @Package com.interframe.system.service
* @author jason
* @Date 2016年10月11日 上午11:03:39
* @Copyright
* @Version 
*/
package com.interframe.system.service;

import java.util.List;

import com.interframe.system.repository.mybatis.model.Permission;

/**
* TODO
* @ClassName: PermissionService
* @author jason
*/
public interface PermissionService {

	/**
	* TODO 查找模塊列表
	* @Title: findModulesByUserId
	* @param userId
	* @return
	 */
	List<Permission> findModulesByUserId(String userId);
	
	/**
	* TODO
	* @Title: findMenusByUserId
	* @param userId
	* @param moduleId
	* @return
	 */
	List<Permission> findMenusByUserId(String userId, String moduleId);
}
