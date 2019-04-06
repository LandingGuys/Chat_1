<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,henu.rjxy.bean.*"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title></title>
		<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.css"/>
		<script src="bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<style type="text/css">
		body{
			padding-top: 80px;
			background: #CCFFCC;
			
		}
		th,td{
			text-align: center;
		}
	</style>
	<%
	     User user = (User)request.getAttribute("user");
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
				    		<li><a href="<%=request.getContextPath() %>/UserServlet?method=toindex&username=<%=user.getUsername() %>">首页</a></li>
				    		<li class="dropdown active">
				    			<a href="" class="dropdown-toggle" data-toggle='dropdown'>学习排行榜<span class="caret"></span></a>
				    			<ul class="dropdown-menu">
				    			<li><a href="<%=request.getContextPath() %>/UserServlet?method=tosport&userId=<%=user.getUserId() %>&currentPage=1" id="sportRank">运动排行榜</a></li>
				    				<li><a href="<%=request.getContextPath() %>/UserServlet?method=tostudy&userId=<%=user.getUserId() %>&currentPage=1">学习排行榜</a></li>
				    				<li><a href="">更多排行榜</a></li>
				    				
				    			</ul>
				    		</li>
				    	<li><a href="<%=request.getContextPath() %>/UserServlet?method=toshare&userId=<%=user.getUserId() %>">我的分享</a></li>
				    		<li><a href="<%=request.getContextPath() %>/UserServlet?method=tofriend&userId=<%=user.getUserId() %>">好友</a></li>
				    		<li><a href=""></a></li>
				    	</ul>
				    	<ul class="nav navbar-nav navbar-right">
				    		<li><a href="<%=request.getContextPath() %>/UserServlet?method=showUser&userId=<%=user.getUserId() %>"><%=user.getUsername() %> <span class="glyphicon glyphicon-user"></span></a></li>
				    		<a href="<%=request.getContextPath() %>/UserServlet?method=showUser&userId=<%=user.getUserId() %>"><img class="img-circle" src="/images/<%=user.getImage() %>" width="50px" height="50px"/></a>
				    	</ul>
				    </div>
		   	 	</div>
			</nav>     <!--导航栏结束-->
			
			<div class="row">
				<form class="navbar-form navbar-left" role="search" action="<%=request.getContextPath()%>/UserServlet" method="post">
				  <div class="form-group">
				  	<input type="hidden" name="method" value="searchStudyByName"/>
				  	<input type="hidden" name="userId" value="<%=user.getUserId() %>"/>
				    <input type="text" class="form-control" name="username" placeholder="输入用户名搜索">
				  </div>
				  <button type="submit" class="btn btn-default "><span class="glyphicon glyphicon-search" style="font-size: 16px;"></span></button>
				</form>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading" style="background-color: #0099CC;">
					<h2>学习榜单</h2>
				</div>
				<div class="table table-responsive">
					<table class="table table-hover table-striped">
						<tr>
							<th>#</th>
							<th>用户名</th>
							<th>学习时间</th>
							<th></th>
						</tr>
		<%
		ArrayList<henu.rjxy.dto.searchStudy> study_list=(ArrayList<henu.rjxy.dto.searchStudy>)request.getAttribute("study_list");
		int i=1;
		for(henu.rjxy.dto.searchStudy study:study_list){
		    %>
		    <tr>
		    <td><%=i++ %></td>
		    <td><%=study.getUsername() %></td>
		  
		    <td>读书时间：<%=study.getStudy_time() %>小时</td>
			<td>
				<button class="btn btn-info glyphicon glyphicon-heart" style="color: red;"></span></button>
				<button class="btn btn-info"><span class="glyphicon glyphicon-plus"></span></button>
				<button class="btn btn-danger" data-toggle="modal" data-target="#exampleModal" data-whatever="">举报</button>
			</td>
			<%} %>
			</tr>
		
						
					</table>
				</div>
			</div>
			<div>
 共有${requestScope.pageModel.totalPage}页  当前是${requestScope.pageModel.currentPage }  页<br/>
  <a href="<%=request.getContextPath() %>/UserServlet?method=tostudy&userId=<%=user.getUserId() %>&currentPage=1">首页</a>
  <a href="<%=request.getContextPath()%>/UserServlet?method=tostudy&userId=<%=user.getUserId() %>&currentPage=${requestScope.pageModel.prePage}">上一页</a>
  <a href="<%=request.getContextPath()%>/UserServlet?method=tostudy&userId=<%=user.getUserId() %>&currentPage=${requestScope.pageModel.nextPage}">下一页</a>
  <a href="<%=request.getContextPath()%>/UserServlet?method=tostudy&userId=<%=user.getUserId() %>&currentPage=${requestScope.pageModel.totalPage}">尾页</a>     
 跳转<input type="text" name="currentPage" id="pageNo"/>页<input type="button" onclick="searchBook()" value="go"/>
</div>
<div>${requestScope.msg }</div>
</body>
<script>
  function searchBook(){
	  window.location.href="<%=request.getContextPath()%>/UserServlet?method=tostudy&userId=<%=user.getUserId() %>&currentPage="+$("#pageNo").val();
  }
</script>

			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="exampleModalLabel">举报</h4>
			      </div>
			      <div class="modal-body">
			        <form class="">
			        	<label>举报原因：</label>
			        	<div class="form-group">
			        		<textarea name="" rows="" cols="" style="width: 100%;"></textarea>
			        	</div>
			        </form>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
			        <button type="button" class="btn btn-primary">发送</button>
			      </div>
			    </div>
			  </div>
			</div>
			
			<!--举报弹出框-begin-->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="exampleModalLabel">举报</h4>
			      </div>
			      <div class="modal-body">
			        <form class="">
			        	<label>举报原因：</label>
			        	<div class="form-group">
			        		<textarea name="" rows="" cols="" style="width: 100%;"></textarea>
			        	</div>
			        </form>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
			        <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="fun1()">发送</button>
			      </div>
			    </div>
			  </div>
			</div>
			<!--举报弹出框-end-->
		</div>
	</body>
	<script type="text/javascript">
		$(".btn-info").click(function(){
			alert("添加成功");
		})
	</script>
	<script type="text/javascript">
		function fun1(){
			alert("举报成功");
		}
	</script>
</html>
