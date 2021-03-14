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
		$("#btnList").click(function(){
			location.href= "${path}/product/list.do";
		});	
		$("#btnDelete").click(function(){
			if(confirm("장바구니를 비우시겠습니가?")){
				location.href="${path}/cart/deleteAll.do";
			}
		});
	});
	
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>장바구니</h2>
<c:choose>
	<c:when test="${map.count == 0 }">
		장바구니가 비었습니다.
	</c:when>
	<c:otherwise>
		<form id="form1" name="form1" action="${path}/cart/update.do" method="post"> <!-- action="${path}/cart/update.do" -->
			<table border=1 width="400px;">
				<tr>
					<th>상품명</th>
					<th>단가</th>
					<th>수량</th>
					<th>금액</th>
					<th>&nbsp;</th>
				</tr>
				<c:forEach var="row" items="${map.list}">
					<tr align="center">
						<td>${row.product_name}</td>
						<td><fmt:formatNumber value="${row.price}" pattern="#,###,###" /></td>
						<td>
							<input type="number" style="width:30px;"
							min="0" max="100" name="amount" value="<fmt:formatNumber value="${row.amount}" pattern="#,###,###"/>">
							<input type="hidden" name="cart_id" value="${row.product_id}">
						</td>
						<td><fmt:formatNumber value="${row.money}" pattern="#,###,###" /></td>
						<!-- 개별상품 삭제 -->
						<td><a href="${path}/cart/delete.do?cart_id=${row.cart_id}">[삭제]</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="5" align="right">
						장바구니 금액 합계 :
						<fmt:formatNumber value="${map.sumMoney}" pattern="#,###,###" /><br>
						배송료 : ${map.fee}<br>
						총합계 :
						<fmt:formatNumber value="${map.sum}" pattern="#,###,###" />
					</td>
				</tr>
			</table>
			<button id="btnUpdate">수정</button>		<!-- row갯수만 수정됨 수량은 바로 반영x -->
			<button type="button" id="btnDelete">장바구니 비우기</button>		<!-- from태그때문에! type="button"을 해줘야 됨! -->
		</form>
	</c:otherwise>
</c:choose>
<button type="button" id="btnList">상품목록</button>
</body>
</html>