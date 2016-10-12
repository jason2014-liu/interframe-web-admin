/**
* TODO
* @Project: interframe-web-admin
* @Title: PermissionServiceTests.java
* @Package com.interframe.system.service
* @author jason
* @Date 2016年10月11日 上午11:10:17
* @Copyright
* @Version 
*/
package com.interframe.system.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.interframe.system.repository.mybatis.model.Permission;

/**
* TODO
* @ClassName: PermissionServiceTests
* @author jason
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:root-context-test.xml"})
@ActiveProfiles({"dev","mybatis"})
public class PermissionServiceTests {

	@Autowired
	private PermissionService permissionService;
	
	@Test
	public void findModulesByUserIdTest(){
		List<Permission> modules = permissionService.findModulesByUserId("001");
		assertNotNull("modules is null", modules);
		for(Permission module : modules){
			if("10".equals(module.getId())){
				assertEquals("module desc 不是 '系统管理'", "系统管理", module.getDescription());
			}
		}
	}
}
