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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.interframe.system.repository.mybatis.model.Permission;
import com.interframe.system.service.PermissionService;
import com.interframe.system.web.form.LoginForm;
import com.interframe.system.web.vo.ZTreeNode;


/**
* TODO
* @ClassName: UserController
* @author jason
*/
@Controller
@RequestMapping(value="/system/user")
public class UserController {

	@Autowired
	private PermissionService permissionService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView login(LoginForm form){
	    //UsernamePasswordToken token = new UsernamePasswordToken(form.getUsername(), form.getPassword());

		
		ModelAndView mv = new ModelAndView("/home");
		List<Permission> modules = permissionService.findModulesByUserId("001");
		mv.addObject("modules", modules);
		return mv;
	}
	
	
	@RequestMapping(value="/getMenus",method=RequestMethod.POST)
	public @ResponseBody List<ZTreeNode> getMenus(){
		
		List<ZTreeNode> menus = new ArrayList<ZTreeNode>();
		ZTreeNode node1 = new ZTreeNode("1","权限管理","0");
		ZTreeNode node11 = new ZTreeNode("11","角色维护","1");
		ZTreeNode node12 = new ZTreeNode("12","权限维护","1");
		ZTreeNode node2 = new ZTreeNode("2","系统配置","0");
		menus.add(node1);
		menus.add(node11);
		menus.add(node12);
		menus.add(node2);
		
		return menus;
	}
}
