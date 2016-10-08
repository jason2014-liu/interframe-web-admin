/**
* TODO
* @Project: interframe-web-admin
* @Title: IndexController.java
* @Package com.interframe.hr.web
* @author jason
* @Date 2016年9月26日 上午10:52:14
* @Copyright
* @Version 
*/
package com.interframe.hr.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.interframe.hr.web.vo.ZTreeNode;

/**
* TODO
* @ClassName: IndexController
* @author jason
*/
@Controller
@RequestMapping(value="/hr")
public class IndexController {

	@RequestMapping(value="/getMenus",method=RequestMethod.POST)
	@ResponseBody
	public List<ZTreeNode> getMenus(){
		
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
