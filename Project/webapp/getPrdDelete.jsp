<%@page import="db.ProductVO"%>
<%@page import="java.util.ArrayList"%>
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

	<%if(request.getAttribute("str")!=null) {
	String str = (String)request.getAttribute("str");%>
	<script>
	var dd = "<%=str%>";
	alert(dd);</script>
	<%} %>
<form action="prddelete.do" method=post>
	<table border=2>
		<caption>상품삭제</caption>
	<th>삭제할 상품명 입력</th>
	<tr>
		<td><input type="text" name="dprdname" id="delid" style="width:300px;" required></td>
	</tr>
	</table>
	<input type="submit" value="삭제하기"><input type="reset" value="초기화">
</form>
<a href="AdminSideBar.jsp">[메뉴]</a>



</body>
</html>