<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>welcome</title>

</head>
<body>
<%@ include file = "Header.jsp"%>

   <section>
   <article class="card-body" style="max-width:800px; margin: auto;">
	<br>
	<h2 align="center">배고플땐</h2>
	<br><hr><br>	
	<div class="container">
		<div class="col-6 mx-auto">
			<form class="form-control" action="login.do" method="post">
				<label for="userId" class="form-label">아이디</label>
				<input type="text" name="id" id="userId" class="form-control" autocomplete="off">
				<label for="password" class="form-label">비밀번호</label>
				<input type="password" name="pw" id="password" class="form-control" >
				<div class="d-grid">
					<button class="btn btn-primary btn-block my-3">로그인</button>
				</div>
			</form>
		</div>
	</div>
	<br>
	<div style="text-align:center;">
		<a href="#" onclick="findid()">아이디 찾기</a>&nbsp;&nbsp;
		<a href="#" onclick="findpw()">비밀번호 찾기</a>
	</div>
	</article>
	</section>

<script>
function findid(){
	  //새창 만들기
	  window.open("FindIDForm.do", "아이디 찾기", "width=400, height=250");
	}
	
function findpw(){
	  //새창 만들기
	  window.open("FindPWForm.do", "비밀번호 찾기", "width=400, height=250");
	}	
</script>
	
</body>
</html>
