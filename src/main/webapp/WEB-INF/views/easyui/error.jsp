<%@page import="java.io.PrintWriter"%>
<%@page language="java" contentType="text/html;charset=utf-8"
   pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>程序异常!</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/plugins/jquery-easyui-1.4.5/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/static/plugins/jquery-easyui-1.4.5/themes/icon.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/static/plugins/jquery-easyui-1.4.5/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/static/plugins/jquery-easyui-1.4.5/jquery.easyui.min.js"></script>

<style type="text/css">
*{
	font-size:12px;
}
body {
    font-family:helvetica,tahoma,verdana,sans-serif;
    font-size:13px;
    margin:0;
}
h2 {
    font-size:18px;
    color:#333;
    font-weight:bold;
    margin:0;
    margin-bottom:15px;
}
legend{
	color:#333;
    font-weight:bold;
}
.demo-info{
	background:#FFFEE6;
	color:#8F5700;
	padding:12px;
}
.demo-tip{
	width:24px;
	height:16px;
	float:left;
}
</style>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false">
<fieldset>
<%Exception ex=(Exception)request.getAttribute("exception");%>
<legend>程序异常</legend>

<div class="demo-info">
	<div class="demo-tip icon-no"></div>
	<div><%=ex.getMessage() %></div>
</div>
</fieldset>
</div>
<div data-options="region:'center',border:false">
<div class="easyui-panel"
				data-options="title:'error info',fit:true,iconCls:'icon-tip',
						collapsible:true,minimizable:false,maximizable:false,closable:false">

	<pre>
	<%ex.printStackTrace(new PrintWriter(out));%>
	</pre>

</div>
</div>
</body>
</html>