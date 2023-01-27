<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">


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
	<h3 style="text-align:center;">비밀번호 찾기</h3>
	<form class="form-control" method="post" action="FindPWResult.do">
		<table style="text-align:center;">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" maxlength="10" placeholder="아이디를 입력해주세요." autofocus required></td>
			</tr>		
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" maxlength="10" placeholder="이름을 입력해주세요." required></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="tel" maxlength="20" placeholder="휴대폰번호 입력('-' 포함)" required></td>			
			</tr>
			
		</table>
		<div style="text-align:center;">
			<input type="submit" value="비밀번호 찾기">
		</div>
	</form>
</div>



</body>
</html>