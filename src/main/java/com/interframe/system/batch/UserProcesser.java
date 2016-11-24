/**
* TODO
* @Project: interframe-web-admin
* @Title: UserProcesser.java
* @Package com.interframe.system.batch
* @author jason
* @Date 2016年11月10日 上午10:31:42
* @Copyright
* @Version 
*/
package com.interframe.system.batch;

import org.springframework.batch.item.ItemProcessor;

import com.interframe.system.repository.mybatis.model.User;

/**
* TODO
* @ClassName: UserProcesser
* @author jason
*/
public class UserProcesser implements ItemProcessor<User, User> {

	@Override
	public User process(User user) throws Exception {
		// TODO Auto-generated method stub
		User finalUser = new User();
		finalUser.setId(user.getId());
		finalUser.setLoginName(user.getLoginName());
		finalUser.setName("已处理");
		finalUser.setPassword(user.getPassword());
		finalUser.setValid(user.getValid());
		return finalUser;
	}

}
