
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

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
<a href="adminsidebar.do">[메뉴]</a>



</body>
</html>