<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,henu.rjxy.bean.*"%>
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
			background: url(img/背景图片03.png);
			
			
		}
		.inputfile {
            opacity: 0;
            margin-top: -20px; 
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
				    		<li class="dropdown">
				    			<a href="" class="dropdown-toggle" data-toggle='dropdown'>排行榜<span class="caret"></span></a>
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
				    		<li class="active"><a href="<%=request.getContextPath() %>/UserServlet?method=showUser&userId=<%=user.getUserId()%>"><%=user.getUsername() %><span class="glyphicon glyphicon-user"></span></a></li>
				    		<a href="<%=request.getContextPath() %>/UserServlet?method=showUser&userId=<%=user.getUserId()%>"><img class="img-circle" src="/images/<%=user.getImage() %>" width="50px" height="50px"/></a>
				    	</ul>
				  
				    </div>
		   	 	</div>
			</nav>     <!--导航栏结束-->
			<div class="panel panel-primary col-md-8 col-md-offset-2">
			
				<div class="panel-body">
				
				
					<div class="form-group">
							<label class="col-md-2 control-label">头像</label>
							<div class="col-md-10">
								<img class="img-circle" src="/images/<%=user.getImage() %>" width="80px" height="80px"/>
								<button class="btn btn-default" data-toggle="modal" data-target="#exampleModal" data-whatever=""/>更换头像</button>
							</div>
						</div>
						<!--更换头像弹出框-begin-->
							<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
							  <div class="modal-dialog" role="document">
								<div class="modal-content">
								  <div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
									<h4 class="modal-title" id="exampleModalLabel">更改头像</h4>
								  </div>
									<form class="" action="<%=request.getContextPath()%>/UpdateServlet" method="post" enctype="multipart/form-data">
									 <input type="hidden" name="userId" value="<%=user.getUserId() %>"/>
									  <div class="modal-body">
											<label>选择头像</label>
											<div class="form-group">
												<input type="file" name="uploadpic" onchange="viewImage(this)"/>
											</div>
									  </div>
									  <div class="modal-footer">
										<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
										<button type="submit" class="btn btn-primary">保存</button>
									  </div>
									</form>
								</div>
							  </div>
							</div>
						<!--更换头像弹出框-end-->
					<form class="form-horizontal" action="<%=request.getContextPath()%>/UserServlet" method="post" >
	   					<input type="hidden" name="method" value="updateUser"/>
	   					 <input type="hidden" name="userId" value="<%=user.getUserId() %>"/>
					  <div class="form-group" style="margin-top: 100px;">
					    <label class="col-md-2 control-label">用户名</label>
					    <div class="col-md-2">
					      <input class="form-control" type="text" name="username" id="" value="<%=user.getUsername() %>" />
					    </div>
					    <div class="col-md-5"><img src="img/nan_1.png"/ width="34px"></div>
					  </div>
					  <div class="form-group">
					    <label class="col-md-2 control-label">密码</label>
					    <div class="col-md-10">
					      <input class="form-control" type="password" name="psw" id="" value="<%=user.getPsw() %>" />
					    </div>
					  </div>
					  <div class="form-group">
					    <label class="col-md-2 control-label">年龄</label>
					    <div class="col-md-10">
					      <input class="form-control" type="text" name="age" id="" value="<%=user.getAge() %>" />
					    </div>
					  </div>
					  <div class="form-group">
					    <label class="col-md-2 control-label">职业</label>
					    <div class="col-md-10">
					      <input class="form-control" type="text" name="occupation" id="" value="<%=user.getOccupation() %>" />
					    </div>
					  </div>
					  <div class="form-group">
					    <label class="col-md-2 control-label">个性签名</label>
					    <div class="col-md-10">
					      <input class="form-control" type="text" name="target" id="" value="<%=user.getTarget() %>" />
					    </div>
					  </div>
					  <div class="form-group">
					    <label class="col-md-2 control-label">爱好</label>
					    <div class="col-md-10">
					      <input class="form-control" type="text" name="" id="" value="学习，打篮球，玩游戏" />
					    </div>
					  </div>
					  <div class="form-group">
					    <label class="col-md-2 control-label">邮箱</label>
					    <div class="col-md-10">
					      <input class="form-control" type="text" name="email" id="" value="1300193189@qq.com" />
					    </div>
					  </div>
					  <div class="form-group">
					    <label class="col-md-2 control-label">手机号</label>
					    <div class="col-md-10">
					       <input class="form-control" type="text" name="tel" id="" value="<%=user.getTel() %>" />
					    </div>
					  </div>
					  <div class="form-group">
					    <label class="col-md-2 control-label">地区</label>
					    <div class="col-md-10" id="di">
					       <input class="form-control" type="text" name="address" id="" value="<%=user.getAddress() %>" />
					    </div>
					  </div>
					  <div class=" form-group">
					  	<input type="submit" class="col-md-2 col-md-offset-6 btn btn-primary" id="modify" value="保存">
					  	<a href="<%=request.getContextPath() %>/UserServlet?method=showUser&userId=<%=user.getUserId()%>" class="col-md-1 col-md-offset-1 btn btn-primary" id="modify">取消</a>
					  	
					  </div>
					</form>
				</div>
				
			</div>
		</div>
		

	</body>
	<script type="text/javascript">

	$(function () {
		  $('[data-toggle="tooltip"]').tooltip()
		})
		function viewImage(file){
		var preview = document.getElementById('preview');
      if(file.files && file.files[0]){
          //火狐下
          preview.style.display = "block";
          preview.style.width = "150px";
          preview.style.height = "150px";
          preview.src = window.URL.createObjectURL(file.files[0]);
      }else{
          //ie下，使用滤镜
          file.select();
          var imgSrc = document.selection.createRange().text;
          var localImagId = document.getElementById("localImag"); 
          //必须设置初始大小 
          localImagId.style.width = "150px"; 
          localImagId.style.height = "150px"; 
          try{ 
          localImagId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
          locem("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc; 
          }catch(e){ 
          alert("您上传的图片格式不正确，请重新选择!"); 
          return false; 
          } 
          preview.style.display = 'none'; 
          document.selection.empty(); 
          } 
          return true; 
	}
	</script>
</html>
