<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="path"  value="${pageContext.request.contextPath}"  />     
<a href="${path}">Home</a> |
<a href="${path}/upload/uploadForm">업로드 테스트</a> |
<a href="${path}/product/list.do">상품목록</a> |
<a href="${path}/cart/list.do">장바구니</a> 


<div style="text-align: right;">
<c:choose>
	<c:when test="${sessionScope.userid == null}">
		<a href="${path}/member/login.do">로그인</a>
		<a href="${path}/admin/login.do">관리자 로그인</a>
	</c:when>
	<c:otherwise>
		${sessionScope.name}님이 로그인 중입니다.
		<a href="${path}/member/logout.do">로그아웃</a>
	</c:otherwise>
</c:choose>
</div>