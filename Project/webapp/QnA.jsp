
<%@page import="board.QnADao"%>
<%@page import="board.QnADto"%>

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
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
/* QnADao.getInstance(); */
	QnADao qnaDao = new QnADao();
	List<QnADto> list = qnaDao.selectList();

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
</tr>
<%
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss");
int count = 0;
for (QnADto b : list) {
	if(id.equals(b.getId())){
		String stDate = "";
		Timestamp tDate = b.getQnaDate();
		if (tDate != null) {
			stDate = sdf.format(tDate);
		}
		%>
		
		<tr>
		<td><%=b.getQnaCategory() %></td>
		<td><%=b.getQnaId() %></td>
		<td><b><a href="qview.do?qnaId=<%=b.getQnaId() %>&qnaAnswer=<%=b.getQnaAnswer() %> "><%=b.getQnaTitle() %></a></b></td>
		<td><%=b.getQnaContent() %></td>
		<td><%=b.getId() %></td>
		<td><%=stDate %></td>
		</tr>
		 
		<%
		count++;
		}else if(id.equals("admin")){
			String stDate = "";
			Timestamp tDate = b.getQnaDate();
			if (tDate != null) {
				stDate = sdf.format(tDate);
			}
			%>
			<tr>
		<td><%=b.getQnaCategory() %></td>
		<td><%=b.getQnaId() %></td>
		<td><b><a href="qview.do?qnaId=<%=b.getQnaId() %>&qnaAnswer=<%=b.getQnaAnswer() %> "><%=b.getQnaTitle() %></a></b></td>
		<td><%=b.getQnaContent() %></td>
		<td><%=b.getId() %></td>
		<td><%=stDate %></td>
		
		<%

		count++; 
			}
	}
	
	%>
<%
if (count == 0) {
	%>
		<tr><td colspan="7">작성한 문의가 없습니다.</td></tr>		
	<%
}
System.out.println("현재 문의 " + count + "개");
%>



</table>
<br>
<div class="writebtn">
<c:if test="${sessionScope.sid ne null and sessionScope.sid ne 'admin' }">
<a href="Qnawrite.jsp"><button>글쓰기</button></a>
</c:if>
<a href="index.jsp"><button>HOME</button></a>
</div>

</div>
<%@ include file="footer.jsp" %>
</body>
</html>