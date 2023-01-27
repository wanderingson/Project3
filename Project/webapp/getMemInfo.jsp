
<%@page import="orderdb.OrderDetailsVO"%>
<%@page import="orderdb.OrderDetailsDAO"%>
<%@page import="orderdb.OrderVO"%>
<%@page import="orderdb.OrderDAO"%>
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

		OrderDAO odao = new OrderDAO();
		OrderVO odvo = null;
		
		odvo = odao.getOneInfo(order_num);	
		
		OrderDetailsDAO oddao = new OrderDetailsDAO();
		ArrayList<OrderDetailsVO> odvArray = new ArrayList<>();
		
		odvArray = oddao.getOrderDetailsInfo(order_num);
		
	%>
	
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
			<td><%=odvo.getOrder_num() %></td>
			<td>
				<a href="memInfo.jsp?mem_id=<%=odvo.getMem_id() %>">
					<%=odvo.getMem_id() %>
				</a>
			</td>
			<td><%=odvo.getTel() %></td>
			<td><%=odvo.getAddress1() %></td>
			<td><%=odvo.getAddress2() %></td>
			<td><%=odvo.getAddress3() %></td>
			<td><%=odvo.getTotal_price() %></td>
			<td><%=odvo.getOrder_date() %></td>
			<td><%=odvo.getDelivery_state() %></td>
			<td><%=odvo.getDelivery_message() %></td>
		</tr>
	</table>
	
	<table border=2>
		<caption>NO.<%=odvo.getOrder_num() %></caption>
		<tr>
			<th>주문상세번호</th>
			<th>상품명</th>
			<th>상품수량</th>
			<th>상품가격</th>
			<th>상품상태</th>
		</tr>
		<% for(OrderDetailsVO imsi : odvArray) {%>
		<tr>
			<td><%=imsi.getOrder_details_num() %></td>
			<td><%=imsi.getProduct_name() %></td>
			<td><%=imsi.getProduct_qty() %></td>
			<td><%=imsi.getOrder_price() %></td>
			<td><%=imsi.getDelivery_state() %></td>
		</tr>
		<% } %>
	</table>
	<a href="AdminSideBar.jsp">[홈으로]</a>
	
</body>
</html>