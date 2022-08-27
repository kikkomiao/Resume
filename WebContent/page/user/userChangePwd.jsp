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

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>修改密码</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/changePwd.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/font-awesome-4.7.0/css/font-awesome.min.css" />
		<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js" type="text/javascript"></script>
		<script src="<%=basePath%>static/js/jquery-validation-1.14.0/jquery.validate.js" type="text/javascript"></script>
		<script src="<%=basePath%>static/js/jquery-validation-1.14.0/localization/messages_zh.js" type="text/javascript"></script>

		<script type="text/javascript">
		//对输入信息进行校验
			$(function(){
				$("#editForm").validate({
					rules:{
						oldUserPwd:{
							required:true,
						},
						userPwd:{
							required:true,
							rangelength:[6,18],
						},
						confirmUserPwd:{
							required:true,
							rangelength:[6,18],
						},
					},
					messages:{
						oldUserPwd:{
							required:"原密码不能为空!!!",
						},
						userPwd:{
							required:"新密码不能为空!!!",
							rangelength: $.validator.format("长度为 {0} 到 {1}!!!"),

						},
						confirmUserPwd:{
							required:"确认密码不能为空!!!",
							rangelength: $.validator.format("长度为 {0} 到 {1}!!!"),
						},
					}

				});
			});

		</script>

	</head>
	<body>
		<c:if test="${message == 2}">
			<script>
				alert("密码修改失败:两次输入密码不一致！");
			</script>
		</c:if>
		<c:if test="${message == 3}">
			<script>
				alert("密码修改失败:原密码不正确！");
			</script>
		</c:if>
		<div class="add">
			<form id="editForm" action="<%=basePath%>change?" method="post">
				<input type="hidden" name="userphone" value="${user.userphone}"/>
				<input type="hidden" name="username" value="${user.username}"/>
				<table class="tableadd">
					<tr>
						<td>旧密码：</td>
						<td style="color:red;">
							<input type="password" name="oldUserPwd" />
						</td>
					</tr>
					<tr>
						<td>新密码：</td>
						<td style="color:red;">
							<input type="password" name="userPwd" />
						</td>
					</tr>
					<tr>
						<td>确认密码：</td>
						<td style="color:red;">
							<input type="password" name="confirmUserPwd"/>
						</td>
					</tr>
					<tr>
						<td colspan="4" align="left">
							<!--  location.href='<%=basePath%>student?method=list'-->
							<button class="return" type="button" onclick="location.href='../../indexView.html'">
								<!-- <i class="fa fa-edit"></i> -->
								<svg t="1640306541406" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="9460" width="15" height="15">
									<path d="M512.034377 0a512 512 0 0 1 296.813714 929.206857l-87.113142-117.540571a365.714286 365.714286 0 1 0-426.569143-5.12l84.041143-109.348572L512.034377 1024H128.034377l77.970286-101.595429-10.971429-8.338285A512 512 0 0 1 512.034377 0z" p-id="9461" fill="#fff">
									</path>
								</svg>
								返回
							</button>
							<button class="submit" type="submit">
								<!-- <i class="fa fa-remove"></i> -->
								<svg t="1640306784805" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="11020" width="15" height="15">
									<path d="M463.7 746.5l-160-81.5c-49.5-24-75.3-3.9-57.8 54.4 0 0 95.3 230.5 94.8 240.5l143.1-97.2c18.1-17.1 27.6-41.5 22.7-67.1-3.8-19-22.9-38.4-42.8-49.1zM878.6 74.1L93.3 470.8c-33.1 18.5-36.1 44.6-10.5 61.7 4.9 3.3 10.4 5.7 16 7.4l156.3 62.5c45.7 16.4 84.5 4.2 123.8-25.2l351.7-282.5c11.3-9.1 18.1 0.5 8.3 8.6L427.5 605.7c-13 12.7-18.6 31.2-14.6 49 3.8 17.6 17.9 29 33.6 37.3l14 6.3 283.3 134.9 2.9 1.3c36.4 15.8 78.2-4.8 88.5-43.6l1.1-4.3 118.6-655.5c16.2-52.8-29.9-84.5-76.3-57z" p-id="11021" fill="#fff">
									</path>
								</svg>
								提交
							</button>
						</td>

					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
