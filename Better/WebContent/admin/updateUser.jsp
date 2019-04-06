<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<meta charset="utf-8" />
		<title></title>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/iconfont.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/bootstrap-3.3.7-dist/css/bootstrap.css" />
		<script src="<%=request.getContextPath() %>/bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="<%=request.getContextPath() %>/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
	</head>
	<style type="text/css">
		header {
			width: 100%;
			height: 100px;
			background-color: #303030;
			margin-bottom: 50px;
		}
		
		header p {
			color: white;
			text-align: center;
			font-size: 80px;
		}
		.blue{background: rgb(40,169,227);color: white;}
	</style>

<body>
		<header>
			<p><strong>admin</strong></p>
		</header>
		<div style="width: 800px;text-align: center; margin: 0 auto;">
				<form class="form-horizontal" action="<%=request.getContextPath()%>/AdminServlet" method="post" >
	   					<input type="hidden" name="method" value="updateUser"/>
	   					<input type="hidden" name="userId" value="${user.userId }"/>
	   					<input type="hidden" name="currentPage" value="${requestScope.currentPage}"/>
	   					
					  <div class="form-group" style="margin-top: 100px;">
					    <label class="col-md-2 control-label">用户名</label>
					    <div class="col-md-2">
					      <input class="form-control" type="text" name="username" id="" value="${user.username } " />
					    </div>
					    <div class="col-md-5"><img src="img/nan_1.png" width="34px"/></div>
					  </div>
					  <div class="form-group">
					    <label class="col-md-2 control-label">密码</label>
					    <div class="col-md-10">
					      <input class="form-control" type="password" name="psw" id="" value="${user.psw }" />
					    </div>
					  </div>
					  <div class="form-group">
					    <label class="col-md-2 control-label">年龄</label>
					    <div class="col-md-10">
					      <input class="form-control" type="text" name="age" id="" value="${user.age }" />
					    </div>
					  </div>
					  <div class="form-group">
					    <label class="col-md-2 control-label">职业</label>
					    <div class="col-md-10">
					      <input class="form-control" type="text" name="occupation" id="" value="${user.occupation }" />
					    </div>
					  </div>
					  <div class="form-group">
					    <label class="col-md-2 control-label">个性签名</label>
					    <div class="col-md-10">
					      <input class="form-control" type="text" name="target" id="" value="${user.target }" />
					    </div>
					  </div>
					  <div class="form-group">
					    <label class="col-md-2 control-label">邮箱</label>
					    <div class="col-md-10">
					      <input class="form-control" type="text" name="email" id="" value="${user.email }" />
					    </div>
					  </div>
					  <div class="form-group">
					    <label class="col-md-2 control-label">手机号</label>
					    <div class="col-md-10">
					       <input class="form-control" type="text" name="tel" id="" value="${user.tel }" />
					    </div>
					  </div>
					  <div class="form-group">
					    <label class="col-md-2 control-label">地区</label>
					    <div class="col-md-10" id="di">
					       <input class="form-control" type="text" name="address" id="" value="${user.address }" />
					    </div>
					  </div>
					  <div class=" form-group">
					  	<input type="submit" class="col-md-2 col-md-offset-6 btn btn-primary" id="modify" value="保存">
					  </div>
					</form>
					</div>
			

</body>
</html>
