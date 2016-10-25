
<%@ page session="false" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

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