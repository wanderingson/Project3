<%@page import="memberdb.MemInfoVO"%>
<%@page import="memberdb.MemInfoDAO"%>

<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 확인</title>
</head>
<body>
	<%
		MemInfoDAO midao = new MemInfoDAO();
		ArrayList<MemInfoVO> miArray = new ArrayList<>();
		miArray = midao.getAllInfo();
	%>
	
	<table border=2>
		<caption>회원정보</caption>
		<tr>
			<th>이름</th>
			<th>ID</th>
			<th>전화번호</th>
			<th>우편번호</th>
			<th>주소</th>
			<th>상세주소</th>
			<th>생년월일</th>
			<th>회원등급</th>
			<th>등급포인트</th>
		</tr>
		<% for(MemInfoVO imsi : miArray ) { %>
		<tr>
			<td>
				<%=imsi.getName() %>
			</td>
			<td>
				<a href="memInfo.jsp?mem_id=<%=imsi.getId() %>">
				<%=imsi.getId()%>
				</a>
			</td>
			<td>
				<%=imsi.getTel() %>
			</td>
			<td>
				<%=imsi.getAddress() %>
			</td>
			<td>
				<%=imsi.getAddress2()%>
			</td>
			<td>
				<%=imsi.getAddress3() %>
			</td>
			<td>
				<%=imsi.getBirth() %>
			</td>
			<td>
				<%=imsi.getgName() %>
			</td>
			<td>
				<%=imsi.getMemPoint() %>
			</td>
		</tr>
		<% } %>
	</table>
	<a href="AdminSideBar.jsp">[홈으로]</a>
</body>
</html>