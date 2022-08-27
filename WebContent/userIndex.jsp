<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();

    String basePath = request.getScheme()
    + "://" + request.getServerName()
    + ":"
    + request.getServerPort()
    + path
    + "/";

    //pageContext.setAttribute("basePath", basePath);
%>

<%--<%!int flag = -1;%>--%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>系统首页</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/index.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/font-awesome-4.7.0/css/font-awesome.min.css" />
		<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js" type="text/javascript"></script>


		<script type="text/javascript">

			$(function(){

				var test = 0;
				$('.menux .p1').click(function(){
					// $(this).siblings('ul').slideUp(200);
					$(this).siblings('.ul1').slideToggle(200);
				});
				$('.user .ul2 a').click(function(){
					// console.log($(this).Attr("url"));
					$('iframe').attr("src",$(this).attr("url"));
					$('.menu_title').html($(this).attr("title"));
					test=0;
				});



				$('.menux .ul1 a').click(function(){
					// console.log($(this).Attr("url"));
					$('iframe').attr("src",$(this).attr("url"));
					$('.menu_title').html($(this).attr("title"));
				});
				$('.menux .p1 a').click(function(){
					// console.log($(this).Attr("url"));
					$('iframe').attr("src",$(this).attr("url"));
					$('.menu_title').html($(this).attr("title"));
					test=0;
				});
				$('.logout').click(function(){
					if(confirm("确认退出吗？"))
					{
						window.location.href = "<%=basePath%>logout?";
					}
				})

			})

		</script>
	</head>
	<body>
		<div class="header">
			<div class="logo">
			</div>
			<div class="user">
					<i class="fa fa-caret-down point"></i>
					<i class="fa fa-user"></i>
						&nbsp;${user.username}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<ul class="ul2">
						<li><a href="javascript:void(0);" url="<%=basePath%>page/user/userChangePwd.jsp" title="">修改密码</a></li>
						<li><a href="javascript:void(0);" url="<%=basePath%>page/user/userChangeName.jsp">修改用户名</a></li>
						<li><a href="javascript:void(0);" class="logout">退出登录</a></li>
					</ul>
				</div>
			</div>
			<div class="left">
				<div class="title">
					<i class="fa fa-home"></i>
					系统功能
				</div>
				<div class="menux">
					<p class="p1">
						<a href="javascript:void(0);" url="indexView.html" title="首页" keyword="0">
							<i class="fa fa-info-circle"></i>
							个人简介
							<i class="fa fa-angle-right point" ></i>
						</a>

					</p>
					<ul class="ul1">
						<li>
							<a class="a1" href="javascript:void(0);" url="<%=basePath%>page/user/insertResume.jsp" title="填报简历" keyword="1">
								<i class="fa fa-caret-right"></i>

								填报简历
							</a>
						</li>
						<li>
							<a class="a2" href="javascript:void(0);" url="<%=basePath%>pageQuery?userphone=${user.userphone}" title="我的简历" keyword="0">
								<i class="fa fa-caret-right"></i>
								我的简历
							</a>
						</li>
<!--						<li>-->
<!--							<a href="javascript:void(0);" url="userResumeChange.jsp" title="修改简历">-->
<!--								<i class="fa fa-caret-right"></i>-->
<!--								修改简历-->
<!--							</a>-->
<!--						</li>-->
					</ul>
				</div>
			</div>
			<div class="main">
				<div class="location">
					<i class="fa fa-home"></i>
					<span class="menu_title">
						首页
					</span>

				</div>
				<iframe  src="indexView.html" width="100%" height="90%" frameborder="0px" style="background-color: #F2F2FA;"></iframe>
			</div>
	</body>
</html>
