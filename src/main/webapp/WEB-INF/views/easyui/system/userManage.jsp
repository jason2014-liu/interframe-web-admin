<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>user manage</title>
<script type="text/javascript">
var setting = {
		data : {
			key : {
				title : "t"
			},
			simpleData : {
				enable : true
			}
		}
	};


$(document).ready(function() {
	
	$.post("<%=request.getContextPath()%>/system/org/getAllOrg", "",
							function(data, status) {
								//alert("Data: " + data + "\nStatus: " + status);
								$.fn.zTree.init($("#orgTree"), setting,data);
							});
}
</script>
</head>
<body>

	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'west',split:true" style="width: 100px"
			title="组织机构树">
			<ul id="orgTree" class="ztree"></ul>
		</div>

		<div data-options="region:'center'">
			<table id="dg" title="用户列表" class="easyui-datagrid"
				style="width: 700px; height: 250px" url="get_users.php"
				toolbar="#toolbar" pagination="true" rownumbers="true"
				fitColumns="true" singleSelect="true">
				<thead>
					<tr>
						<th field="firstname" width="50">First Name</th>
						<th field="lastname" width="50">Last Name</th>
						<th field="phone" width="50">Phone</th>
						<th field="email" width="50">Email</th>
					</tr>
				</thead>
			</table>
			<div id="toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-add" plain="true" onclick="newUser()">新增</a> <a
					href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-edit" plain="true" onclick="editUser()">编辑</a> <a
					href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-remove" plain="true" onclick="destroyUser()">删除</a>
			</div>

			<div id="dlg" class="easyui-dialog"
				style="width: 400px; height: 280px; padding: 10px 20px"
				closed="true" buttons="#dlg-buttons">
				<div class="ftitle">User Information</div>
				<form id="fm" method="post" novalidate>
					<div class="fitem">
						<label>First Name:</label> <input name="firstname"
							class="easyui-textbox" required="true">
					</div>
					<div class="fitem">
						<label>Last Name:</label> <input name="lastname"
							class="easyui-textbox" required="true">
					</div>
					<div class="fitem">
						<label>Phone:</label> <input name="phone" class="easyui-textbox">
					</div>
					<div class="fitem">
						<label>Email:</label> <input name="email" class="easyui-textbox"
							validType="email">
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
				<a href="javascript:void(0)" class="easyui-linkbutton c6"
					iconCls="icon-ok" onclick="saveUser()" style="width: 90px">保存</a> <a
					href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-cancel"
					onclick="javascript:$('#dlg').dialog('close')" style="width: 90px">取消</a>
			</div>

		</div>
	</div>
	<script type="text/javascript">
		var url;
		function newUser() {
			$('#dlg').dialog('open').dialog('setTitle', 'New User');
			$('#fm').form('clear');
			url = 'save_user.php';
		}
		function editUser() {
			var row = $('#dg').datagrid('getSelected');
			if (row) {
				$('#dlg').dialog('open').dialog('setTitle', 'Edit User');
				$('#fm').form('load', row);
				url = 'update_user.php?id=' + row.id;
			}
		}
		function saveUser() {
			$('#fm').form('submit', {
				url : url,
				onSubmit : function() {
					return $(this).form('validate');
				},
				success : function(result) {
					var result = eval('(' + result + ')');
					if (result.errorMsg) {
						$.messager.show({
							title : 'Error',
							msg : result.errorMsg
						});
					} else {
						$('#dlg').dialog('close'); // close the dialog
						$('#dg').datagrid('reload'); // reload the user data
					}
				}
			});
		}
		function destroyUser() {
			var row = $('#dg').datagrid('getSelected');
			if (row) {
				$.messager.confirm('Confirm',
						'Are you sure you want to destroy this user?',
						function(r) {
							if (r) {
								$.post('destroy_user.php', {
									id : row.id
								}, function(result) {
									if (result.success) {
										$('#dg').datagrid('reload'); // reload the user data
									} else {
										$.messager.show({ // show error message
											title : 'Error',
											msg : result.errorMsg
										});
									}
								}, 'json');
							}
						});
			}
		}
	</script>

</body>
</html>