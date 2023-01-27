
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>

<form name="pwsearch" method="post">

	<c:choose>
	<c:when test="${pw!=null}"> 
	<div class= "container" style="text-align:center;">
		<div class="found-success">
			<h4> 회원님의 비밀번호는</h4>
			<div class="found-id">${pw}</div>
			<h4> 입니다 </h4>
		</div>
		<div>
			<input type="button" value="확인" onclick="window.close()">
		</div>
	</div>
	</c:when>
	<c:otherwise>
	 <div class="container" style="text-align:center;">
	 	<div class="found-fail">
	 		<h4>등록된 정보가 없습니다</h4>
	 	</div>
		<div>
			<input type="button" value="확인" onclick="window.close()">
		</div>	 		 
	 </div>
	 </c:otherwise> 
  </c:choose>  
</form>

</body>
</html>