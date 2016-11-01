<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.interframe.system.repository.mybatis.model.Permission" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/plugins/jquery-easyui-1.4.5/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/plugins/jquery-easyui-1.4.5/themes/icon.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/plugins/zTree_v3-master/css/zTreeStyle/zTreeStyle.css"
	type="text/css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/static/plugins/jquery-easyui-1.4.5/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/static/plugins/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/static/plugins/jquery-easyui-1.4.5/extension/jquery.portal.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/static/plugins/zTree_v3-master/js/jquery.ztree.core.js"></script>
<SCRIPT type="text/javascript">
	var setting = {
		data : {
			key : {
				title : "t"
			},
			simpleData : {
				enable : true
			}
		},
		callback : {
			onClick : onClick
		}
	};

	
	function onClick(event, treeId, treeNode, clickFlag) {

		//alert(treeNode.name);
		addTab(treeNode.name,'<%=request.getContextPath()%>'+treeNode.menu_url);
		
	}
	
	function addTab(title, url){
	    if ($('#tt').tabs('exists', title)){
	        $('#tt').tabs('select', title);
	    } else {
	        var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
	        $('#tt').tabs('add',{
	            title:title,
	            content:content,
	            closable:true
	        });
	    }
	}
	

	$(document).ready(function() {
		
		$.post("<%=request.getContextPath()%>/system/user/getMenus", "",
								function(data, status) {
									//alert("Data: " + data + "\nStatus: " + status);
									$.fn.zTree.init($("#treeDemo"), setting,data);
								});

		//init portal
		var options = {};
		
		$('#pp').portal(options);
		
		// create the panel
		var p = $('<div></div>').appendTo('body');
		p.panel({
		    title: 'My Title',
		    height:150,
		    closable: true,
		    collapsible: true
		});
		
		var p2 = $('<div></div>').appendTo('body');
		p2.panel({
		    title: 'clock',
		    height:150,
		    closable: true,
		    collapsible: true
		});
		 
		// add the panel to portal
		$('#pp').portal('add', {
		    panel: p,
		    columnIndex: 0
		});
		$('#pp').portal('add', {
		    panel: p2,
		    columnIndex: 1
		});


});
</SCRIPT>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false"
		style="height: 60px; background: #B3DFDA; padding: 10px">north
		region</div>
	<div data-options="region:'west',split:true,title:'West'"
		style="width: 250px; padding: 10px;">
		<div class="easyui-accordion">
			
			<c:forEach var="item" items="${requestScope.modules}">
				<div title="${item.description}" style="overflow: auto; padding: 10px;">
					<ul id="treeDemo" class="ztree"></ul>
				</div>
			</c:forEach>
		</div>
	</div>
	<div
		data-options="region:'east',split:true,collapsed:true,title:'East'"
		style="width: 100px; padding: 10px;">east region</div>
	<div data-options="region:'south',border:false"
		style="height: 50px; background: #A9FACD; padding: 10px;">south
		region</div>
	<div data-options="region:'center',title:'Center'">

		<div id="tt" class="easyui-tabs">
		
			<div id="pp" style="width: 700px; position: relative">
				<div style="width: 30%;"></div>
				<div style="width: 30%;"></div>
				<div style="width: 30%;"></div>
			</div>
			
		</div>

	</div>
</body>
</html>