/**
* TODO
* @Project: interframe-web-admin
* @Title: OrgController.java
* @Package com.interframe.system.web
* @author jason
* @Date 2016年10月24日 下午3:17:09
* @Copyright
* @Version 
*/
package com.interframe.system.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.interframe.system.repository.mybatis.model.Org;
import com.interframe.system.service.OrgService;
import com.interframe.system.web.vo.ZTreeNode;

/**
* TODO
* @ClassName: OrgController
* @author jason
*/
@Controller
@RequestMapping("/system/org")
public class OrgController {

	private static final Logger log = LoggerFactory.getLogger(OrgController.class);
	
	@Autowired
	private OrgService orgService;
	
	@RequestMapping(value = "/getAllOrg", method = RequestMethod.POST)
	public @ResponseBody List<ZTreeNode> getAllOrg() {
		
		List<Org> orgs = orgService.findAllOrg();
		List<ZTreeNode> orgTree = new ArrayList<ZTreeNode>();
		ZTreeNode node = null;
		if(orgs!=null){
			for (Org org : orgs) {
				node = new ZTreeNode(org.getId(), org.getName(), org.getParentId());
				orgTree.add(node);
			}
		}

		return orgTree;
	}
	

}
