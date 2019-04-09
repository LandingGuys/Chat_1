<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>MyBlog | Login</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name" style="font-size: 70px;">MyBlog</h1>

            </div>
            <h3>Welcome to MyBlog</h3>
            <p style="font-size: 20px;font-weight: bold;">
             注册登录MyBlog
            </p>
            <p>Login in. To see it in action.</p>
            <form class="m-t" role="form" method="post" action="<%=request.getContextPath()%>/UserServlet">
            <input type="hidden" name="method" value="login"/>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Username" name="user_name" required="">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="Password"  name="user_password" required="">
                </div>
                 <div class="form-group">
                   <input style="width:90px; height: 34px;" type="text" name="checkcode">
						<img style="width: 100px; height: 34px;" id="imgcode" src="<%=request.getContextPath()%>/UserServlet?method=createCheckCode"/>
						<a id="ccode"  style="font-size:14px;" href="javascript:void(0)" onclick="ccode()">看不清，换一张</a>
                </div>
                <div>
                	<%
			  		String errrorMsg = (String)request.getAttribute("error");
				 	if(errrorMsg!=null){
					 	out.print(errrorMsg);
				 	}
				 %>
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">Login</button>

                <a href="login.jsp#"><small>Forgot password?</small></a>
                <p class="text-muted text-center"><small>Do not have an account?</small></p>
                <a class="btn btn-sm btn-white btn-block" href="register.jsp">Create an account</a>
             	 <a class="btn btn-sm btn-white btn-block" href="<%=request.getContextPath()%>/FangkeServlet?method=tofangkeindex">访客登录</a>
            </form>
            <p class="m-t"> <small>联系我们 &copy; 2018</small> </p>
        </div>
    </div>

    <!-- Mainly scripts -->
    <script src="js/jquery-2.1.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
	<script>
		function ccode(){
			var time = new Date();
			$("#imgcode").attr("src","<%=request.getContextPath()%>/UserServlet?method=createCheckCode&time="+time);
		}
		</script>
</body>

</html>
