<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>

table{
	margin-left:auto;
	margin-right:auto; 
}

table tr td {
	height:70px;
	width: 400px;
}
	
</style>
<body>
<section>
	<article class="card-body" style="max-width:800px; margin: auto;">
		<br>
		<h1 style="text-align: center;">회원등급별 혜택</h1>
		<hr>
		<br>
		<table style="text-align:center">
			<tr>
				<td><img src="./img/diamond.png" style="width:100px; height:100px;"></td>
				<td style="text-align:left"><b>다이아</b><br>1000000점 이상</td>
				<td><img src="./img/gold.png" style="width:100px; height:100px;"></td>
				<td style="text-align:left"><b>골드</b><br>100000점 이상</td>
			</tr>	
			<tr>
				<td colspan=2> 주문하는 제품 <br> <b>회원 할인율 10%</b> </td>
				<td colspan=2> 주문하는 제품 <br> <b>회원 할인율 8%</b> </td>
			</tr>
		</table>
		<br><br>
		<table style="text-align:center">	
			<tr>
				<td><img src="./img/silver.png" style="width:100px; height:100px;"></td>
				<td style="text-align:left"><b>실버</b><br>10000점 이상</td>
				<td><img src="./img/bronze.png" style="width:100px; height:100px;"></td>
				<td style="text-align:left"><b>브론즈</b><br>1000점 이상</td>
			</tr>
			<tr>
				<td colspan=2> 주문하는 제품 <br> <b>회원 할인율 5%</b> </td>
				<td colspan=2> 주문하는 제품 <br> <b>회원 할인율 3%</b> </td>
			</tr>					
		</table>
		<br><br>
		<table style="text-align:center">	
			<tr>
				<td><img src="./img/rookie.png" style="width:100px; height:100px;"></td>
				<td style="text-align:left"><b>루키</b><br>0점 이상</td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td colspan=2> 주문하는 제품 <br> <b>회원 할인율 1%</b> </td>
				<td colspan=2></td>
			</tr>					
		</table>		
	</article>
</section>	
</body>
</html>
<%@include file="footer.jsp" %>