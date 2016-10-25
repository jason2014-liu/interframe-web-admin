/**
* TODO
* @Project: interframe-web-admin
* @Title: OrgServiceImpl.java
* @Package com.interframe.system.service.impl
* @author jason
* @Date 2016年10月24日 下午3:07:09
* @Copyright
* @Version 
*/
package com.interframe.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interframe.system.repository.mybatis.OrgMapper;
import com.interframe.system.repository.mybatis.model.Org;
import com.interframe.system.service.OrgService;

/**
* TODO
* @ClassName: OrgServiceImpl
* @author jason
*/
@Service
public class OrgServiceImpl implements OrgService {

	@Autowired
	private OrgMapper orgMapper;
	
	@Override
	public List<Org> findAllOrg() {
		// TODO Auto-generated method stub
		return orgMapper.selectAllOrg();
	}

}
