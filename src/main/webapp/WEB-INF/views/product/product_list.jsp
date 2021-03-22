<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="path"  value="${pageContext.request.contextPath}"  /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-2.2.1.min.js"></script>
<script type="text/javascript">
	
$(function(){
	
	$("#btnAdd").click(function(){
		location.href = "${path}/product/write.do";
	});
});

</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>상품등록</h2>
<c:if test="${sessionScope.admin_userid != null }">
	<button type="button" id="btnAdd">상품등록</button>
</c:if>
<table border="1">
	<tr>
		<th>상품ID</th>
		<th>&nbsp;</th>
		<th>상품명</th>
		<th>가격</th>
	</tr>
	<c:forEach var="row" items="${list}">
	<tr align="center">
		<td>${row.product_id}</td>
		<td><img src="${path}/resources/images/${row.product_url}" width="100" height="100"/></td>
		<td><a href="${path}/product/detail/${row.product_id}">${row.product_name}</a>
			<!-- 관리자만 편집 버튼 표시 -->
			<c:if test="${sessionScope.admin_userid != null }">
			<br>
			<a href="${path}/product/edit/${row.product_id}">[편집]</a>
			</c:if>
		</td>
		<td><fmt:formatNumber value="${row.price}" pattern="#,###" /></td>
	</tr>
	</c:forEach>
</table>

</body>
</html>