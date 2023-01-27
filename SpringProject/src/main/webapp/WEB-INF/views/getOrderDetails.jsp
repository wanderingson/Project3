<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	
	<table border=2>
		<caption>NO.${order_num}</caption>
		<tr>
			<th>상세번호</th>
			<th>상품명</th>
			<th>수량</th>
			<th>결제금액</th>
			<th>배송상태</th>
		</tr>
		<c:forEach var="imsi" items="${odvlist}">
		<tr>
			<td>NO.${imsi.order_details_num}</td>
			<td>${imsi.product_name}</td>
			<td style="text-align:center">${imsi.product_qty}</td>
			<td>${imsi.order_price}원</td>
			<td>${imsi.delivery_state}</td>
		</tr>
		</c:forEach>
	</table>
	<a href="adminsidebar.do">[홈으로]</a>
</body>
</html>