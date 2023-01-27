<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link rel="stylesheet" href="css/bootstrap.css">

<style>

h3 {margin: 20px 10px}

table{
	margin-left:auto;
	margin-right:auto;
}

table tr td {
	text-align: left;
	height:50px;
	width: 250px;
}


</style>
</head>
<body>

<div>
	<h3 style="text-align:center;"><b>아이디 찾기</b></h3>
	
	<form class="form-control" method="post" action="FindIDResult.do">
		<table style="text-align:center;">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" maxlength="10" placeholder="이름을 입력해주세요." autofocus required></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="tel" maxlength="20"  placeholder="휴대폰번호 입력('-' 포함)" required></td>			
			</tr>
		</table>
		<br>
		<div style="text-align:center;">
			<input type="submit" value="아이디찾기">
		</div>
	</form>
</div>



</body>
</html>