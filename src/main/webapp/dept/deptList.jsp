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
			<td>
				<span style="color: red;font-size: 40">${page.p }</span>
				||
				${page.maxPage }
				<a href="dept.do?p=1">首页</a>
				<a href="dept.do?p=${page.prev }">上一页</a>
				<c:forEach begin="${page.startPage }" end="${page.endPage }" var="i">
				<c:if test="${page.p==i }">
					<span style="color: red">${i }</span>
				</c:if>
				<c:if test="${page.p!=i }">
					<a href="dept.do?p=${i }">${i }</a>
				</c:if>
				</c:forEach>
				<a href="dept.do?p=${page.next }">下一页</a>
				<a href="dept.do?p=${page.maxPage }">末页</a>
				
				<form action="dept.do" method="post" style="display: inline;">
					跳到第<input size="1" type="text" name="p" />页
					<button type="submit">GO</button>
				</form>
				共【${page.rowCount }】条记录
			
			</td>
		</tr>
	</table>

</body>
</html>