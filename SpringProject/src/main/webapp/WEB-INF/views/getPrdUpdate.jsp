
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

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
		<td><input type="number" value="${pv.productnum}" name ="cnum" required></td>
		<td><input type="text" value="${pv.category_subName}" name="csub" required></td>
		<td><input type="text" value="${pv.product}" name="prdname" required></td>
		<td><input type="text" value="${pv.descrip}" name="prddiscription" required></td>
		<td><input type="number" value="${pv.price}"name="prdprice" required></td>
		<input type="hidden" value="${pv.product}" name="sprdname">
	</tr>
</table>
	<input type="submit" value="수정">
		<a href="adminsidebar.do">[메뉴]</a>
	
</form>	

</body>
</html>