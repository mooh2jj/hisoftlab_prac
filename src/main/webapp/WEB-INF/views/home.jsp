<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<c:set var="path"  value="${pageContext.request.contextPath}"  />         
<html>
<head>
	<title>Home</title>
</head>
<body>
<%@ include file="include/menu.jsp" %>
<c:if test="${sessionScope.userid != null }">
<h2>${sessionScope.name}(${sessionScope.userid})님의 방문을 환영합니다.</h2>
</c:if>

환영환영!
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<!-- 배포 디렉토리 확인 -->
<%=application.getRealPath("/") %>
</body>
</html>
