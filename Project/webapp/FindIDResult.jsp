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
	String name = request.getParameter("name");
	String tel = request.getParameter("tel");
	     
	MemInfoDAO dao = new MemInfoDAO();
	String id = dao.findId(name, tel); //���̵� ��񿡼� ������..���н� ��
	 
%>

<form name="idsearch" method="post">
	<%
		if (id != null) {
	%>
	<div class= "container" style="text-align:center;">
		<div class="found-success">
			<h4> ȸ������ ���̵��</h4>
			<div class="found-id"><%=id %></div>
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