<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사원 전체 명단</h1>
	<table border="1">
	<thead>	<tr><th>번호</th>	<th>이름</th>	<th>전화</th>	</tr>
	</thead>
	<tbody>
		<c:forEach var="imsi" items="${alist}">
		<tr>
			<td>${imsi.id}</td>
			<td><a href="getTelinfo.do?name=${imsi.name }">${imsi.name}</a></td>
			<td>${imsi.tel}</td>
		</tr>
		</c:forEach>

	</tbody>
	</table>
	<div>
	<a href="orderList.do">[사원등록]</a>
	<a href="sawonAll.do">[모두보기]</a>
	</div>
</body>
</html>