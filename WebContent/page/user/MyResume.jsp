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
		<title>我的简历</title>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/list.css" />
		<link rel="stylesheet" type="text/css" href="<%=basePath%>static/css/font-awesome-4.7.0/css/font-awesome.min.css" />
		<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js" type="text/javascript"></script>
		<script type="text/javascript">
			$(function(){
				$('.remove').click(function(){
					if(confirm("确定要删除该简介吗？")){
						window.location.href="<%=basePath%>deleteResume?id="+$(this).attr("keyword");
					}
				})
			})

		</script>

	</head>
	<body>

		<c:if test="${update == -1}">
			<script>
				alert("网络开小差了，请重新修改");
			</script>
		</c:if>
		<c:if test="${message == 1}">
			<script>
				alert("删除成功！");
			</script>
		</c:if>
		<c:if test="${message == 2}">
			<script>
				alert("删除失败！！！");
			</script>
		</c:if>
		<!-- ${list} -->
		<table class="tablelist">
			<thead>
				<tr>
					<th>姓名</th>
					<th>文件名</th>
					<th>目标职业</th>
					<th width="140px">操作</th>
				</tr>
			</thead>
			<c:forEach items="${list}" var="resume">
			<tr>
				<td>${resume.name}</td>
				<td>${resume.title}</td>
				<td>${resume.target}</td>
				<td>
					<button class="see" type="button" onclick="window.location.href='<%=basePath%>seeResume?id=${resume.id}'">
						<!-- <i class="fa fa-edit"></i> -->
						<svg t="1641177215278" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="3562" width="12" height="12">
							<path d="M885.12 330.666667c-65.216-90.453333-171.498667-149.333333-291.52-149.333334-198.357333 0-359.146667 160.768-359.146667 359.104 0 151.872 94.293333 281.706667 227.477334 334.229334H181.12a85.333333 85.333333 0 0 1-85.333333-85.333334V170.666667a85.333333 85.333333 0 0 1 85.333333-85.333334h618.666667a85.333333 85.333333 0 0 1 85.333333 85.333334v160z m-57.642667 374.976l92.309334 92.309333a48.64 48.64 0 0 1 0 68.693333c-18.986667 18.986667-49.706667 18.986667-68.693334 0l-92.330666-92.309333a283.946667 283.946667 0 0 1-164.394667 52.117333c-157.546667 0-285.226667-127.701333-285.226667-285.226666 0-157.525333 127.68-285.226667 285.226667-285.226667 157.546667 0 285.226667 127.701333 285.226667 285.226667 0 61.226667-19.285333 117.952-52.117334 164.416zM647.893333 341.184c43.946667 5.333333 80.490667 33.493333 110.378667 86.613333a21.333333 21.333333 0 0 0 37.184-20.906666c-36.096-64.213333-83.84-100.949333-142.421333-108.074667a21.333333 21.333333 0 1 0-5.141334 42.368z" fill="#FFA500" p-id="3563">
							</path>
						</svg>
						查看
					</button>
					<button class="edit" type="button" onclick="window.location.href='<%=basePath%>update?method=findResume&id=${resume.id}'">
						<!-- <i class="fa fa-edit"></i> -->
						<svg t="1640303743891" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2051" width="12" height="12">
							<path d="M105.164714 877.700572h813.670572a73.149714 73.149714 0 0 1 0 146.267429H105.164714a73.149714 73.149714 0 1 1 0-146.267429zM504.608231 100.572857c1.151964 1.27996 1.791944 2.495922 3.039905 3.807881 25.119215 27.83913 60.030124 65.885941 102.812787 112.700478 36.79885 39.35877 72.797725 78.557545 100.956845 108.380613L310.694291 740.776851l-25.663198 25.343208a141.371582 141.371582 0 0 1-99.772882 41.182713H70.797788c-21.343333 0-38.526796-17.663448-38.526796-39.902753v-116.47636a153.27521 153.27521 0 0 1 45.246586-108.924596l21.471329-21.43933L504.608231 100.540858z m61.150089-62.07806A121.084216 121.084216 0 0 1 653.243586 0.895972c32.95897 0 64.509984 13.535577 87.485266 37.534827l36.766851 38.07881c48.382488 50.046436 48.382488 131.131902 0 181.050342l-4.287866 5.11984a19602.267429 19602.267429 0 0 1-207.449517-224.216993z" p-id="2052" fill="#005F9B">
							</path>
						</svg>
						修改
					</button>
					<button class="remove" type="button" keyword="${resume.id}">
						<!-- <i class="fa fa-remove"></i> -->
						<svg t="1640304295698" class="icon" viewBox="0 0 1044 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="6608" width="12" height="12">
							<path d="M42.816183 230.044421h75.608924v606.356349A187.351737 187.351737 0 0 0 305.653098 1024h433.111678a187.351737 187.351737 0 0 0 187.227991-187.227991v-606.356349h75.608924a42.816183 42.816183 0 1 0 0-85.632366H709.436928V114.960461A115.207706 115.207706 0 0 0 593.98173 0.000247H450.064906a115.207706 115.207706 0 0 0-115.08396 114.960214v29.451594H42.816183a42.816183 42.816183 0 0 0 0 85.632366zM420.737058 144.412055V114.960461a29.451594 29.451594 0 0 1 29.451595-29.327847H593.98173a29.451594 29.451594 0 0 1 29.699086 29.327847v29.451594z" fill="crimson" p-id="6609">
							</path>
							<path d="M522.208937 807.444161a42.816183 42.816183 0 0 0 42.816183-42.816183v-408.362439a42.816183 42.816183 0 1 0-85.632366 0v408.362439a42.816183 42.816183 0 0 0 42.816183 42.816183zM329.65986 759.306892a42.939929 42.939929 0 0 0 42.939929-42.816183V403.784077a42.939929 42.939929 0 0 0-85.756112 0V716.490709a42.939929 42.939929 0 0 0 42.816183 42.816183zM690.627507 759.306892a42.816183 42.816183 0 0 0 42.816183-42.816183V403.784077a42.816183 42.816183 0 0 0-85.632366 0V716.490709a42.816183 42.816183 0 0 0 42.816183 42.816183z" fill="#FFF" p-id="6610">
							</path>
						</svg>
						删除
					</button>
				</td>
			</tr>
			</c:forEach>
		</table>

		<table class="page">
			<td>
				<button type="button" onclick="javascript:go(1)">首页</button>
				<button type="button" <c:if test="${isFirstPage == true }">disabled</c:if> onclick="javascript:go(${prePage})">上一页</button>
				<button type="button" <c:if test="${isLastPage == true }">disabled</c:if> onclick="javascript:go(${nextPage})">下一页</button>
				<button type="button" onclick="javascript:go(${totalPage})">尾页</button>

				<input type="text" class="page-no" name="pageNo" id="pageNo"/>
				<button type="button" onclick="javascript:goJump()">跳转</button>
				总记录条数${totalCount}条，当前${pageNo}/${totalPage}页，每页${pageSize}条数据
			</td>
		</table>
		<script type="text/javascript">

		function goJump(){
			var jumpPage = document.getElementById("pageNo").value;
			window.location.href = "<%=basePath%>pageQuery?userphone=${userphone}&pageNo="+jumpPage;
		}

		function go(page){
			window.location.href = "<%=basePath%>pageQuery?userphone=${userphone}&pageNo="+page;
		}
		</script>

	</body>

</html>
