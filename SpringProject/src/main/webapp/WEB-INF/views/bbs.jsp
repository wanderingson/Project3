<%@page import="com.project.shop.vo.BbsVO"%>
<%@page import="com.project.shop.dao.BbsDAO"%>
<%@page import="java.sql.Timestamp"%>

<%@page import="java.util.List"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	    <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
	   
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD</title>
<style>
.controller {
	padding: 25px 0;
	margin: auto;
	width: 840px;
	text-align: center;
}
table {
	width: 840px;
	padding: 10px 0;
	border-collapse: collapse;
}
th {
	background-color: rgb(100, 100, 100);
	color: white;
}
.bt {
	margin: 4px 0;
	padding: 10px 0;
	width: 840px;
	background-color: gray;
	color: white;
	border: none;
	width: 100px;
	height:50px;
}
a {
	text-decoration: none;
	color: black;
}
a:hover {
	text-decoration-line: underline;
}

#view{cursor: pointer;}

</style>

<%@include file="Header.jsp" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
</head>
<body>

<div class="controller">
<table>
<tr>
<th width="100px">카테고리</th>
<th width="40px">번호</th>
<th width="150px">제목</th>
<!-- <th>내용</th> -->
<th width="100px">작성자</th>
<th width="150px">날짜</th>
<th width="40px">조회</th>
</tr>
<c:set var="count" value="0"></c:set>
		<c:forEach items="${alist}" var="a">
		<tr>
		<td>${a.bbsCategory}</td>
		<td>${a.bbsId }</td>
		<td><b><a href="bbsView.do?bbsId=${a.bbsId }" class="nav-link" id="view">${a.bbsTitle }</a></b></td>
		<%-- <td>${a.bbsContent }</td> --%>
		<td>${a.memID }</td>
		<td><fmt:formatDate value="${a.bbsDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		<td>${a.bbsHit }</td>
		</tr>
		<c:set var="count" value="${count+1 }"></c:set>
	<c:if test="${count==0 }">
		<tr><td colspan="7">작성한 문의가 없습니다.</td></tr>
	</c:if>

	</c:forEach>
	



</table>
<br>
<div class="writebtn">
<c:if test="${sessionScope.sid eq 'admin' }">
<a href="bbswrite.do"><button class="bt">글쓰기</button></a>
</c:if>
<a href="index.do"><button class="bt">HOME</button></a>
</div>

</div>
<%@ include file="footer.jsp" %>
</body>
</html>