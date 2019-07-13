<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="lei" prefix="l" %>
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
			return confirm("是否要删除该员工？");
		});
	});
</script>
</head>
<body>
	<table class="table">
		<tr>
			<td>员工ID</td>
			<td>员工名称</td>
			<td>入职日期</td>
			<td>员工月薪</td>
			<td>所在部门</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${page.list }" var="emp">
		<tr>
			<td>${emp.eid }</td>
			<td>${emp.ename }</td>
			<td>${emp.hiredate }</td>
			<td>${emp.sal }</td>
			<td>
				${l:getDeptByDid(emp.did).dname }
			</td>
			<td>
				<a href="emp.do?method=editForm&eid=${emp.eid }">修改</a>
				|
				<a class="del" href="emp.do?method=delete&eid=${emp.eid }">删除</a>
			</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="6">
				<%@ include file="../include/page.jsp" %>			
			</td>
		</tr>
	</table>

</body>
</html>