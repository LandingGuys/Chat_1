<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,henu.rjxy.bean.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title></title>
		<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
		<script src="bootstrap-3.3.7-dist/js/jquery-3.3.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<style type="text/css">
		body{
			padding-top: 80px;
			background: url(img/背景图片05.jpg);
		
		}
		.panel.panel-warning.col-md-2{
			background-color: #CCCCCC;
		}
		
	</style>
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
				      <a class="navbar-brand" href="login.jsp"><span class="glyphicon glyphicon-bold" style="color: rgb(255,161,29); "></span></a>
				    </div>
		    
				   <div id="mynavbar" class="collapse navbar-collapse">
				    	<ul class="nav navbar-nav">
				    		<li class="active"><a href="<%=request.getContextPath() %>/UserServlet?method=toindex&username=${user.username}">首页</a></li>
				    		<li class="dropdown">
				    			<a href="" class="dropdown-toggle" data-toggle='dropdown'>排行榜<span class="caret"></span></a>
				    			<ul class="dropdown-menu">
				    				<li><a href="<%=request.getContextPath() %>/UserServlet?method=tosport&userId=${user.userId }&currentPage=1" id="sportRank">运动排行榜</a></li>
				    				<li><a href="<%=request.getContextPath() %>/UserServlet?method=tostudy&userId=${user.userId }&currentPage=1">学习排行榜</a></li>
				    				<li><a href="">更多排行榜</a></li>
				    				
				    			</ul>
				    		</li>
				    		<li><a href="<%=request.getContextPath() %>/UserServlet?method=toshare&userId=${user.userId }">我的分享</a></li>
				    		<li><a href="<%=request.getContextPath() %>/UserServlet?method=tofriend&userId=${user.userId }">好友</a></li>
				    		<li><a href=""></a></li>
				    	</ul>
				    	<ul class="nav navbar-nav navbar-right">
				    		<li><a href="<%=request.getContextPath() %>/UserServlet?method=showUser&userId=${user.userId }">${user.username } <span class="glyphicon glyphicon-user"></span></a></li>
				    		<a href="<%=request.getContextPath() %>/UserServlet?method=showUser&userId=${user.userId }"><img class="img-circle" src="/images/${user.image }" width="50px" height="50px"/></a>
				    	</ul>
				  
				    </div>
		   	 	</div>
			</nav>     <!--导航栏结束-->
			<div class="row">
				<div class="col-md-2 col-md-offset-1">
					<div class="panel panel-primary ">
						<div class=" panel-heading" >
							<h4>好友列表</h4>
						</div>
						
						<div class=" panel-body" >
							<div class="input-group" style="margin-bottom: 15px;">
							  <input type="text" class="form-control" placeholder="搜索好友" aria-describedby="basic-addon1">
							  	<span class="input-group-addon btn" id="basic-addon1"><img src="img/sousuo.png" width="18px"/></span>
							</div>
							<div class="list-group" id="guide">
								
								<c:forEach items="${requestScope.friends }" var="friends" varStatus="s">
		  							<a href="<%=request.getContextPath() %>/UserServlet?method=showfriend&userId=${user.userId }&friendname=${friends.username}" class="list-group-item  ">${friends.username }</a>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
					
				<div class=" col-md-8 ">
					<div class="panel panel-primary">
						<div class="panel-heading" >
							<ul id="myTab" class="nav nav-tabs">
								
  									<li class="active"><a href="#home" data-toggle="tab"><h4><strong>${friend.username }</strong></h4></a></li>
								<li><a href="#details" data-toggle="tab"><h4><strong>个人详情</strong></h4></a></li>
								<li><a href="#share" data-toggle="tab"><h4><strong>分享</strong></h4></a></li>
							</ul>
						</div>
						<div class="panel-body" style="background-color: #FFff99;">
							<div id="myTabContent" class="tab-content">
								<div class="tab-pane fade in active" id="home">
									<div class="panel panel-default">
										<div class="panel-heading">运动</div>
										<div class="panel-body">
											<ul class="list-group">
											   <c:choose>
  													<c:when test="${sport.sid==null }">
  														 <li class="list-group-item"><h3><small>他今日走了</small><span class="label label-default">0</span><small>步</small></h3></li>
											    		 <li class="list-group-item"><h3><small>消耗</small><span class="label label-default">0</span><small>千焦能量</small></h3></li>
  													</c:when>
  													<c:otherwise>
  														 <li class="list-group-item"><h3><small>他今日走了</small><span class="label label-default">${sport.step_number }</span><small>步</small></h3></li>
											    		 <li class="list-group-item"><h3><small>消耗</small><span class="label label-default">${sport.energy }</span><small>千焦能量</small></h3></li>
  														
  													</c:otherwise>
  											  </c:choose>
											 </ul>
										</div>
									</div>
									<div class="panel panel-danger">
										<div class="panel-heading">学习</div>
										<div class="panel-body">
											<ul class="list-group">
												<c:choose>
  													<c:when test="${study.stid==null }">
  														<li class="list-group-item"><h3><small>我今日学了</small><span class="label label-danger">0</span><small>个小时</small></h3></li>
											    <li class="list-group-item"><h3><small>背了</small><span class="label label-danger">0</span><small>个英文单词</small></h3></li>
  													</c:when>
  													<c:otherwise>
  														<li class="list-group-item"><h3><small>我今日学了</small><span class="label label-danger">${study.sty_time }</span><small>个小时</small></h3></li>
											  			<li class="list-group-item"><h3><small>背了</small><span class="label label-danger">${study.word }</span><small>个英文单词</small></h3></li>
  														
  													</c:otherwise>
  											   </c:choose>
											    
											 </ul>
										</div>
									</div>
								</div>
								<div class="tab-pane fade" id="details">
									<form class="form-horizontal">
									  <div class="form-group">
									    <label class="col-md-2 control-label">用户名</label>
									    <div class="col-md-2">
									      <p class="form-control-static">${friend.username}</p>
									    </div>
									    <div class="col-md-5"><img src="img/nan_1.png"/ width="34px"></div>
									      
									  </div>
									  <div class="form-group">
									    <label class="col-md-2 control-label">年龄</label>
									    <div class="col-md-10">
									      <p class="form-control-static">${friend.age }</p>
									    </div>
									  </div>
									  <div class="form-group">
									    <label class="col-md-2 control-label">职业</label>
									    <div class="col-md-10">
									      <p class="form-control-static">${user.occupation }</p>
									    </div>
									  </div>
									  <div class="form-group">
									    <label class="col-md-2 control-label">个性签名</label>
									    <div class="col-md-10">
									      <p class="form-control-static">${friend.target }</p>
									    </div>
									  </div>
									  <div class="form-group">
									    <label class="col-md-2 control-label">邮箱</label>
									    <div class="col-md-10">
									      <p class="form-control-static">${friend.email }</p>
									    </div>
									  </div>
									  <div class="form-group">
									    <label class="col-md-2 control-label">手机号</label>
									    <div class="col-md-10">
									      <p class="form-control-static">${friend.tel }</p>
									    </div>
									  </div>
									  <div class="form-group">
									    <label class="col-md-2 control-label">地区</label>
									    <div class="col-md-10" id="di">
									      <p class="form-control-static" id="qw">${friend.address }</p>
									    </div>
									  </div>
									</form>
								</div>
								<div class="tab-pane fade" id="share">
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4><strong>歌曲精选</strong></h4>
										</div>
										<div class="panel-body">
											<ul class="list-group">
											  <a href="#" class="list-group-item">年少有为</a>
											  <a href="#" class="list-group-item">光年之外</a>
											  <a href="#" class="list-group-item">归去来兮</a>
											  <a href="#" class="list-group-item">侧脸</li>
											  <a href="#" class="list-group-item">Way Back Home</a>
											  <a href="#" class="list-group-item">沙漠骆驼</a>
											  <a href="#" class="list-group-item">可不可以</a>
											  <a href="#" class="list-group-item">东西</a>
											</ul>
										</div>
									</div>
									
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4><strong>电影放送</strong></h4>
										</div>
										<div class="panel-body">
											<ul class="list-group">
											  <a href="#" class="list-group-item">毒液：致命守护者 Venom</a>
											  <a href="#" class="list-group-item">名侦探柯南：零的执行人 名探偵コナン ゼロの執行人</a>
											  <a href="#" class="list-group-item">你好，之华</a>
											  <a href="#" class="list-group-item">无双</li>
											  <a href="#" class="list-group-item">西虹市首富</a>
											  <a href="#" class="list-group-item">我不是药神</a>
											  <a href="#" class="list-group-item">网络迷踪</a>
											  <a href="#" class="list-group-item">一出好戏</a>
											</ul>
										</div>
									</div>
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4><strong>好书推荐</strong></h4>
										</div>
										<div class="panel-body">
											<div class="media">
											  <div class="media-left">
											    <a href="#">
											      <img class="media-object" src="img/三体.jpg" alt="..." width="50px">
											    </a>
											  </div>
											  <div class="media-body">
											    <h4 class="media-heading">《三体》</h4>
											    《三体》是刘慈欣创作的系列长篇科幻小说，由《三体》、《三体Ⅱ·黑暗森林》、《三体Ⅲ·死神永生》组成，第一部于2006年5月起在《科幻世界》杂志上连载，第二部于2008年5月首次出版，第三部则于2010年11月出版。
											  </div>
											</div>
											<div class="media">
											  <div class="media-left">
											    <a href="#">
											      <img class="media-object" src="img/冰与火之歌.jpg" alt="..." width="50px">
											    </a>
											  </div>
											  <div class="media-body">
											    <h4 class="media-heading">《冰与火之歌》</h4>
											    《冰与火之歌》(A Song of Ice and Fire)是由美国作家乔治·R·R·马丁所著的严肃奇幻小说系列。该书系列首卷于1996年初由矮脚鸡图书公司在美国出版，全书计划共七卷，截至2014年共完成出版了五卷，被译为三十多种文字。
											  </div>
											</div>
										
											<div class="media">
											  <div class="media-left">
											    <a href="#">
											      <img class="media-object" src="img/白鹿原.jpg" alt="..." width="50px">
											    </a>
											  </div>
											  <div class="media-body">
											    <h4 class="media-heading">《白鹿原》</h4>
											    《白鹿原》是作家陈忠实的代表作，这部长篇小说共50余万字，由陈忠实历时六年创作完成。该小说以陕西关中地区白鹿原上白鹿村为缩影，通过讲述白姓和鹿姓两大家族祖孙三代的恩怨纷争，表现了从清朝末年到二十世纪七八十年代长达半个多世纪的历史变化。
											  </div>
											</div>
										</div>
									</div>
								</div>
							</div>  
						</div>     <!--panel-body结束-->
					</div>
				</div>
			</div>   <!--row-->
		</div>    <!--container-->
	</body>
	<script type="text/javascript">
		$(function () {
		  $('[data-toggle="tooltip"]').tooltip()
		})
		$("#guide a").click(function(){
			$("#guide a").removeClass("active");
			$(this).addClass("active")
			
		})
	</script>
</html>
