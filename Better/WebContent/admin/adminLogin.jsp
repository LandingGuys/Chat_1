<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/bootstrap-3.3.7-dist/css/bootstrap.css"/>
		<script src="<%=request.getContextPath() %>/bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=request.getContextPath() %>/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
	</head>
	<style type="text/css">
		body{
			background: url(img/背景图片03.png);
		}
		.row .col-md-6.col-md-offset-3{
			margin-bottom: 20px;
		}
		.col-md-2.control-label{
			font-size: 20px;
			
		}
		.form-control{
			height: 40px;
			background: rgb(247,247,249);
		}
		.btn{
			font-size: 20px;
		}
	</style>
	<body>  
		<div class="container">
			<div class="row" style="margin-top: 50px;">
				<div class="col-md-4 col-md-offset-4" style="text-align: center;"><div class="glyphicon glyphicon-bold" style="font-size: 150px;color: rgb(255,161,29);"></div></div>
			</div>
			<div class="row" style="margin-bottom: 50px;">
				<div class="col-md-4 col-md-offset-4" style="text-align: center;"><h1>管理员登录</h1></div>
			</div>
			<form action="<%=request.getContextPath() %>/AdminServlet" method="post" id="loginForm">
			<input type="hidden" name="method" value="login"/>
			 <input type="hidden" name="currentPage" value="1"/>
				<div class="row">    
					<div class="col-md-6 col-md-offset-3">   <!--用户名-->
						<div class="form-horizontal">
							<div class="form-group">
								<label for="userName" class="col-md-2 control-label">账号</label>
								<div class="col-md-10">
									<input type="text" id="adminName" name="adminName"value="" class="form-control" placeholder="请输入账号..."/>
								</div>
							</div>
						</div>
					</div>
			
					<div class="col-md-6 col-md-offset-3">   <!--//密码-->
						<div class="form-horizontal">
							<div class="form-group">
								<label for="passWord" class="col-md-2 control-label">密码</label>
								<div class="col-md-10">
									<input type="password" id="adminpassWord" name="adminpassWord"value="" class="form-control" placeholder="请输入密码..."/>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-6 col-md-offset-3">  <!--登录注册按钮-->
						<input  type="submit" class="col-md-4 col-md-offset-2 btn btn-primary "  value="登录"/>
					</div>
					<div>
						${requestScope.error }
					</div>
				</div>
				</form>
		</div>
	</body>
	<script type="text/javascript">
 		
		
	</script>
</html>
   