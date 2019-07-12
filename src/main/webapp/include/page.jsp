<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<span style="color: red;font-size: 40">${page.p }</span>
				||
				${page.maxPage }
				<a href="${page.servletName }?p=1">首页</a>
				<a href="${page.servletName }?p=${page.prev }">上一页</a>
				<c:forEach begin="${page.startPage }" end="${page.endPage }" var="i">
				<c:if test="${page.p==i }">
					<span style="color: red">${i }</span>
				</c:if>
				<c:if test="${page.p!=i }">
					<a href="${page.servletName }?p=${i }">${i }</a>
				</c:if>
				</c:forEach>
				<a href="${page.servletName }?p=${page.next }">下一页</a>
				<a href="${page.servletName }?p=${page.maxPage }">末页</a>
				
				<form action="${page.servletName }" method="post" style="display: inline;">
					跳到第<input size="1" type="text" name="p" />页
					<button type="submit">GO</button>
				</form>
				共【${page.rowCount }】条记录