/**
* TODO
* @Project: interframe-web-admin
* @Title: ZTreeNode.java
* @Package com.interframe.hr.web.vo
* @author jason
* @Date 2016年9月26日 上午10:50:41
* @Copyright
* @Version 
*/
package com.interframe.hr.web.vo;

/**
* TODO
* @ClassName: ZTreeNode
* @author jason
*/
public class ZTreeNode {

	private String id;
	private String name;
	private String pId;
	
	public ZTreeNode() {
		super();
	}

	public ZTreeNode(String id, String name, String pId) {
		super();
		this.id = id;
		this.name = name;
		this.pId = pId;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	
	
}
