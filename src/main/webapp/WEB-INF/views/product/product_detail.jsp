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
</head>
<body>
<h2>상품 정보</h2>
<table>
	<tr>
		<td><img src="${path}/resources/images/${dto.product_url}" width="300" height="300" /></td>
		<td>
			<table>
				<tr>
					<td>상품명</td>
					<td>${dto.product_name}</td>
				</tr>
				<tr>
					<td>가격</td>
					<td>${dto.price}</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>${dto.description}</td>
				</tr>
				<tr>
					<td colspan="2">
						<form name="form1" method="post" action="${path}/cart/insert.do">
						<input type="hidden" name="product_id" value="${dto.product_id}">
						<select name="amount">
							<c:forEach begin="1" end="10" var="i">
								<option value="${i}">${i}</option>
							</c:forEach>
						</select>&nbsp;개
						<input type="submit" value="장바구니에 담기">
						</form>
						<a href="${path}/product/list.do">상품목록</a>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>