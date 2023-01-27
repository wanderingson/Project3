<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
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
		<c:forEach var="imsi" items="${mvlist}">
		<tr>
			<td>
				${imsi.name }
			</td>
			<td>
				<a href="getmeminfo.do?mem_id=${imsi.id }">
				${imsi.id }
				</a>
			</td>
			<td>
				${imsi.name }
			</td>
			<td>
				${imsi.address }
			</td>
			<td>
				${imsi.address2 }
			</td>
			<td>
				${imsi.address3 }
			</td>
			<td>
				${imsi.birth }
			</td>
			<td>
				${imsi.gName }
			</td>
			<td>
				${imsi.memPoint }
			</td>
		</tr>
		</c:forEach>
	</table>
	<a href="adminsidebar.do">[홈으로]</a>
</body>
</html>