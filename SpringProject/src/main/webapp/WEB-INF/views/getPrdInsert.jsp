
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="prdin.do" method="post">
<table border = "1">
	<caption>상품등록</caption>
	<tr>
	<th>대분류번호</th>
	<th>소분류이름</th>
	<th>상품이름</th>
	<th>상품설명</th>
	<th>상품가격</th></tr>
	<tr>
		<td><input type="number" name="cnum" required></td>
		<td><input type="text" name="csub" required></td>
		<td><input type="text" name="prdname" required></td>
		<td><input type="text" name="prddiscription" required></td>
		<td><input type="number" name="prdprice" required></td>
	</tr>
</table>
<input type="submit" value="등록하기"><input type="reset" value="초기화"><br>
</form>
<a href="adminsidebar.do">메뉴</a>


</body>
</html>