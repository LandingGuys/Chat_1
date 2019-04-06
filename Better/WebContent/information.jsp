<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="henu.rjxy.bean.User,java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title></title>
		<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
		<script src="bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="bootstrap-3.3.7-dist/js/holder.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<style type="text/css">
		body{
			padding-top: 80px;
			background: #669999;
			
			
		}
	</style>
	<%
	User showUser=(User)request.getAttribute("user");
	%>
	<body>
		<div class="container">
			<nav class="navbar navbar-inverse navbar-fixed-top">   <!--导航栏-->
				<div class="container">
					<div class="navbar-header">
				      <button class="navbar-toggle collapsed" data-toggle="collapse" data-target="#mynavbar">
				      	<span class="sr-only">Toggle navigation</span>
			        	<span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				      </button>
				      <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-bold" style="color: rgb(255,161,29); "></span></a>
				    </div>
		    
				    <div id="mynavbar" class="collapse navbar-collapse">
				    	<ul class="nav navbar-nav">
				    		<li><a href="<%=request.getContextPath() %>/UserServlet?method=toindex&username=<%=showUser.getUsername() %>">首页</a></li>
				    		<li class="dropdown">
				    			<a href="" class="dropdown-toggle" data-toggle='dropdown'>排行榜<span class="caret"></span></a>
				    			<ul class="dropdown-menu">
				    			<li><a href="<%=request.getContextPath() %>/UserServlet?method=tosport&userId=<%=showUser.getUserId() %>&currentPage=1" id="sportRank">运动排行榜</a></li>
				    				<li><a href="<%=request.getContextPath() %>/UserServlet?method=tostudy&userId=<%=showUser.getUserId() %>&currentPage=1">学习排行榜</a></li>
				    				<li><a href="">更多排行榜</a></li>
				    			</ul>
				    		</li>
				    		<li><a href="<%=request.getContextPath() %>/UserServlet?method=toshare&userId=<%=showUser.getUserId() %>">我的分享</a></li>
				    		<li><a href="<%=request.getContextPath() %>/UserServlet?method=tofriend&userId=<%=showUser.getUserId() %>">好友</a></li>
				    		<li><a href=""></a></li>
				    	</ul>
				    	<ul class="nav navbar-nav navbar-right">
				    		<li class="active"><a href="<%=request.getContextPath() %>/UserServlet?method=showUser&userId=<%=showUser.getUserId() %>"><%=showUser.getUsername() %> <span class="glyphicon glyphicon-user"></span></a></li>
				    		<a href="<%=request.getContextPath() %>/UserServlet?method=showUser&userId=<%=showUser.getUserId() %>"><img class="img-circle" src="/images/<%=showUser.getImage() %>" width="50px" height="50px"/></a>
				    	</ul>
				  
				    </div>
		   	 	</div>
			</nav>     <!--导航栏结束-->
			<div class="list-group col-md-2 col-md-offset-1" id="guide">
				<a class="list-group-item active">个人资料</a>
				<a class="list-group-item"><span class="badge" style="background-color: deepskyblue;">57</span>我的关注</a>
				<a class="list-group-item"><span class="badge" style="background-color: red;">99+</span>我的粉丝</a>
				<a class="list-group-item"><span class="badge" style="background-color: limegreen;">24</span>我的收藏</a>
			</div>
			<div class="panel panel-primary col-md-8 ">
				<div class="panel-body">
					<div class="col-md-2 col-md-offset-1">
								<img class="img-circle" src="/images/<%=showUser.getImage() %>" width="80px" height="80px" />
							
						</div>
					</div>
					<form class="form-horizontal">
					  <div class="form-group">
					    <label class="col-md-2 control-label">用户名</label>
					    <div class="col-md-2">
					      <p class="form-control-static"><%=showUser.getUsername() %></p>
					    </div>
					    <div class="col-md-5"><img src="img/nan_1.png"/ width="34px"></div>
					      
					  </div>
					  <div class="form-group">
					    <label class="col-md-2 control-label">年龄</label>
					    <div class="col-md-10">
					      <p class="form-control-static"><%=showUser.getAge() %></p>
					    </div>
					  </div>
					  <div class="form-group">
					    <label class="col-md-2 control-label">职业</label>
					    <div class="col-md-10">
					      <p class="form-control-static"><%=showUser.getOccupation() %></p>
					    </div>
					  </div>
					  <div class="form-group">
					    <label class="col-md-2 control-label">个性签名</label>
					    <div class="col-md-10">
					      <p class="form-control-static"><%=showUser.getTarget() %></p>
					    </div>
					  </div>
					  <div class="form-group">
					    <label class="col-md-2 control-label">爱好</label>
					    <div class="col-md-10">
					      <p class="form-control-static">学习，打篮球，玩游戏</p>
					    </div>
					  </div>
					  <div class="form-group">
					    <label class="col-md-2 control-label">邮箱</label>
					    <div class="col-md-10">
					      <p class="form-control-static"><%=showUser.getEmail() %></p>
					    </div>
					  </div>
					  <div class="form-group">
					    <label class="col-md-2 control-label">手机号</label>
					    <div class="col-md-10">
					      <p class="form-control-static"><%=showUser.getTel() %></p>
					    </div>
					  </div>
					  <div class="form-group">
					    <label class="col-md-2 control-label">地区</label>
					    <div class="col-md-10" id="di">
					      <p class="form-control-static" id="qw"><%=showUser.getAddress() %></p>
					    </div>
					  </div>
					  <div class=" form-group">
					  	<div class="col-md-2 col-md-offset-2">
					  		<a href="<%=request.getContextPath()%>/UserServlet?method=toUpdatePage&userId=<%=showUser.getUserId()%>" class="btn btn-primary" id="modify">修改个人资料</a>
					  	</div>
					  </div>
					</form>
				</div>
			</div>
		</div>
		
	</body>
	<script type="text/javascript">
//		document.getElementById("modify").addEventListener('click',function(){
//			document.getElementById("qw").innerHTML='qwe';
//		});
		$('#modify').click(function(){
			$('#di').innerHTML='123';
		});
		
	</script>
</html>
