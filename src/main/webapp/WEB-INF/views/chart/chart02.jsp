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
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script>
	google.load('visualization','1',{
		'packages':['corechart']
	});
	
	google.setOnLoadCallback(drawChart);
	
	function drawChart(){
		var jsonData = $.ajax({
			url : "${path}/chart/cart_money_list.do",
			dataType : "json",
			async : false
		}).responseText;
		
		console.log(jsonData);
		
		var data = new google.visualization.DataTable(jsonData);
		
/* 		var chart = new google.visualization.PieChart(
				document.getElementById('chart_div')); */
/* 		var chart = new google.visualization.LineChart(
				document.getElementById('chart_div')); */
 		var chart = new google.visualization.ColumnChart(
				document.getElementById('chart_div')); 
		
		chart.draw(data, {
			title : "차트 예제",
			//curveType : "function",
			width : 700,
			height : 440
		});
		
	}
</script>
</head>
<body>
<%@ include file="../include/menu.jsp" %>

<div id="chart_div"></div>

<button id="btn" type="button" onclick="drawChart()">refresh</button>
</body>
</html>