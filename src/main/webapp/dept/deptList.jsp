<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
<link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<script>
	$(function() {
		$(".del").click(function() {
			return confirm("是否要删除该部门？");
		});
	});
</script>
</head>
<body>
	<table class="table">
		<tr>
			<td>部门ID</td>
			<td>部门名称</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${page.list }" var="dept">
		<tr>
			<td>${dept.did }</td>
			<td>${dept.dname }</td>
			<td>
				<a href="dept.do?method=editForm&did=${dept.did }">修改</a>
				|
				<a class="del" href="dept.do?method=delete&did=${dept.did }">删除</a>
			</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="3">
				<%@ include file="../include/page.jsp" %>			
			</td>
		</tr>
	</table>

</body>
</html>