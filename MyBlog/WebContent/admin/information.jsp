<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
	<title>MyBlog</title>

	<!-- Bootstrap -->
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<link type="text/css" rel="stylesheet" href="css/main.css" />
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
      <![endif]-->
      <style type="text/css">
      	#first{
      		font-size: 20px;
      		height: 500px;
      		width: 150px;
      		float: left;
      		padding: 50px 0 0 40px;
      	}
      	#second{
      		margin-left: 150px;
      		height: 800px;
      		width: 500px;
      		padding: 50px 0 0 40px;
      		font-size: 30px;
      	}
      	.fileinput-button {
            position: relative;
            display: inline-block;
            overflow: hidden;
        }

        .fileinput-button input{
            position: absolute;
            left: 0px;
            top: 0px;
            opacity: 0;
            -ms-filter: 'alpha(opacity=0)';
        }
      </style>
  </head>
  <body>

  	<!-- 右下角按钮 -->
  	<!-- <button class="btn btn-default btn_right_bottom">写</button> -->
  	<!-- 图片轮播 -->
  	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  		<!-- Indicators -->
  		<ol class="carousel-indicators">
  			<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
  			<li data-target="#carousel-example-generic" data-slide-to="1"></li>
  			<li data-target="#carousel-example-generic" data-slide-to="2"></li>
  			<li data-target="#carousel-example-generic" data-slide-to="3"></li>
  			<li data-target="#carousel-example-generic" data-slide-to="4"></li>
  			<li data-target="#carousel-example-generic" data-slide-to="5"></li>
  		</ol>

  		<!-- Wrapper for slides -->
  		<div class="carousel-inner" role="listbox">
  			<div class="item active">
  				<img src="img/ic_p4.jpg">
  				<p class="carousel-caption">
  					
  				</p>
  			</div>
  			<div class="item">
  				<img src="img/ic_p5.jpg">
  				<p class="carousel-caption">
  					
  				</p>
  			</div>
  			<div class="item">
  				<img src="img/ic_p6.jpg">
  				<p class="carousel-caption">
  					
  				</p>
  			</div>
  			<div class="item">
  				<img src="img/ic_p7.jpg">
  				<p class="carousel-caption">
  					
  				</p>
  			</div>
  			<div class="item">
  				<img src="img/ic_p8.jpg">
  				<p class="carousel-caption">
  					
  				</p>
  			</div>
  			<div class="item">
  				<img src="img/ic_p9.jpg">
  				<p class="carousel-caption">
  					
  				</p>
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
  	<!-- 功能模块 -->
  <div class="row div_function">
  		<div class="col-xs-4">
  			<div class="panel panel-default" id="pFunc1">
  				<a href="<%=request.getContextPath() %>/ArticleServlet?method=total&user_id=${user.user_id}&currentPage=1">
  					<div class="panel-body">
  						<strong>MyBlog</strong>
  						<img class="iv_function" src="img/ic_store.svg">
  					</div>
  				</a>
  			</div>
  		</div>
  		<div class="col-xs-4">
  			<div class="panel panel-default"  id="pFunc2">
  				<a href="<%=request.getContextPath() %>/ArticleServlet?method=tomy&user_id=${user.user_id}">
  					<div class="panel-body">
  						<strong>私人角落</strong>
  						<img class="iv_function" src="img/ic_remeber.svg">
  					</div>
  				</a>
  			</div>
  		</div>
  		<div class="col-xs-4">
  			<div class="panel panel-default"  id="pFunc3" style="background-color: khaki;">
  				<a href="<%=request.getContextPath() %>/UserServlet?method=toinformation&user_id=${user.user_id}">
	  				<div class="panel-body">
	  					<strong>个人中心</strong>
	  					<img class="iv_function" src="img/ic_personal.svg">
	  				</div>
  				</a>
  			</div>
  		</div>
  	</div>
  	<!-- 技术日记 -->
  	<div class="container div_divider">
  		<!-- 分割线 -->
  		<hr class="hr_1">Bigname Technology World !<hr class="hr_2">
  		<div class="row" style="width: 1600px;">
  			<!-- 文章列表 -->
  			<div class="col-xs-9" style="height: 600px;">
  				<div class="list-group div_article">
  					<!-- 子头栏 -->
  					<a href="#" class="list-group-item active item_article_first">
  						<h4 class="list-group-item-heading">
  							My Life, Like Sun!
  						</h4>
  					</a>
  					<!-- 文章列表 -->
  					
  				</div>
  				<div id="first">
  					<img src="/images/${user.user_image }" style="border-radius: 40px;height: 80px;width: 80px;"/>
  				
  					<button type="button"  class="btn btn-primary" data-toggle="modal" data-target="#updateImageModal" data-whatever="" >修改头像</button>
  					
  					
  				</div>
  				<div id="second">
  					<p>昵称：${user.user_name }</p>
  					<p>实名 :  ${user.user_username }</p>
  					<p>e-mail:${user.user_email }</p>
  					<p>地区: ${user.user_region }</p>
  					<p>行业: ${user.user_industry }</p>
  					<p>职位：${user.user_position }</p>
  					<p>简介：${user.user_introduction }</p>
  					<button class="btn btn-primary" data-toggle="modal" data-target="#updateImageModal3" data-whatever="" >修改资料</button>
  				</div>
  			</div>
  			<!-- 右侧 -->
  			
  		</div>
  		<!-- 修改头像模态框 -->
  			
  			
  			<div class="modal fade bs-example-modal-sm" id="updateImageModal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
  			<div class="modal-dialog modal-sm" role="document">
  				<div class="modal-content">
  					<div class="modal-header">
  						<div class="modal-title" id="myModalLabel" style="text-align: center;">修改头像</div>
  					</div>
  					<div class="modal-body">
  						<form class="form-horizontal" style="padding: 12px;" action="<%=request.getContextPath()%>/UpdateServlet" method="post" enctype="multipart/form-data">
  							<input type="hidden" name="user_id" value="${user.user_id }"/>
  							<div class="form-group">
  									<input type="file" name="storyimg"  onchange="viewImg(this)"/>
  							</div>
  							<div class="form-footer">
  								<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
			        			<button type="submit" class="btn btn-primary">保存</button>

  							</div>
  						</form>
  					</div>
  				</div>
  			</div>
  			</div>
  			
  			<div class="modal fade bs-example-modal-sm" id="updateImageModal3" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
  			<div class="modal-dialog modal-sm" role="document">
  				<div class="modal-content">
  					<div class="modal-header">
  						<div class="modal-title" id="myModalLabel" style="text-align: center;">修改资料</div>
  					</div>
  					<div class="modal-body">
  						<form class="form-horizontal" style="padding: 12px;" action="<%=request.getContextPath()%>/UserServlet" method="post">
  							<input type="hidden" name="method" value="updateUser"/>
  							<input type="hidden" name="user_id" value="${user.user_id }"/>
  							<div class="form-group">
			  					<p>昵称：<input type="text"  name="user_name" value="${user.user_name }"/></p>
			  					<p>密码：<input type="password"  name="user_password" value="${user.user_password }"/></p>
			  					<p>实名：<input type="text" name="user_username" value="${user.user_username }"/></p>
			  					<p>e-mail:<input type="text" name="user_email" value="${user.user_email }"/></p>
			  					<p>地区：<input type="text" name="user_region" value="${user.user_region }"/></p>
			  					<p>行业：<input type="text" name="user_industry" value="${user.user_industry }"/></p>
			  					<p>职位：<input type="text" name="user_position" value="${user.user_position }"/></p>
			  					<p>简介：<input type="text" name="user_introduction" value="${user.user_introduction }"/></p>
  							</div>
  							<div class="form-footer">
  								<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
			        			<button type="submit" class="btn btn-primary">保存</button>

  							</div>
  						</form>
  					</div>
  				</div>
  			</div>
  			</div>
  		<div class="foot_line"></div>
			</div><!-- container -->
		<div id="footer">
		<div>
			<a href="<%=request.getContextPath()%>/UserServlet?method=toindex&user_id=${user.user_id}" style="font-size: 20px;"><img src="img/logo.png"width="45px" height="45px" class="img-circle">&nbsp;&nbsp;MyBlog&nbsp;|</a>
			
			<a href="https://www.csdn.net/" style="font-size: 20px;">&nbsp;&nbsp;CSDN</a>
			<br/>
			copyright © 2018
		</div>		
		</div><!-- footer -->
 


  	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  	<script src="js/jquery-3.3.1.min.js"></script>
  	<!-- Include all compiled plugins (below), or include individual files as needed -->
  	<script src="js/bootstrap.min.js"></script>
  	<script src="js/init.js" type="text/script"></script>
  	<script src="js/util.js"></script>
  	<script type="text/javascript">
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
  </body>
  </html>