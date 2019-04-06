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
		<div class="container">
			<div class="row col-md-offset-8">
				<form class="navbar-form navbar-left" role="search" action="<%=request.getContextPath() %>/AdminServlet" method="post">
					<input type="hidden" name="method" value="SerachByName"/>
					<div class="form-group">
						<input type="text" class="form-control" name="searchname" placeholder="搜索">
					</div>
					<button type="submit" class="btn btn-default "><span class="glyphicon glyphicon-search" style="font-size: 16px;"></span></button>
				</form>
			</div>
			<div class="col-md-10 col-md-offset-1">
				<div class="panel panel-default ">
					<div class="panel-heading" style="background-color: #0099CC;text-align: center;">
						<h2><strong>Better用户</strong></h2>
					</div>
					<div class="table table-responsive">
						<table class="table table-hover table-striped">
							<tr>
								<th>编号</th>
								<th>用户名</th>
								<th>邮箱</th>
								<th>手机号</th>
								<th>地址</th>
								<th>年龄</th>
								<th>职业</th>
							
								<th>操作</th>
							</tr>
						<c:forEach items="${requestScope.userList }" var="searchAllUser" varStatus="s">
		  					<tr>
								<td>${s.index+1 }</td>
								<td>${searchAllUser.username}</td>
								<td>${searchAllUser.email}</td>
								<td>${searchAllUser.tel}</td>
								<td>${searchAllUser.address}</td>
								<td>${searchAllUser.age}</td>
								<td>${searchAllUser.occupation}</td>
								
								<td>
									<a href="<%=request.getContextPath()%>/AdminServlet?method=toupdateUser&userId=${searchAllUser.userId }&currentPage=${requestScope.pageModel.currentPage}"><button class="btn btn-success ">修改</button></a>
									<a href="<%=request.getContextPath()%>/AdminServlet?method=deleteUser&userId=${searchAllUser.userId }&currentPage=${requestScope.pageModel.currentPage}"><button class="btn btn-danger ">删除</button></a>
								</td>
							</tr>
		 
						</c:forEach>
							
						</table>
					</div>
				</div>
			</div>
			<div class="row">
				<nav aria-label="Page navigation" class="col-md-6 col-md-offset-4">
					<ul class="pagination pagination-lg" id="myul">
						<li>
							<a href="<%=request.getContextPath()%>/AdminServlet?method=toadmin&currentPage=${requestScope.pageModel.prePage}" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
							</a>
						</li>
						<li class="active">
							<a href="<%=request.getContextPath()%>/AdminServlet?method=toadmin&currentPage=1">1</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/AdminServlet?method=toadmin&currentPage=2">2</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/AdminServlet?method=toadmin&currentPage=3">3</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/AdminServlet?method=toadmin&currentPage=4">4</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/AdminServlet?method=toadmin&currentPage=5">5</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/AdminServlet?method=toadmin&currentPage=6">6</a>
						</li>
						<li>
							<a href="<%=request.getContextPath()%>/AdminServlet?method=toadmin&currentPage=${requestScope.pageModel.nextPage}" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
							</a>
						</li>
					</ul>
					
				</nav>
			</div>
		</div>
		<div>
			${requestScope.result }
		</div>
	</body>
	<script>
	$("ul li").click(function(){
			
			$("ul li").removeClass("active");
			$(this).addClass("active")
		})
	</script>

</html>