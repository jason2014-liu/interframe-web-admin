/**
* TODO
* @Project: interframe-web-admin
* @Title: UserServiceTests.java
* @Package com.interframe.hr.service
* @author jason
* @Date 2016年10月10日 下午4:43:31
* @Copyright
* @Version 
*/
package com.interframe.hr.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.interframe.hr.repository.mybatis.model.SysUser;

/**
* TODO
* @ClassName: UserServiceTests
* @author jason
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:root-context-test.xml"})
@ActiveProfiles("mybatis")
public class UserServiceTests {

	@Autowired
	private UserService userService;
	
	@Test
	public void selectByIdTest(){
		SysUser user = userService.selectById("001");
		System.out.println(user.getName());
	}
}
