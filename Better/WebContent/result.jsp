<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

   <title>跳转页面</title>
<style type="text/css">
		body{
			background: url(img/背景图片05.jpg);
		}
		h1{
			text-align: center;
			color: limegreen;
		}
		p{
			text-align: center;
			color: limegreen;
			font-size:150px;
		}
	</style>

<script type="text/javascript">
	
	window.onload=function(){
		setTimeout("fun(3)",1000)
	}
	
	function fun(n){
		n--;
		document.getElementById("p").innerHTML=n;
		setTimeout("fun("+n+")",1000)
	}
</script>
</head>
<body>
<h1>恭喜您注册成功,即将跳转到登录页面</h1>
<p id="p">3</p>
<%
 response.setHeader("Refresh", "3;URL="+request.getContextPath()+"/login.jsp");
%>
</body>
</html>