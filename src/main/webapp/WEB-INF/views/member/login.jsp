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
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(function(){
		$("#btnLogin").click(function(){
			var userid = $("#userid").val();
			var passwd = $("#passwd").val();
			
			if(userid == ""){
				alert("아이디를 입력하세요.");
				$("#userid").focus();
				return;
			}
			
			if(passwd == ""){
				alert("비밀번호를 입력하세요.");
				$("#passwd").focus();
				return;
			}
			document.form1.action = "${path}/member/login_check.do";
			document.form1.submit();
			
		});	
	});
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>로그인</h2>
<form name="form1" method="post">
	<table border="1" width="400px">
		<tr>
			<td>아이디</td>
			<td><input id="userid" name="userid"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input id="passwd" name="passwd"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="button" id="btnLogin">로그인</button>
				<c:if test="${message == 'nologin'}">
					<div style="color:red;">
						먼저 로그인하세요.
					</div>
				</c:if>
				<c:if test="${message == 'error'}">
					<div style="color:red;">
						아이디 또는 비밀번호가 일치하지 않습니다.
					</div>
				</c:if>
				<c:if test="${message == 'logout'}">
					<div style="color:red;">
						로그아웃되었습니다.
					</div>
				</c:if>
		</tr>
	</table>
</form>
</body>
</html>