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
</head>
<body>
	<form action="emp.do?method=add" method="post">
	  <div class="form-group">
	    <label for="">员工名称</label>
	    <input name="ename" type="text" class="form-control">
	  </div>
	  <div class="form-group">
	    <label for="">入职日期</label>
	    <input name="hiredate" type="text" class="form-control">
	  </div>
	  <div class="form-group">
	    <label for="">员工月薪</label>
	    <input name="sal" type="text" class="form-control">
	  </div>
	  <div class="form-group">
	  <label for="">所在部门</label>
	  <select class="form-control" name="did">
	    <c:forEach items="${deptList}" var="dept">
	    	<option value="${dept.did }">${dept.dname }</option>
	    </c:forEach>
	  </select>
	</div>
	<button type="submit" class="btn btn-primary">新增</button>
	</form>
	
</body>
</html>