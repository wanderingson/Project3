<%@ page language="java" contentType="text/html; charset=UTF-8"
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
		<caption>환불정보</caption>
		<tr>
			<th>주문번호</th>
			<th>주문상세번호</th>
			<th>상품명</th>
			<th>수량</th>
			<th>결제금액</th>
			<th>배송상태</th>
		</tr>
		<c:forEach var="imsi" items="${odvlist}">
		<tr>
			<td>
				<a href="getmemorderinfo.do?order_num=${imsi.order_num }">
					NO.${imsi.order_num }
				</a>
			</td>
			<td>
				NO.${imsi.order_details_num }
			</td>
			<td>
				${imsi.product_name }
			</td>
			<td>
				${imsi.product_qty }
			</td>
			<td>
				${imsi.order_price }원
			</td>
			<td>
				${imsi.delivery_state }
			</td>
		
		</tr>
		</c:forEach>
	</table>
	<a href="adminsidebar.do">[홈으로]</a>
</body>
</html>