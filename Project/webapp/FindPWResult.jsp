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
	String pw = dao.findPw(id,name, tel); //���̵� ��񿡼� ������..���н� ��
	 
%>

<form name="pwsearch" method="post">
	<%
		if (pw != null) {
	%>
	<div class= "container" style="text-align:center;">
		<div class="found-success">
			<h4> ȸ������ ��й�ȣ��</h4>
			<div class="found-id"><%=pw %></div>
			<h4> �Դϴ� </h4>
		</div>
		<div>
			<input type="button" value="Ȯ��" onclick="window.close()">
		</div>
	</div>
	<%
		} else {
	 %>
	 <div class="container" style="text-align:center;">
	 	<div class="found-fail">
	 		<h4>��ϵ� ������ �����ϴ�</h4>
	 	</div>
		<div>
			<input type="button" value="Ȯ��" onclick="window.close()">
		</div>	 		 
	 </div>
	 <% 
		}
	 %>	
</form>

</body>
</html>