<%@page import="db.ProductVO"%>
<%@page import="db.ProductDAO"%>
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
String prdname = request.getParameter("product");
ProductDAO pd = new ProductDAO();
ProductVO pv = pd.getPrdOne(prdname);
%>
<form action="prdUpdate.do" method="post">
<table border = "1">
	<caption>상품수정</caption>
	<tr>
	<th>대분류번호</th>
	<th>소분류이름</th>
	<th>상품이름</th>
	<th>상품설명</th>
	<th>상품가격</th></tr>
	<tr>
		<td><input type="number" value="<%=pv.getProductnum() %>" name ="cnum" required></td>
		<td><input type="text" value="<%=pv.getCategory_subName() %>" name="csub" required></td>
		<td><input type="text" value="<%=pv.getProduct() %>" name="prdname" required></td>
		<td><input type="text" value="<%=pv.getDescrip() %>" name="prddiscription" required></td>
		<td><input type="number" value="<%=pv.getPrice() %>"name="prdprice" required></td>
		<input type="hidden" value="<%=pv.getProduct() %>" name="sprdname">
	</tr>
</table>
	<input type="submit" value="수정">
		<a href="AdminSideBar.jsp">[메뉴]</a>
	
</form>	

</body>
</html>