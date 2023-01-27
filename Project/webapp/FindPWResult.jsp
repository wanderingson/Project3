<%@page import="memberdb.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
	request.setCharacterEncoding("UTF-8");
	
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String tel = request.getParameter("tel");
	     
	MemInfoDAO dao = new MemInfoDAO();
	String pw = dao.findPw(id,name, tel); //아이디를 디비에서 가져옴..실패시 널
	 
%>

<form name="pwsearch" method="post">
	<%
		if (pw != null) {
	%>
	<div class= "container" style="text-align:center;">
		<div class="found-success">
			<h4> 회원님의 비밀번호는</h4>
			<div class="found-id"><%=pw %></div>
			<h4> 입니다 </h4>
		</div>
		<div>
			<input type="button" value="확인" onclick="window.close()">
		</div>
	</div>
	<%
		} else {
	 %>
	 <div class="container" style="text-align:center;">
	 	<div class="found-fail">
	 		<h4>등록된 정보가 없습니다</h4>
	 	</div>
		<div>
			<input type="button" value="확인" onclick="window.close()">
		</div>	 		 
	 </div>
	 <% 
		}
	 %>	
</form>

</body>
</html>