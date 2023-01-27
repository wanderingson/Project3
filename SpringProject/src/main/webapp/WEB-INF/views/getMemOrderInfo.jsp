<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table border=2>
		<caption>주문자정보</caption>
		<tr>
			<th>주문번호</th>
			<th>ID</th>
			<th>전화번호</th>
			<th>우편번호</th>
			<th>주소</th>
			<th>상세주소</th>
			<th>결제금액</th>
			<th>주문일자</th>
			<th>배송상태</th>
			<th>배송요청사항</th>
		</tr>
		<tr>
			<td>NO.${ov.order_num }</td>
			<td>
				<a href="memInfo.jsp?mem_id=${ov.mem_id }">
					${ov.mem_id }	
				</a>
			</td>
			<td>${ov.tel }</td>
			<td>${ov.address1 }</td>
			<td>${ov.address2 }</td>
			<td>${ov.address3 }</td>
			<td>${ov.total_price }원</td>
			<td><fmt:formatDate value="${ov.order_date }" pattern="yyyy-MM-dd" /></td>
			<td>${ov.delivery_state }</td>
			<td>${ov.delivery_message }</td>
		</tr>
	</table>
	
	<table border=2>
		<caption>NO.${ov.order_num }</caption>
		<tr>
			<th>주문상세번호</th>
			<th>상품명</th>
			<th>상품수량</th>
			<th>상품가격</th>
			<th>상품상태</th>
		</tr>
		<c:forEach var="imsi" items="${odvlist }">
		<tr>
			<td>NO.${imsi.order_details_num }</td>
			<td>${imsi.product_name }</td>
			<td style="text-align:center">${imsi.product_qty }</td>
			<td>${imsi.order_price }원</td>
			<td>${imsi.delivery_state }</td>
		</tr>
		</c:forEach>
	</table>
	<a href="adminsidebar.do">[홈으로]</a>
	
</body>
</html>