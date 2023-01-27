


<%@page import="java.sql.Timestamp"%>

<%@page import="java.util.List"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	    <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
	    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
	
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
</style>
<%@include file="Header.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
</head>
<body>

<div class="controller">
<table>
<tr>
<th width="100px">카테고리</th>
<th width="40px">번호</th>
<th width="150px">제목</th>
<th>내용</th>
<th width="100px">작성자</th>
<th width="150px">날짜</th>
</tr>

		<c:set var="count" value="0"></c:set>
		<c:forEach items="${qlist}" var="ql">
		<c:if test="${sessionScope.sid == ql.memId }">
		<tr>
		<td>${ql.qnaCategory}</td>
		<td>${ql.qnaId }</td>
		<td><b><a href="qview.do?qnaId=${ql.qnaId }&qnaAnswer=${ql.qnaAnswer } ">${ql.qnaTitle }</a></b></td>
		<td>${ql.qnaContent }</td>
		<td>${ql.memId }</td>
		<td><fmt:formatDate value="${ql.qnaDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		</tr>
		<c:set var="count" value="${count+1 }"></c:set>
		
		</c:if>
		<c:if test="${sessionScope.sid=='admin' }">
		<tr>
		<td>${ql.qnaCategory}</td>
		<td>${ql.qnaId }</td>
		<td><b><a href="qview.do?qnaId=${ql.qnaId }&qnaAnswer=${ql.qnaAnswer } ">${ql.qnaTitle }</a></b></td>
		<td>${ql.qnaContent }</td>
		<td>${ql.memId }</td>
		<td><fmt:formatDate value="${ql.qnaDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
		<c:set var="count" value="${count+1 }"></c:set>
		</c:if>
		
	</c:forEach>
		
	<c:if test="${count==0 }">
		<tr><td colspan="7">작성한 문의가 없습니다.</td></tr>
	</c:if>
	



</table>
<br>
<div class="writebtn">
<c:if test="${sessionScope.sid ne null and sessionScope.sid ne 'admin' }">
<a href="Qnawrite.do"><button class="bt">글쓰기</button></a>
</c:if>
<a href="index.do"><button class="bt">HOME</button></a>
</div>

</div>
<%@ include file="footer.jsp" %>
</body>
</html>