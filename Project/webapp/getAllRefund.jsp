
<%@page import="orderdb.OrderDetailsVO"%>
<%@page import="orderdb.OrderDetailsDAO"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>환불완료 내역</title>
</head>
<body>
	<%
		OrderDetailsDAO oddao = new OrderDetailsDAO();
		ArrayList<OrderDetailsVO> odvArray = new ArrayList<>();
		odvArray = oddao.getAllRefund();
	%>
	
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
		<% for(OrderDetailsVO imsi : odvArray) { %>
		<tr>
			<td>
				<a href="getMemInfo.jsp?order_num=<%=imsi.getOrder_num()%>">
				<%=imsi.getOrder_num() %>
				</a>
			</td>
			<td>
				<%=imsi.getOrder_details_num() %>
			</td>
			<td>
				<%=imsi.getProduct_name() %>
			</td>
			<td>
				<%=imsi.getProduct_qty() %>
			</td>
			<td>
				<%=imsi.getOrder_price() %>
			</td>
			<td>
				<%=imsi.getDelivery_state() %>
			</td>
		
		</tr>
		<% } %>
	</table>
	<a href="AdminSideBar.jsp">[홈으로]</a>
</body>
</html>