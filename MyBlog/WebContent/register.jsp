<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>MyBlog | Register</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen   animated fadeInDown">
        <div>
            <div>

                  <h1 class="logo-name" style="font-size: 70px;">MyBlog</h1>

            </div>
            <h3>Register to MyBlog</h3>
            <p>Create account to see it in action.</p>
            <form class="m-t" role="form" method="post" action="<%=request.getContextPath() %>/UserServlet" onsubmit="return checkAgreement();">
            <input type="hidden" name="method" value="register"/>
                <div class="form-group" style="height: 34px;width: 380px;">
                    <input type="text" class="form-control" placeholder="Name" name="user_name" required="" onblur="checkName()" style="width: 300px;float: left;">
                     <span id="usernameMsg"  style="text-align:center;float: left;line-height: 34px;"></span>
                </div>
                <div class="form-group">
                    <input type="email" class="form-control" placeholder="Email" name="user_email" required="">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="Password" name="user_password" required="">
                </div>
                <div class="form-group">
                        <div class="checkbox i-checks"><label> <input type="checkbox" name="agreement" id="agreement"><i></i> Agree the terms and policy </label></div>
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">Register</button>

                <p class="text-muted text-center"><small>Already have an account?</small></p>
                <a class="btn btn-sm btn-white btn-block" href="login.jsp">Login</a>
            </form>
            <p class="m-t"> <small>联系我们 &copy; 2018</small> </p>
        </div>
    </div>

    <!-- Mainly scripts -->
    <script src="js/jquery-2.1.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <!-- iCheck -->
    <script src="js/plugins/iCheck/icheck.min.js"></script>
    <script>
        $(document).ready(function(){
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
    </script>
    <script  type="text/javascript">
		function checkAgreement()
			{
				if (document.getElementById("agreement").checked == false)
					{
						alert("Please agree the terms and policy");
						document.getElementById("agreement").focus();
						return false;
					}
				return true;
		}
	</script>
	<script type="text/javascript">
		function checkName(){
			var user_name = document.getElementsByName('user_name')[0].value;
			 $.ajax({
	             type: "POST",
	             url: "/MyBlog/UserServlet",
	             data: {user_name:user_name,method:"checkUsername"},
	             dataType: "text",
	             success: function(data){
	            	 $("#usernameMsg").html(data);
	              }
	         });
			
		}
		
		</script>
</body>

</html>
