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
<script src="${path}/resources/js/ckeditor/ckeditor.js"></script>
<c:if test="${sessionScope.admin_userid == null }">
	<script type="text/javascript">
		alert("로그인 하신 후 사용하세요.");
		location.href = "${path}/admin/login.do";
	</script>
</c:if>
<script type="text/javascript">
	
function product_write() {
	var product_name = document.form1.product_name.value;
	var price = document.form1.price.value;
	var description = document.form1.description.value;
	
	if(product_name == ""){
		alert("상품명을 입력하세요.");
		document.form1.product_name.focus();
		return;
	}
	
	if(price == ""){
		alert("가격을 입력하세요.");
		document.form1.price.focus();
		return;
	}
	
/* 	if(description == ""){
		alert("상품설명을 입력하세요.");
		document.form1.description.focus();
		return;
	} */
	
	document.form1.action = "${path}/product/insert.do";
	document.form1.submit();
}

</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>
<h2>상품등록</h2>
<form id="form1" name="form1" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>상품명</td>
			<td><input name="product_name"></td>
		</tr>
		<tr>
			<td>가격</td>
			<td><input name="price"></td>
		</tr>
		<tr>
			<td>상품설명</td>
			<td><textarea rows="5" cols="60"
					name="description" id="description" placeholder="상품설명을 입력하세요."></textarea></td>
					<!-- textarea를 스마트에디터로 변경 -->
		</tr>
		<script>
		// id description인 태그에 ckeditor 적용
			CKEDITOR.replace("description", {
				filebrowserUploadUrl: "${path}/imageUpload.do"
			});
		</script>
		<tr>
			<td>상품이미지</td>
			<td><input type="file" name="file1"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="등록" onclick="product_write();">
				<input type="button" value="목록" onclick="location.fref='${path}/admin/product/list.do'">
			</td>
		</tr>
		
	</table>
</form>

</body>
</html>