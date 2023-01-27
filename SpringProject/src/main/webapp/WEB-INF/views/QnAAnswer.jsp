<%@page import="java.util.List"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${qnaview.qnaTitle } - 게시판</title>
<%@include file="Header.jsp" %>
<style>
* {
	margin: 4px 0;
}

.controller {
	padding: 25px 0;
	margin: auto;
	width: 800px;
}

#qnaTitle {
	text-align: center;
	background-color: rgb(100, 100, 100);
	width: 800px;
	height: 50px;
	padding: 12px 0;
	color: white;
}

table {
	width: 800px;
	margin: 25px 0;
	padding: 20px;
	border-collapse: collapse;
}

tr {
	height: 40px;
}

#content {
	width: 800px;
	height: 400px;
	text-align: left;
}

.btn1 {
	width: 100px;
	padding: 5px 12px;
	border: none;
	background-color: gray;
	color: white;
}

.btn2 {
	padding: 5px 12px;
	background-color: white;
	border-color: gray;
	border-width: 1px;
}

</style>
</head>
<body>
	<div class="controller">
		<div id="qnaTitle">
			<b>게시글 보기</b>
		</div>
					<form action="answer.do" method=post>
				<input type=hidden name="qnaId" value=${param.qnaId }>
		
		<table>
			<tr>
				<th colspan="3" align="left"><h3>${param.qnaTitle }</h3></th>
			</tr>
			<tr>
				<td width="30%">카테고리 : ${param.qnaCategory }</td>
				<td width="30%">작성자 : ${param.memId }</td>
				<td width="30%" align="right">${param.qnaDate }</td>
			</tr>
			<tr id="content" valign="top" style="border-top-color: rgb(100, 100, 100); border-top-width: 1px">
				<td colspan="3">${param.qnaContent }</td>
			</tr>
			
				<tr>
					<td>답변</td>
				</tr>
				<tr>
					<td colspan="3"><textarea rows="10" cols="70" style="resize:none;"
							name="qnaAnswer" required></textarea></td>
				</tr>
				<tr>
				<td>
					<input type=submit value="작성">
				</td>
				</tr>
			</table>
							</form>
				
				<div id="btnCon">
			<a href="QnA.do">
				<button class="btn2">목록</button>
			</a>
		</div>
		<div>
			<a href="index.do">
				<button class="btn2">홈으로</button>
			</a>
		</div>
		</div>
	
	<%@include file="footer.jsp" %>
</body>
</html>
</body>
</html>