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
			background-color: #CCCCCC;
			
		}
		.glyphicon-plus:before {
			font-size: 200px;
		}
		.bookName{
			text-align: center;
		}
		.introduction{
			text-indent: 2em;
			word-break: break-all;
			text-overflow: ellipsis;
			overflow: hidden;
			display: -webkit-box;
			-webkit-box-orient: vertical;
			-webkit-line-clamp: 3;
		}
		.introBtn{
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
				      <a class="navbar-brand" href="<%=request.getContextPath() %>/UserServlet?method=toindex&username=<%=user.getUsername() %>"><span class="glyphicon glyphicon-bold" style="color: rgb(255,161,29); "></span></a>
				    </div>
		    
				     <div id="mynavbar" class="collapse navbar-collapse">
				    	<ul class="nav navbar-nav">
				    		<li class="active"><a href="<%=request.getContextPath() %>/UserServlet?method=toindex&username=<%=user.getUsername() %>">首页</a></li>
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
				    		<li><a href="<%=request.getContextPath() %>/UserServlet?method=showUser&userId=<%=user.getUserId() %>"><%=user.getUsername() %> <span class="glyphicon glyphicon-user"></span></a></li>
				    		<a href="<%=request.getContextPath() %>/UserServlet?method=showUser&userId=<%=user.getUserId() %>"><img class="img-circle" src="/images/<%=user.getImage() %>" width="50px" height="50px"/></a>
				    	</ul>
				  
				    </div>
		   	 	</div>
			</nav>     <!--导航栏结束-->
		<div class="row">
					<div class="col-md-6">
						<div class="panel " style="background-color: #FF99CC;">
							<div class="panel-heading">
								<h2>歌曲精选</h2>
							</div>
							<div id="music" class="panel-body" style="background-color: #FFCCCC;">
								<div class="list-group">
								  <a href="#" class="list-group-item list-group-item-success">
								  	年少有为
								  	<span class='glyphicon glyphicon-remove' style='float: right;display: none;'></span>
								  </a>
								  <a href="#" class="list-group-item list-group-item-info">
								  	光年之外
								  	<span class='glyphicon glyphicon-remove' style='float: right;display: none;'></span>
								  </a>	
								  <a href="#" class="list-group-item list-group-item-warning">
								  	归去来兮
								  	<span class='glyphicon glyphicon-remove' style='float: right;display: none;'>
								  </a>
								  <a href="#" class="list-group-item list-group-item-danger">
								  	侧脸
								  	<span class='glyphicon glyphicon-remove' style='float: right;display: none;'></span>
								  </a>
								</div>
								<div class="list-group">
								  <a href="#" class="list-group-item list-group-item-success">Way Back Home<span class='glyphicon glyphicon-remove' style='float: right;display: none;'></span></a>
								  <a href="#" class="list-group-item list-group-item-info">沙漠骆驼<span class='glyphicon glyphicon-remove' style='float: right;display: none;'></span></a>
								  <a href="#" class="list-group-item list-group-item-warning">可不可以<span class='glyphicon glyphicon-remove' style='float: right;display: none;'></span></a>
								  <a href="#" class="list-group-item list-group-item-danger">东西<span class='glyphicon glyphicon-remove' style='float: right;display: none;'></span></a>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="panel ">
							<div class="panel-heading" style="background-color: #6699CC;">
								<h2>电影放送</h2>
							</div>
							<div class="panel-body" style="background-color: #66CCCC;" id="movie">
								<div class="list-group">
								  <a href="#" class="list-group-item list-group-item-success">
								  	毒液：致命守护者 Venom
								  	<span class='glyphicon glyphicon-remove' style='float: right;display: none;'></span>
								  </a>
								  <a href="#" class="list-group-item list-group-item-info">
								  	名侦探柯南：零的执行人 名探偵コナン ゼロの執行人
								  	<span class='glyphicon glyphicon-remove' style='float: right;display: none;'></span>
								  </a>
								  <a href="#" class="list-group-item list-group-item-warning">
								  	你好，之华
								  	<span class='glyphicon glyphicon-remove' style='float: right;display: none;'></span>
								  </li>
								  <a href="#" class="list-group-item list-group-item-danger">
								  	无双
								  	<span class='glyphicon glyphicon-remove' style='float: right;display: none;'></span>
								  </a>
								</div>
								<div class="list-group">
								  <a href="#" class="list-group-item list-group-item-success">
								  	西虹市首富
								  	<span class='glyphicon glyphicon-remove' style='float: right;display: none;'></span>
								  </a>
								  <a href="#" class="list-group-item list-group-item-info">
								  	我不是药神
								  	<span class='glyphicon glyphicon-remove' style='float: right;display: none;'></span>
								  </a>
								  <a href="#" class="list-group-item list-group-item-warning">
								  	网络迷踪
								  	<span class='glyphicon glyphicon-remove' style='float: right;display: none;'></span>
								  </a>
								  <a href="#" class="list-group-item list-group-item-danger">
								  	一出好戏
								  	<span class='glyphicon glyphicon-remove' style='float: right;display: none;'></span>
								  </a>
								</div>
							</div>
						</div>
					</div>
				</div>
			<!--推荐的书--end-->
			<!--推荐的书--begin-->
				<div class="row">
				<div class="panel ">
					<div class="panel-heading" style="background-color: greenyellow;">
						<h2>好书推荐</h2>
					</div>
					<div class="panel-body" style="background-color: #CCFF99;">
						
						  <div class="col-md-4">
						    <div class="thumbnail">
						      <img src="img/三体.jpg" alt="..." style="height: 400px;">
						      <div class="caption">
						        <h3 class="bookName">《三体》</h3>
						        <p class="introduction">《三体》是刘慈欣创作的系列长篇科幻小说，由《三体》、《三体Ⅱ·黑暗森林》、《三体Ⅲ·死神永生》组成，第一部于2006年5月起在《科幻世界》杂志上连载，第二部于2008年5月首次出版，第三部则于2010年11月出版。</p>
						        <p class="introBtn"><a href="#" class="btn btn-primary" role="button">查看</a> </p>
						      </div>
						    </div>
						  </div>
						  
						  <div class="col-md-4">
						    <div class="thumbnail">
						      <img src="img/冰与火之歌.jpg" alt="..." style="height: 400px;">
						      <div class="caption">
						        <h3 class="bookName">《冰与火之歌》</h3>
						        <p class="introduction">《冰与火之歌》(A Song of Ice and Fire)是由美国作家乔治·R·R·马丁所著的严肃奇幻小说系列。该书系列首卷于1996年初由矮脚鸡图书公司在美国出版，全书计划共七卷，截至2014年共完成出版了五卷，被译为三十多种文字。</p>
						        <p class="introBtn"><a href="#" class="btn btn-primary" role="button">查看</a> </p>
						      </div>
						    </div>
						  </div>
						  
						  <div class="col-md-4">
						    <div class="thumbnail">
						      <img src="img/白鹿原.jpg" alt="..." style="height: 400px;">
						      <div class="caption">
						        <h3 class="bookName">《白鹿原》</h3>
						        <p class="introduction">《白鹿原》是作家陈忠实的代表作，这部长篇小说共50余万字，由陈忠实历时六年创作完成。该小说以陕西关中地区白鹿原上白鹿村为缩影，通过讲述白姓和鹿姓两大家族祖孙三代的恩怨纷争，表现了从清朝末年到二十世纪七八十年代长达半个多世纪的历史变化。</p>
						        <p class="introBtn"><a href="#" class="btn btn-primary" role="button">查看</a> </p>
						      </div>
						    </div>
						  </div>
					</div>
				</div>
			</div>
			<!--推荐的书--end-->
			
		</div>
		 <div class="bdsharebuttonbox" data-tag="share_1" style="float: right">
    <a class="bds_tsina" data-cmd="tsina"></a>
	<a class="bds_sqq" data-cmd="sqq"></a>
    <a class="bds_qzone" data-cmd="qzone"></a>	
	<a class="bds_weixin" data-cmd="weixin"></a>	
</div>
	</body>
	<script>
		$(function () {
		  $('[data-toggle="tooltip"]').tooltip()
		})

		$("#music div a,#movie div a").mouseover(function(){
			$(this).children("span").toggle() 
		})
		$("#music div a,#movie div a").mouseout(function(){
			$(this).children("span").toggle()
		})
		$(".glyphicon.glyphicon-remove").click(function(){
			$(this).parent().html("")
		})
		$("#music div a,#movie div a").dblclick(function(){
			$(this).html("")
			$(this).append("<input type='text' id='musicName' style='width: 350px;'/>")
			$(this).append("<span class='glyphicon glyphicon-ok' style='float: right;'>保存</span>")
			$(".glyphicon.glyphicon-ok").click(function(){
				var str=$("#musicName").val();
				$(this).parent().html(str)
			})
		})
		
		
		window._bd_share_config = {
		common : {
			bdText : 'Custom share content',	
			bdDesc : 'Custom share summary',	
			bdUrl : 'Custom share URL address', 	
			bdPic : 'Custom share pictures'
		},
		share : [{
			"bdSize" : 16
		}],
		slide : [{	   
			bdImg : 0,
			bdPos : "right",
			bdTop : 100
		}],
		image : [{
			viewType : 'list',
			viewPos : 'top',
			viewColor : 'black',
			viewSize : '16',
			viewList : ['qzone','tsina','huaban','tqq','renren']
		}],
		selectShare : [{
			"bdselectMiniList" : ['qzone','tqq','kaixin001','bdxc','tqf']
		}]
	}
	with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?cdnversion='+~(-new Date()/36e5)];
</script> 
</html>