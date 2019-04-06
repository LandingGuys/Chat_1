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
		<script src="bootstrap-3.3.7-dist/js/holder.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<style type="text/css">
	body{
			padding-top: 80px;
			/*background-color: #CCFFFF;*/
		
		}
		.glyphicon-plus:before {
			font-size: 200px;
		}
		.myBody{
			/*background-color: #FFFFFF;*/
			background-color: initial;
			/* border: 0px;*/
		}
		.myBorder{
			border: 0px;
		}
		.myPadding{
			padding: 0px;
			padding-bottom: 15px;
		}
		.myBack{
			background-color: #FFFFFF;
		}
		.txt1{
			width: 150px;
			white-space: nowrap;
			overflow: hidden;
			text-overflow: ellipsis;
		}
		.txt2{
			word-break: break-all;
			text-overflow: ellipsis;
			overflow: hidden;
			display: -webkit-box;
			-webkit-box-orient: vertical;
			-webkit-line-clamp: 2;
		}
		a{
			color: black;
		}
		a:hover{
			color: black;
			text-decoration: none;
		}
		
	</style>
	<%
		User user=(User)request.getAttribute("user");
		
		ArrayList<henu.rjxy.dto.searchSport> sport_list=(ArrayList<henu.rjxy.dto.searchSport>)request.getAttribute("sport_list");
		
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
			<div class="col-md-2">
					<div class="panel panel-default ">
						<div class="panel-heading" >
							<h3>今日榜单</h3>
						</div>
						<div class="panel-body">
							<div class="list-group">
								<div class="list-group-item myBorder myPadding" >
									<a href=""  class="a">
										<img class="img-circle" src="img/first.png"/ width="30px">
										<img class="img-circle" src="/images/<%=sport_list.get(0).getImage() %>" width="50px" height="50px"/>
										<span><%=sport_list.get(0).getUsername() %></span>
									</a>
								</div>
								<div class="list-group-item myBorder myPadding">
									<a href="">
										<img class="img-circle" src="img/second.png"/ width="30px">
										<img class="img-circle" src="/images/<%=sport_list.get(1).getImage() %>" width="50px" height="50px" />
										<span><%=sport_list.get(1).getUsername() %></span>
									</a>	
								</div>
								<div class="list-group-item myBorder myPadding">
									<a href="">
										<img class="img-circle" src="img/third.png"/ width="30px">
										<img class="img-circle" src="/images/<%=sport_list.get(2).getImage() %>" width="50px" height="50px" />
										<span><%=sport_list.get(2).getUsername() %></span>
									</a>	
								</div>
								<div class="list-group-item  myBorder" style="padding-bottom: 0px;">
									<a href="<%=request.getContextPath() %>/UserServlet?method=tosport&userId=${user.userId }&currentPage=1">
										<h5><i>查看更多...</i></h5>
									</a>	
								</div>
							</div>
						</div>
					</div>
					<div class="panel panel-default ">
						<div class="panel-heading " >
							<h3>好友排行</h3>
						</div>
						<div class="panel-body">
							<div class="list-group">
								<div class="list-group-item myBorder myPadding">
									<a href="">
										<img class="img-circle" src="img/右.jpg"/ width="30px">
										<span>宇智波</span>
									</a>	
								</div>
								<div class="list-group-item myBorder myPadding" >
									<a href=""  class="a">
										<img class="img-circle" src="img/卡莎.jpg"/ width="30px">
										<span>卡莎</span>
									</a>
								</div>
								<div class="list-group-item myBorder myPadding">
									<a href="">
										<img class="img-circle" src="img/胡的头像.jpg"/ width="30px">
										<span>龙猫</span>
									</a>	
								</div>
								
							</div>
						</div>
					</div>
			</div>
			<div class="col-md-8 ">
				<div class="panel panel-primary">
					<div class="panel-heading" >
						<h3>目标</h3>
					</div>
					<div class="panel-body">
						<p><i>${user.target }</i></p>
						<button class="btn" data-toggle="modal" data-target="#exampleModal" data-whatever="">修改</button>
					</div>
				</div>
				<div class="row" >
					<div class="col-md-6">
				<div class="panel panel-primary" >
					<div class="panel-heading " style="background-color: #FF9900;">
						<h2>运动</h2>
					</div>
					<div class="panel-body " >
						<!--轮播开始-->
						<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
						  <!-- Indicators -->
						  <ol class="carousel-indicators">
						    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
						    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
						    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
						  </ol>
						  <!-- Wrapper for slides -->
						  <div class="carousel-inner" role="listbox">
						    <div class="item active">
						      <img src="img/跑步.JPG" alt="..." style="height: 200px;">
						    </div>
						    <div class="item">
						      <img src="img/打篮球.jpg" alt="..." style="height: 200px;">
						    </div>
						    <div class="item">
						      <img src="img/冲浪.jpg" alt="..." style="height: 200px;">
						    </div>
						  </div>
						  <!-- Controls -->
						  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
						    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						    <span class="sr-only">Previous</span>
						  </a>
						  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
						    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						    <span class="sr-only">Next</span>
						  </a>
						</div>
						<!--轮播结束-->
						<c:choose>
  								<c:when test="${sport.sid==null }">
  									<h1><small>我今日走了</small><span class="label label-default">0</span><small>步</small></h1>
									<h2><small>消耗</small><span class="label label-default">0</span><small>千焦能量</small></h2>
  								</c:when>
  								<c:otherwise>
  									<h1><small>我今日走了</small><span class="label label-default">${sport.step_number }</span><small>步</small></h1>
									<h2><small>消耗</small><span class="label label-default">${sport.energy }</span><small>千焦能量</small></h2>
  								</c:otherwise>
  							</c:choose>
						
						
						<div class="panel-group " id="accordion" role="tablist" aria-multiselectable="true">
						  <div class="panel panel-default myBorder">
						    <div class="panel-heading" role="tab" id="headingOne" >
						      <h4 class="panel-title ">
						        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
						          <h3>运动总榜</h3>
						        </a>
						      </h4>
						    </div>
						    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
						      <div class="panel-body">
						      	<h4>排行榜位于第<span>234232</span>名</h4>
						      	<h4>超越<span>823923</span>名用户</h4>
						      	<h4>相比昨日提升<span>873</span>名</h4>
						      </div>
						    </div>
						  </div>
						  <div class="panel panel-default myBorder">
						    <div class="panel-heading" role="tab" id="headingTwo">
						      <h4 class="panel-title">
						        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
						          <h3>大学生榜</h3>
						        </a>
						      </h4>
						    </div>
						    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
						      <div class="panel-body">
						      	<h4>排行榜位于第<span>23426</span>名</h4>
						      	<h4>超越<span>82392</span>名用户</h4>
						      	<h4>相比昨日提升<span>121</span>名</h4>
						      </div>
						    </div>
						  </div>
						  <div class="panel panel-default myBorder">
						    <div class="panel-heading" role="tab" id="headingThree">
						      <h4 class="panel-title">
						        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
						          <h3>郑州市榜</h3>
						        </a>
						      </h4>
						    </div>
						    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
						      <div class="panel-body">
						      	<h4>排行榜位于第<span>23426</span>名</h4>
						      	<h4>超越<span>82392</span>名用户</h4>
						      	<h4>相比昨日提升<span>121</span>名</h4>
						      </div>
						    </div>
						  </div>
						</div>
						
					</div>
				</div>
				</div>
				<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-heading" style="background-color: #00CC00;">
						<h2>学习</h2>
					</div>
					<div class="panel-body" >
						      	<!--轮播开始-->
						<div id="carousel-example-generic2" class="carousel slide" data-ride="carousel">
						  <!-- Indicators -->
						  <ol class="carousel-indicators">
						    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
						    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
						    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
						  </ol>
						  <!-- Wrapper for slides -->
						  <div class="carousel-inner" role="listbox">
						    <div class="item active">
						      <img src="img/学习.jpg" alt="..." style="height: 200px;">
						    </div>
						    <div class="item">
						      <img src="img/看书.jpg" alt="..." style="height: 200px;">
						    </div>
						    <div class="item">
						      <img src="img/讨论.jpg" alt="..." style="height: 200px;">
						    </div>
						  </div>
						  <!-- Controls -->
						  <a class="left carousel-control" href="#carousel-example-generic2" role="button" data-slide="prev">
						    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						    <span class="sr-only">Previous</span>
						  </a>
						  <a class="right carousel-control" href="#carousel-example-generic2" role="button" data-slide="next">
						    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						    <span class="sr-only">Next</span>
						  </a>
						</div>
						<!--轮播结束-->
							<c:choose>
  								<c:when test="${study.stid==null }">
  									<h1><small>我今日学了</small><span class="label label-default">0</span><small>个小时</small></h1>
									<h3><small>背了</small><span class="label label-default">0</span><small>个英文单词</small></h3>
  								</c:when>
  								<c:otherwise>
  									<h1><small>我今日学了</small><span class="label label-default">${study.sty_time }</span><small>个小时</small></h1>
									<h3><small>背了</small><span class="label label-default">${study.word }</span><small>个英文单词</small></h3>
  								</c:otherwise>
  							</c:choose>
						
						
						<div class="panel-group " id="accordion2" role="tablist" aria-multiselectable="true">
						  <div class="panel panel-default myBorder">
						    <div class="panel-heading" role="tab" id="headingOne2" >
						      <h4 class="panel-title myBody">
						        <a role="button" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne2" aria-expanded="true" aria-controls="collapseOne2">
						          <h3>学习总榜</h3>
						        </a>
						      </h4>
						    </div>
						    <div id="collapseOne2" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne2">
						      <div class="panel-body">
						      	<h4>排行榜位于第<span>234232</span>名</h4>
						      	<h4>超越<span>823923</span>名用户</h4>
						      	<h4>相比昨日提升<span>873</span>名</h4>
						      </div>
						    </div>
						  </div>
						  <div class="panel panel-default myBorder">
						    <div class="panel-heading" role="tab" id="headingTwo2">
						      <h4 class="panel-title">
						        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion2" href="#collapseTwo2" aria-expanded="false" aria-controls="collapseTwo2">
						          <h3>大学生榜</h3>
						        </a>
						      </h4>
						    </div>
						    <div id="collapseTwo2" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo2">
						      <div class="panel-body">
						
						      	<h4>排行榜位于第<span>23426</span>名</h4>
						      	<h4>超越<span>82392</span>名用户</h4>
						      	<h4>相比昨日提升<span>121</span>名</h4>
						      </div>
						    </div>
						  </div>
						  <div class="panel panel-default myBorder">
						    <div class="panel-heading" role="tab" id="headingThree2">
						      <h4 class="panel-title">
						        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion2" href="#collapseThree2" aria-expanded="false" aria-controls="collapseThree2">
						          <h3>郑州市榜</h3>
						        </a>
						      </h4>
						    </div>
						    <div id="collapseThree2" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree2">
						      <div class="panel-body">
						      	<h4>排行榜位于第<span>23426</span>名</h4>
						      	<h4>超越<span>82392</span>名用户</h4>
						      	<h4>相比昨日提升<span>121</span>名</h4>
						      </div>
						    </div>
						  </div>
						</div>
						
						
					</div>
				</div>
				</div>
				</div>
				<div class="panel panel-default myBack">
					<div class="panel-heading">
						<h2>更多</h2>
					</div>
					<div class="panel-body" style="text-align: center;">
						<a href=""><div class="glyphicon glyphicon-plus"></div></a>
					</div>
					
				</div>
			
			</div>
		
			<div class="col-md-2">
					<div class="panel panel-default">
						<div class="panel-heading myBody" >
							<h3>今日推荐</h3>
						</div>
						<div class="panel-body">
							<div class="media">
							  <div class="media-left media-middle">
							    <a href="#">
							      <img class="media-object" src="img/毛泽东选集.jpg" alt="..." style="width: 30px;">
							    </a>
							  </div>
							  <div class="media-body">
							  	<a href="">
								    <h4 class="media-heading txt1">《毛泽东选集》</h4>
								    <p class="txt2" style="font-size: 8px;">《毛泽东选集》是1944年人民出版社出版的图书，作者是毛泽东。
								    	《毛泽东选集》是毛泽东思想的重要载体，《毛泽东选集》是毛泽东思想的集中展现，是对20世纪中国影响最大的书籍之一。
								    	建国后两个版本的《毛泽东选集》，均由人民出版社出版。</p>
								 </a>   	
							  </div>
							</div>
							<div class="media">
							  <div class="media-left media-middle">
							    <a href="#">
							      <img class="media-object" src="img/软件工程案例教程.jpg" alt="..." style="width: 30px;">
							    </a>
							  </div>
							  <div class="media-body">
							    <h5 class="media-heading txt1">《软件工程案例教程》</h5>
							    <p class="txt2" style="font-size: 8px;">软件工程专业是2002年国家教育部新增专业，随着计算机应用领域的不断扩大及中国经济建设的不断发展，
							    	软件工程专业将成为一个新的热门专业。</p>
							  </div>
							</div>
							<div class="media">
							  <div class="media-left media-middle">
							    <a href="#">
							      <img class="media-object" src="img/高等数学.jpg" alt="..." style="width: 30px;">
							    </a>
							  </div>
							  <div class="media-body">
							    <h5 class="media-heading txt1">《高等数学》</h5>
							    <p class="txt2" style="font-size: 8px;">指相对于初等数学而言，数学的对象及方法较为繁杂的一部分。
							    	广义地说，初等数学之外的数学都是高等数学，也有将中学较深入的代数、
							    	几何以及简单的集合论初步、逻辑初步称为中等数学的，将其作为中小学阶段的初等数学与大学阶段的高等数学的过渡。
							    </p>
							  </div>
							</div>
						</div>
					</div>
					<div class="">
						<div class="panel " style="background-color: #FF99CC;">
							<div class="panel-heading">
								<h2>歌曲精选</h2>
							</div>
							<div class="panel-body" style="background-color: #FFCCCC;">
								<div class="list-group">
								  <a href="#" class="list-group-item list-group-item-success">年少有为<span class="glyphicon glyphicon-play" style="float: right;"></span></a>
								  <a href="#" class="list-group-item list-group-item-info">光年之外<span class="glyphicon glyphicon-play" style="float: right;"></span></li>
								  <a href="#" class="list-group-item list-group-item-warning">归去来兮<span class="glyphicon glyphicon-play" style="float: right;"></span></a>
								  <a href="#" class="list-group-item list-group-item-danger">侧脸<span class="glyphicon glyphicon-play" style="float: right;"></span></a>
								</div>
								<div class="list-group">
								  <a href="#" class="list-group-item list-group-item-success">Way Back Home<span class="glyphicon glyphicon-play" style="float: right;"></span></a>
								  <a href="#" class="list-group-item list-group-item-info">沙漠骆驼<span class="glyphicon glyphicon-play" style="float: right;"></span></a>
								  <a href="#" class="list-group-item list-group-item-warning">可不可以<span class="glyphicon glyphicon-play" style="float: right;"></span></a>
								  <a href="#" class="list-group-item list-group-item-danger">东西<span class="glyphicon glyphicon-play" style="float: right;"></span></a>
								</div>
							</div>
						</div>
			</div>
<!--修改个性签名框-begin-->		
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="exampleModalLabel">更改个性签名</h4>
			      </div>
			        <form class="" action="<%=request.getContextPath()%>/UserServlet" method="post">
			        <input type="hidden" name="method" value="updateTarget"/>
	   				<input type="hidden" name="userId" value="<%=user.getUserId() %>"/>
	   				<input type="hidden" name="username" value="<%=user.getUsername() %>"/>
			      <div class="modal-body">			       
			        	<div class="form-group">
			        		<textarea name="target" rows="" cols="" style="width: 100%;"></textarea>
			        	</div>		
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
			        <button type="submit" class="btn btn-primary">确认</button>
			      </div> 
			      </form>
			    </div>
<!--修改个性签名框-end-->			    
		</div>
	</body>
	
	<script type="text/javascript">
		$(function () {
		  $('[data-toggle="tooltip"]').tooltip()
		})
		
	</script>
</html>
