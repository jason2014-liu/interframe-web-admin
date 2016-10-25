/**
* TODO
* @Project: interframe-web-admin
* @Title: OrgService.java
* @Package com.interframe.system.service
* @author jason
* @Date 2016年10月24日 下午3:06:20
* @Copyright
* @Version 
*/
package com.interframe.system.service;

import java.util.List;

import com.interframe.system.repository.mybatis.model.Org;

/**
* TODO
* @ClassName: OrgService
* @author jason
*/
public interface OrgService {

	List<Org> findAllOrg();
}
