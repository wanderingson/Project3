<%@page import="db.ProductVO"%>
<%@page import="db.ProductDAO"%>

<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품목록</title>
</head>
<body>
	<%
		ProductDAO pdao = new ProductDAO();
		ArrayList<ProductVO> pvArray = new ArrayList<>();
		
		pvArray = pdao.getAllInfo();
	%>
	
	<table border=2>
	<caption>상품목록</caption>
		<tr>
			<th colspan=2>카테고리</th>
			<th>상품명</th>
			<th>상품설명</th>
			<th>가격</th>
		</tr>
		<% for(ProductVO imsi : pvArray) { %>
		<tr>	
			<% if(imsi.getProductnum() == 1) {%> 
			<td>채소/과일</td>
			<%} else if(imsi.getProductnum() == 2) {%>
			<td>수산/해산물</td>	
			<%} else if(imsi.getProductnum() == 3) {%>
			<td>정육</td>				
			<%} else if(imsi.getProductnum() == 4) {%>
			<td>음료</td>	
			<%} %>
			<td><%=imsi.getCategory_subName() %></td>
			<td><a href="getPrdUpdate.jsp?product=<%=imsi.getProduct() %>"> <%=imsi.getProduct() %></a></td>
			<td><%=imsi.getDescrip() %></td>
			<td><%=imsi.getPrice() %>원</td>
		</tr>
		<% } %>
	</table>
	<a href="AdminSideBar.jsp">[홈으로]</a>
</body>
</html>