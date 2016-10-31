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
		addTab(treeNode.name,'<%=request.getContextPath()%>/system/user/toUserManage');
		
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
	
	var panels = [ {
		id : 'p1',
		title : 'Tutorials',
		height : 200,
		collapsible : true,
		href : '<%=request.getContextPath()%>/'
	}, {
		id : 'p2',
		title : 'Clock',
		href : ''
	}, {
		id : 'p3',
		title : 'PropertyGrid',
		height : 200,
		collapsible : true,
		closable : true,
		href : ''
	}, {
		id : 'p4',
		title : 'DataGrid',
		height : 200,
		closable : true,
		href : ''
	}, {
		id : 'p5',
		title : 'Searching',
		href : ''
	}, {
		id : 'p6',
		title : 'Graph',
		href : ''
	} ];
	
	function getCookie(name){
        var cookies = document.cookie.split(';');
        if (!cookies.length) return '';
        for(var i=0; i<cookies.length; i++){
            var pair = cookies[i].split('=');
            if ($.trim(pair[0]) == name){
                return $.trim(pair[1]);
            }
        }
        return '';
    }
	
    function getPanelOptions(id){
        for(var i=0; i<panels.length; i++){
            if (panels[i].id == id){
                return panels[i];
            }
        }
        return undefined;
    }
	
	function getPortalState(){
        var aa = [];
        for(var columnIndex=0; columnIndex<3; columnIndex++){
            var cc = [];
            var panels = $('#pp').portal('getPanels', columnIndex);
            for(var i=0; i<panels.length; i++){
                cc.push(panels[i].attr('id'));
            }
            aa.push(cc.join(','));
        }
        return aa.join(':');
    }
	
	
    function addPanels(portalState){
        var columns = portalState.split(':');
        for(var columnIndex=0; columnIndex<columns.length; columnIndex++){
            var cc = columns[columnIndex].split(',');
            for(var j=0; j<cc.length; j++){
                var options = getPanelOptions(cc[j]);
                if (options){
                    var p = $('<div/>').attr('id',options.id).appendTo('body');
                    p.panel(options);
                    $('#pp').portal('add',{
                        panel:p,
                        columnIndex:columnIndex
                    });
                }
            }
        }
        
    }
    

	$(document).ready(function() {
		
		$.post("<%=request.getContextPath()%>/system/user/getMenus", "",
								function(data, status) {
									//alert("Data: " + data + "\nStatus: " + status);
									$.fn.zTree.init($("#treeDemo"), setting,data);
								});

						//init portal


	$('#pp').portal({
	onStateChange : function() {
		var state = getPortalState();
		var date = new Date();
		date.setTime(date.getTime() + 24 * 3600 * 1000);
		document.cookie = 'portal-state='
				+ state
				+ ';expires='
				+ date.toGMTString();
	}
	});
	
	var state = getCookie('portal-state');
	if (!state) {
		state = 'p1,p2:p3,p4:p5,p6'; // the default portal state
	}
	addPanels(state);
	$('#pp').portal('resize');

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