<%@page import="board.BbsDto"%>
<%@page import="board.BbsDao"%>
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
button {
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
</head>
<body>
<%
BbsDao bbsDao = BbsDao.getInstance();
List<BbsDto> list = bbsDao.selectList();
%>
<div class="controller">
<table>
<tr>
<th width="100px">카테고리</th>
<th width="40px">번호</th>
<th width="150px">제목</th>
<th>내용</th>
<th width="100px">작성자</th>
<th width="150px">날짜</th>
<th width="40px">조회</th>
</tr>
<%
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss");
int count = 0;
for (BbsDto b : list) {
	String stDate = "";
	Timestamp tDate = b.getBbsDate();
	if (tDate != null) {
		stDate = sdf.format(tDate);
	}
	
	%>
	<tr>
	<td><%=b.getBbsCategory() %></td>
	<td><%=b.getBbsId() %></td>
	<td><b><a href="bbsview.do?bbsId=<%=b.getBbsId() %> "><%=b.getBbsTitle() %></a></b></td>
	<td><%=b.getBbsContent() %></td>
	<td><%=b.getId() %></td>
	<td><%=stDate %></td>
	<td><%=b.getBbsHit() %></td>
	</tr>
	<%
	count++;
}
if (count == 0) {
	%>
		<tr><td colspan="7">작성한 게시글이 없습니다.</td></tr>		
	<%
}
System.out.println("현재 게시글 " + count + "개");
%>



</table>
<br>
<div class="writebtn">
<c:if test="${sessionScope.sid eq 'admin'}">
<a href="write.do"><button>글쓰기</button></a>
</c:if>
<a href="index.jsp"><button>HOME</button></a>
</div>

</div>
<%@ include file="footer.jsp" %>
</body>
</html>