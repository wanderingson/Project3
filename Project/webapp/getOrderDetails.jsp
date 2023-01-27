
<%@page import="orderdb.OrderDetailsVO"%>
<%@page import="orderdb.OrderDetailsDAO"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int order_num = Integer.parseInt(request.getParameter("order_num"));
		
		OrderDetailsDAO oddao = new OrderDetailsDAO();
		ArrayList<OrderDetailsVO> odvArray = new ArrayList<>();
		
		odvArray = oddao.getOrderDetailsInfo(order_num);
	%>
	
	
	<table border=2>
		<caption>NO.<%=order_num %></caption>
		<tr>
			<th>상세번호</th>
			<th>상품명</th>
			<th>수량</th>
			<th>결제금액</th>
			<th>배송상태</th>
		</tr>
		<% for(OrderDetailsVO imsi : odvArray) { %>
		<tr>
			<td><%=imsi.getOrder_details_num() %></td>
			<td><%=imsi.getProduct_name() %></td>
			<td><%=imsi.getProduct_qty() %></td>
			<td><%=imsi.getOrder_price() %></td>
			<td><%=imsi.getDelivery_state() %></td>
		</tr>
		<%} %>
	</table>
	<a href="AdminMain.jsp">[홈으로]</a>
</body>
</html>