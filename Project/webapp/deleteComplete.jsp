<%@page import="memberdb.MemInfoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ include file="Header.jsp" %>    --%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴 완료</title>

<style type="text/css">

h1{ text-align: center; }

div{ text-align: center; }

</style>


</head>
<body>

<%//한글처리 & 받아온 파라미터 변수화
request.setCharacterEncoding("UTF-8");
String id = session.getAttribute("sid").toString();
String password = request.getParameter("password");

//MemberDAO객체생성 -> 전달받은 정보 모두 저장
MemInfoDAO mdao = new MemInfoDAO();

int result = mdao.delete_mem(id,password);
if (result == 0){//아이디, 비밀번호 정보 일치할 경우
	
session.invalidate(); //세션삭제	
%>


<section>
   <article class="card-body" style="max-width:800px; margin: auto;">
   <br>
   <h1>회원탈퇴 완료</h1>
	<hr><br>
	<div><img src="./img/check.png" style="width:100px; height:100px;"></div>
	<br>
	<div>
		<h4> 회원탈퇴가 완료되었습니다.</h4>
	</div>
	<br><br>
	<div style="text-align: center;">
		<a class="btn btn-secondary btn-lg" href="index.jsp" role="button">메인으로</a>           		
	</div>

	</article>
</section>

<%	
}else{
%>

<script>
	alert("해당 아이디 또는 비밀번호가 존재하지 않습니다.")
	history.back();
</script>
	
<%
}
%>


</body>
</html>