<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/plugins/bootstrap-3.3.0/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/static/plugins/bootstrap-3.3.0/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src="<%=request.getContextPath()%>/static/plugins/bootstrap-3.3.0/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
	
		$(document).ready(function(){
			
		});
	</script>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading">登录页</div>
		<div class="panel-body">
			<form class="form-horizontal" role="form" action="<%=request.getContextPath()%>/system/user/login" method="post">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
					<div class="col-sm-10">
						<input type="email" class="form-control" id="inputEmail3"
							placeholder="Email">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="inputPassword3"
							placeholder="Password">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox">
							<label> <input type="checkbox"> Remember me
							</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Sign in</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>