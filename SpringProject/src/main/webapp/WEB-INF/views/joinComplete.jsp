<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="Header.jsp" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 완료</title>

<style type="text/css">

h1{ text-align: center; }

div{ text-align: center; }

</style>
</head>
<body>

<section>
   <article class="card-body" style="max-width:800px; margin: auto;">
   <br>
   <h1>가입완료</h1>
	<hr><br>
	<div><img src="./img/check.png" style="width:100px; height:100px;"></div>
	<br>
	<div>
		<h4> 회원가입이 완료되었습니다!</h4>
		<h4> 배고플땐의 회원이 되어주셔서 감사합니다.</h4>
	</div>
	<br><br>
	<div style="text-align: center;">
		<a class="btn btn-primary btn-lg" href="loginpage.do" role="button">로그인하기</a>
		<a class="btn btn-secondary btn-lg" href="index.do" role="button">메인으로</a>           		
	</div>

	</article>
</section>

</body>
</html>