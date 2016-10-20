/**
* TODO
* @Project: interframe-web-admin
* @Title: MyRealm.java
* @Package com.interframe.system.security
* @author jason
* @Date 2016年10月20日 下午3:28:08
* @Copyright
* @Version 
*/
package com.interframe.system.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.interframe.system.repository.mybatis.model.User;
import com.interframe.system.service.UserService;

/**
 * TODO 自定义的指定Shiro验证用户登录的类 
 * 
 * @ClassName: MyRealm
 * @author jason
 */
public class MyRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	/**
	 *  返回当前登录的Subject的角色和权限   经测试:本例中该方法的调用时机为需授权资源被访问时 
	 *  经测试:并且每次访问需授权资源时都会执行该方法中的逻辑,这表明本例中默认并未启用AuthorizationCache
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		//可从缓存中取用户角色与权限数据，，，
		
		//test  硬编码 与xml配置中一致
		String currUsername = (String)super.getAvailablePrincipal(principals);
		if("admin".equals(currUsername)){
			SimpleAuthorizationInfo authInfo = new SimpleAuthorizationInfo();
			authInfo.addRole("admin");
			authInfo.addStringPermission("admin:manage");
		}
		return null;
	}

	/**
	 * 登录验证 subject.login(token)时调用
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub

		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		User currUser = userService.findByLoginName(upToken.getUsername());

		if (currUser != null) {
			AuthenticationInfo authInfo = new SimpleAuthenticationInfo(currUser.getLoginName(), currUser.getPassword(),
					this.getName());
			return authInfo;
		} else {
			return null;
		}

	}

}
