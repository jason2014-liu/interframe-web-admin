/**
* TODO
* @Project: interframe-web-admin
* @Title: UserController.java
* @Package com.interframe.system.web
* @author jason
* @Date 2016年10月11日 上午9:37:44
* @Copyright
* @Version 
*/
package com.interframe.system.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.interframe.system.repository.mybatis.model.Permission;
import com.interframe.system.repository.mybatis.model.User;
import com.interframe.system.repository.mybatis.page.PageInfo;
import com.interframe.system.service.PermissionService;
import com.interframe.system.service.UserService;
import com.interframe.system.web.form.LoginForm;
import com.interframe.system.web.vo.DataGrid;
import com.interframe.system.web.vo.ZTreeNode;

/**
 * TODO
 * 
 * @ClassName: UserController
 * @author jason
 */
@Controller
@RequestMapping(value = "/system/user")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(LoginForm form) {

		UsernamePasswordToken token = new UsernamePasswordToken(form.getUsername(), form.getPassword());
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.login(token);
		
		String msg = null;
		
		try {
		    currentUser.login(token);
		} catch ( UnknownAccountException uae ) { 
			msg = uae.getMessage();
		} catch ( IncorrectCredentialsException ice ) { 
			msg = "密码错误！";
		} catch ( LockedAccountException lae ) { 
			msg = "账号已被锁定，请联系系统管理员！";
		} catch ( ExcessiveAttemptsException eae ) { 
			msg = "尝试登录多次失败，账户已被锁定！";
		} catch ( AuthenticationException ae ) {
		    //unexpected error?  也可扩展AuthenticationException
			msg = "未知错误！";
		}
		
		if(msg != null){
			ModelAndView mv = new ModelAndView("/system/login");
			mv.addObject("errorMsg", "The username or password was not correct.");
			return mv;
		}

		ModelAndView mv = new ModelAndView("/home");
		List<Permission> modules = permissionService.findModulesByUserId("001");
		mv.addObject("modules", modules);
		return mv;

	}

	@RequestMapping(value = "/getMenus", method = RequestMethod.POST)
	public @ResponseBody List<ZTreeNode> getMenus() {

		List<ZTreeNode> menus = new ArrayList<ZTreeNode>();
		ZTreeNode node1 = new ZTreeNode("1", "权限管理", "0");
		ZTreeNode node11 = new ZTreeNode("11", "角色维护", "1");
		ZTreeNode node12 = new ZTreeNode("12", "权限维护", "1");
		ZTreeNode node2 = new ZTreeNode("2", "系统配置", "0");
		menus.add(node1);
		menus.add(node11);
		menus.add(node12);
		menus.add(node2);

		return menus;
	}
	
	@RequestMapping(value = "/getUsers", method = RequestMethod.POST)
	public @ResponseBody DataGrid<User> queryUsers(HttpServletRequest request, HttpServletResponse response){
		
		String orgId = request.getParameter("orgId");
		int pageNo = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		
		User user = new User();
		user.setOrgId(orgId);
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPage(pageNo);
		pageInfo.setShowCount(pageSize);
		
		
		List<User> users = userService.findByPage(user, pageInfo);
		
		DataGrid<User> dg = new DataGrid<User>();
		dg.setRows(users);
		dg.setTotal(pageInfo.getTotalResult());
		
		return dg;
	}
	
	@RequestMapping("/toUserManage")
	public String toUserManage(){
		return "/system/userManage";
	}
	
	
	
}
