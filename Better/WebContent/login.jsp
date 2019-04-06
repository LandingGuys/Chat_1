<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.css"/>
		<script src="bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
		
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
		p{
			font-size: 20px;
			color:red;
		}
	</style>
	<script>
		function ccode(){
			var time = new Date();
			$("#imgcode").attr("src","<%=request.getContextPath()%>/UserServlet?method=createCheckCode&time="+time);
		}
		
	</script>
	<body>  
		 <%
		  HashMap<String,String> errors = (HashMap<String,String>)request.getAttribute("errors");
		%>
		<div class="container">
			<div class="row" style="margin: 60px;">
				<div class="col-md-4 col-md-offset-4" style="text-align: center;"><div class="glyphicon glyphicon-bold" style="font-size: 200px;color: rgb(255,161,29);"></div></div>
			</div>
			<form action="<%=request.getContextPath() %>/UserServlet" method="post" id="loginForm">
			<input type="hidden" name="method" value="login"/>
			<div class="row">    
				<div class="col-md-6 col-md-offset-3">   <!--用户名-->
					<div class="form-horizontal">
						<div class="form-group">
							<label for="userName" class="col-md-2 control-label">用户名</label>
							<div class="col-md-10">
								<input type="text" id="userName" name="username" value="" class="form-control" placeholder="请输入用户名..."/>
								
							</div>
						</div>
					</div>
				</div>
			
				<div class="col-md-6 col-md-offset-3">   <!--//密码-->
					<div class="form-horizontal">
						<div class="form-group">
							<label for="password" class="col-md-2 control-label">密码</label>
							<div class="col-md-10">
								<input type="password" id="password" name="password" value="" class="form-control" placeholder="请输入密码..."/>
								
							</div>
						</div>
					</div>
				</div>
				
				<div class="col-md-6 col-md-offset-3">   <!--验证码-->
					<div class="form-horizontal">
						<div class="form-group">
							<label for="userName" class="col-md-2 control-label" name="checkcode">验证码</label>
							<div class="col-md-10">
								<input type="text" name="checkcode" value="" class="form-control" placeholder="请输入四位验证码"/>
								<img id="imgcode" src="<%=request.getContextPath()%>/UserServlet?method=createCheckCode"/>
								<a id="ccode"  style="font-size:20px;" href="javascript:void(0)" onclick="ccode()">看不清，换一张</a>
							</div>
						</div>
					</div>
				</div>
				</form>
				<div>
				<p>
				<%
			  		String errrorMsg = (String)request.getAttribute("error");
				 	if(errrorMsg!=null){
					 	out.print(errrorMsg);
				 	}
				 %>
				</p>
				</div>
				<div class="col-md-6 col-md-offset-3">  <!--登录注册按钮-->
					<!-- <a id="login" href="<%=request.getContextPath() %>/首页.html" class="col-md-4 col-md-offset-2 btn btn-primary ">登录</a> -->
					<!-- <a id="register" href="#" class="col-md-4 col-md-offset-1 btn btn-success ">注册</a> -->
					<input  type="submit" class="col-md-4 col-md-offset-2 btn btn-primary "  value="登录"/>
				    <input id="register" type="button" class="col-md-4 col-md-offset-2 btn btn-primary "value="注册"/>
				</div>
				<div class="col-md-6 col-md-offset-8">
					<a href="<%=request.getContextPath() %>/admin/adminLogin.jsp"><i>管理员登录</i></a>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript">
		
		document.getElementById("register").addEventListener("click",function(){
			window.location.href='register.jsp';
		}); 
	</script>
</html>