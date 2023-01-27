

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품목록</title>
</head>
<body>
	
	
	<table border=2>
	<caption>상품목록</caption>
		<tr>
			<th colspan=2>카테고리</th>
			<th>상품명</th>
			<th>상품설명</th>
			<th>가격</th>
		</tr>
		<c:forEach var="imsi" items="${plist }">
		<tr>	
			<c:if test="${imsi.productnum==1 }">
			<td>채소/과일</td>
			</c:if>
			<c:if test="${imsi.productnum==2 }">
			<td>수산/해산물</td>
			</c:if>	
			<c:if test="${imsi.productnum==3 }">
			<td>정육</td>		
			</c:if>		
			<c:if test="${imsi.productnum==4 }">
			<td>음료</td>	
			</c:if>
			<td>${imsi.category_subName }</td>
			<td><a href="getPrdUpdate.do?product=${imsi.product}"> ${imsi.product }</a></td>
			<td>${imsi.descrip}</td>
			<td>${imsi.price}원</td>
		</tr>
		</c:forEach>
	</table>
	<a href="adminsidebar.do">[홈으로]</a>
</body>
</html>