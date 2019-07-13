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
	$(function(){
		$("select:eq(0) option[value=${emp.did}]").prop("selected","selected");

	});

</script>
</head>
<body>
	<form action="emp.do?method=edit" method="post">
	  <div class="form-group">
	    <label for="">员工名称</label>
	    <input name="eid" type="hidden" value="${emp.eid }">
	    <input name="ename" type="text" class="form-control" value="${emp.ename }">
	  </div>
	  <div class="form-group">
	    <label for="">入职日期</label>
	    <input name="hiredate" type="text" class="form-control" value="${emp.hiredate }">
	  </div>
	  <div class="form-group">
	    <label for="">员工月薪</label>
	    <input name="sal" type="text" class="form-control" value="${emp.sal }">
	  </div>
	  <div class="form-group">
	  <label for="">所在部门</label>
	  <select class="form-control" name="did">
	    <c:forEach items="${deptList}" var="dept">
	    	<option value="${dept.did }">${dept.dname }</option>
	    </c:forEach>
	  </select>
	</div>
	<button type="submit" class="btn btn-primary">修改</button>
	</form>
	
</body>
</html>