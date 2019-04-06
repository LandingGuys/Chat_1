<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<head>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.css"/>
		<script src="bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="bootstrap-3.3.7-dist/js/bootstrap.js"></script>
		<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="js/jquery.validate.js"></script>
		<script type="text/javascript" src="js/javascript.js"></script>
		<script type="text/javascript">
		function checkName(){
			var username = document.getElementsByName('username')[0].value;
			
			$.ajax({
				type:"POST",
				url:"/Final/UserServlet",
				data:{username:$("#username").val(),method:"checkUsername"},
				dataType:"text",
				success:function(data){
					$("#usernameMsg").html(data);
				}
			});
			
		}
		
		</script>
		<link rel="stylesheet" type="text/css" href="css/index.css"/>
	</head>
	<style type="text/css">
		body{
			background: url(img/背景图片05.jpg);
		}
		h1{
			text-align: center;
			color: limegreen;
		}
	</style>
	<body>  
	
        <%
		  HashMap<String,String> errors = (HashMap<String,String>)request.getAttribute("errors");
		%>
		<div class="container">
			<div class="row" style="margin-top: 50px;margin-bottom: 30px;">
				<div class="col-md-1 col-md-offset-4" style="text-align: center;"><div class="glyphicon glyphicon-bold" style="font-size: 70px;color: rgb(255,161,29);"></div></div>
				<div class="col-md-3"><h1><strong>注册Better账号</strong></h1></div>
			</div>
			<div id="parent">
			<div id="small">
			<form action="<%=request.getContextPath() %>/UserServlet" method="post" id="empForm">
				<input type="hidden" name="method" value="register"/>
				<table border="0px" style="border-collapse:separate; border-spacing:0px 10px;">
					<tr>
						<td>用户名</td><td><input type="text" name="username" id="username" value="" onblur="checkName()"/>
						<span id="usernameMsg">
							 
						</span></td>
					</tr>
					<tr>
						<td>设置密码</td><td><input type="password" name="password" id="password" value="" /></td>
					</tr>
					<tr>
						<td>确认密码</td><td><input type="password" name="repassword" id="repassword" value="" /></td>
					</tr>
					<tr>
						<td>常用邮箱</td><td><input type="text" name="email" id="email" value="" /></td>
					</tr>
					<tr>
						<td>联系方式</td><td><input type="text" name="tel" id="tel" value="" /></td>
					</tr>
					
				</table>
				<input type="submit" class="btn" id="btn" value="注册" />
				<input type="submit" class="btn"  onclic="reset()" value="重置" />
			</form>
			</div>
		</div>
		
	</body>
</html>