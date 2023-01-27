
<%@page import="orderdb.OrderDAO"%>
<%@page import="orderdb.OrderVO"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문확인</title>
</head>
<body>
	
	<%
		OrderDAO odao = new OrderDAO();
		ArrayList<OrderVO> ovArray = new ArrayList<>();
		
		ovArray = odao.getAllInfo();
	%>
	
	
	<table border=2>
		<caption>주문정보</caption>
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
		<% for(OrderVO imsi : ovArray) { %>
		<tr>
			<td>
				<a href="getOrderDetails.jsp?order_num=<%=imsi.getOrder_num() %>">
					<%=imsi.getOrder_num() %>
				</a>
			</td>
			<td>
				<a href="memInfo.jsp?mem_id=<%=imsi.getMem_id() %>">
					<%=imsi.getMem_id() %>
				</a>
			</td>
			<td>
				<%=imsi.getTel() %>
			</td>
			<td>
				<%=imsi.getAddress1() %>
			</td>
			<td>
				<%=imsi.getAddress2() %>
			</td>
			<td>
				<%=imsi.getAddress3() %>
			</td>
			<td>
				<%=imsi.getTotal_price() %>
			</td>
			<td>
				<%=imsi.getOrder_date() %>
			</td>
			<td>
				<%=imsi.getDelivery_state() %>
			</td>
			<td>
				<%=imsi.getDelivery_message() %>
			</td>
		</tr>
		<% } %>
	</table>
	<a href="AdminSideBar.jsp">[홈으로]</a>
</body>
</html>