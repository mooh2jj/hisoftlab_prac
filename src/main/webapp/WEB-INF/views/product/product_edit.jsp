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
<script type="text/javascript">
	function product_update(){
		document.form1.action = "${path}/product/update.do";
		document.form1.submit();
	}
	
	function product_delete(){
		if(confirm("삭제하시겠습니까?")){
			document.form1.action = "${path}/product/delete.do";
			document.form1.submit();
		}
	}
</script>
</head>
<body>
<h2>상품 정보 편집</h2>
<form id="form1" name="form1" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>상품명</td>
			<td><input name="product_name" value="${dto.product_name}"></td>
		</tr>
		<tr>
			<td>가격</td>
			<td><input name="price" value="${dto.price}"></td>
		</tr>
		<tr>
			<td>상품설명</td>
			<td><textarea rows="5" cols="60" name="description" 
			id="description">${dto.description}</textarea></td>
		</tr>
		<tr>
			<td>상품 이미지</td>
			<td>
				<img src="${path}/resources/images/${dto.product_url}" width="300" height="300" />
				<br>
				<input type="file" name="file1">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="hidden" name="product_id" value="${dto.product_id}">
				<input type="button" value="수정" onclick="product_update()">
				<input type="button" value="삭제" onclick="product_delete()">
				<input type="button" value="목록" onclick="location.href='${path}/product/list.do'">
			</td>
		</tr>
	</table>
</form>
</body>
</html>