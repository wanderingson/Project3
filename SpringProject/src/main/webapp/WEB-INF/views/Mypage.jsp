<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="Header.jsp" %>
<%@ include file="Sidebar.jsp" %>     
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>


<style>

table{
	margin-left:auto;
	margin-right:auto; 
}

table th{
	text-align:left;
	height:70px;
	width:200px;
}

table tr td {
	height:70px;
	width: 400px;
}

</style>

</head>
<body>
	<section>
	<article class="card-body" style="max-width:800px; margin: auto;">
	
		<br>
		<h1 style="text-align: center;">회원정보</h1>
		<hr>
		<form method="post" action="memupdate.do">
		<table style="text-align:center">
			<tr>
				<td rowspan=2><img src="./img/profile.png" style="width:100px; height:100px;"></td>
				<th>회원등급</th>
				<td>${mv.gName }</td>
				<th>현재점수</th>
				<td>${mv.memPoint }점</td>
			</tr>
			<tr>
				<td colspan=4>
					<c:set var="gName" value="${mv.gName }"/> 
					<c:choose>
						<c:when test="${gName ne 'DIA' }">
							등급업까지 남은 점수 : ${nPoint } 점
						</c:when>
						<c:otherwise>최고등급입니다.</c:otherwise>
					</c:choose>	
				</td>
			</tr>			
		</table>
		
		<table>
			<tr>
				<th><label>아이디</label></th>
				<td><input type="text" class="form-control" name="userid" value="${mv.id }" maxlength=20 readonly></td>
			</tr>
			<tr>
				<th><label>현재 비밀번호</label></th>
				<td><input type="password" class="form-control" name="password0" id="pw0" maxlength=20 required></td>
			</tr>
			<tr>
				<th><label>새 비밀번호</label></th>
				<td><input type="password" class="form-control" name="password1" maxlength=20 id="pw" onkeyup="check_pw()"></td>
			</tr>
			<tr>
				<th><label>새 비밀번호 확인</label></th>
				<td><input type="password" class="form-control" name="password2" maxlength=20 id="pw2" onkeyup="check_pw()">&nbsp;<span id="check"></span></td>
			</tr>
			<tr>
				<th><label>이름</label></th>
				<td><input type="text" class="form-control" value="${mv.name }" name="name" maxlength=20
						disabled readonly></td>
			</tr>
			<tr>
				<th><label>이메일</label></th>
				<td><input type="email" class="form-control" value="${mv.email }"name="email" maxlength=20 readonly></td>
			</tr>
			<tr>
				<th><label>휴대폰</label></th>
				<td><input type="text" class="form-control" value="${mv.tel }"placeholder="휴대폰번호 입력('-' 포함)" name="tel" maxlength=20 id="tel" onkeyup="check_tel()" required>&nbsp;<span id="checkTel"></span></td>
			</tr>																
			<tr>
				<th><label>생년월일</label></th>
				<td><input type="text" class="form-control" value="${mv.birth }" name="birth" maxlength=20
							disabled readonly></td>
			</tr>
			<tr>
				<th><label>주소</label></th>
				<td>
				<input type="button" name="postnumber" value="우편번호찾기" onclick="daum_post()">
				<input type="text" name="post" value="${mv.address }" class="w-px60" readonly required />
				<input type="text" name="address1" value="${mv.address2 }" required/> <!-- 지번 or 도로명 주소 -->
				<input type="text" name="address2" value="${mv.address3 }"required/>  <!-- 상세주소 -->
				</td>
			</tr>										
		</table>
		
		<br><br>
        <div style="text-align: center;">
        	<input type="reset" class="btn btn-outline-primary btn-lg"  value="취소">           
        	<input type="submit" class="btn btn-primary btn-lg" name="updateCheck" onclick="updateCheck()" value="수정">
        </div>		
		</form>
	</article>
	</section>
	
	
	<script>
	 function check_pw(){
		 
		 
		 if(document.getElementById('pw').value !='' && document.getElementById('pw2').value!=''){
	         if(document.getElementById('pw').value==document.getElementById('pw2').value){
	             document.getElementById('check').innerHTML='비밀번호가 일치합니다.'
	             document.getElementById('check').style.color='blue';
	         }
	         else{
	             document.getElementById('check').innerHTML='비밀번호가 일치하지 않습니다.';
	             document.getElementById('check').style.color='red';
	         }
		 }
	 }		 
	</script>
	
	<script>
		function check_tel() {
			
			var reg = /^(01[016789]{1})-[0-9]{3,4}-[0-9]{4}$/;
			
			if(!reg.test(document.getElementById('tel').value)) {
				document.getElementById('checkTel').innerHTML='전화번호 형식에 맞게 입력해주세요.';
				document.getElementById('checkTel').style.color='red';
				
				if(document.getElementById('tel').value == '') {
					document.getElementById('tel').value="휴대폰번호 입력('-' 포함)";
					document.getElementById('checkTel').innerHTML='전화번호를 입력해주세요.';
				}
			}else{
				document.getElementById('checkTel').innerHTML='';
			} 
	
		}
	</script>
	
	
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>	<!-- 다음 우편번호 api -->
	<script>	
	//우편번호 검색
	function daum_post() {
	    new daum.Postcode({
	        oncomplete: function(data) {
				$('[name=post]').val( data.zonecode );	//우편번호
	            //지번 주소 : J, 도로명 주소 : R
	            var address = data.userSelectedType == 'J' ? data.jibunAddress : data.roadAddress;	//클릭한 지번주소나, 도로명주소가 저장됨
	            if(data.buildingName != '') {
					address += ' (' + data.buildingName + ')';	//건물 명이 있으면 건물 명을 붙여줌
	            }
	            $('[name=address1]').eq(0).val( address );
	        }
	    }).open();
	}
	</script>
	
	<script>
	$(document).ready(function() {
		$(document).on("click", "input[name='updateCheck']", function() {
			var pw = document.getElementById('pw0').value;
			var dbpw = ${mv.pw}
			
			var reg = /^(01[016789]{1})-[0-9]{3,4}-[0-9]{4}$/; // 전화번호 010-0000-0000 형식
			
			if(pw == "" || pw != dbpw) { // 현재 비밀번호 확인
				
				alert("현재 비밀번호를 정확히 입력해주세요");
				document.getElementById('pw0').select();
				return false;
				
			}else if(document.getElementById('pw').value != document.getElementById('pw2').value) { // 새 비밀번호 일치하지 않을 때
				
				alert("새 비밀번호를 다시 확인해주세요");
				document.getElementById('pw').select();
				return false;
				
			}else if(!reg.test(document.getElementById('tel').value)) {
				if(document.getElementById('tel').value == "") {
					alert("전화번호를 입력해주세요");	
				}else {
					alert("전화번호를 형식에 맞게 입력해주세요")	
				}
				document.getElementById('tel').select();
				return false;
			
			} else if(document.getElementById('post').value == "" || document.getElementById('address1').value == "" || document.getElementById('address2').value == "") {
				alert("주소를 확인해주세요");
				return false;
			}else{
				
				document.getElementById("meminfo").submit();
			}
		});
	})	;
	</script>
	
</body>
</html> 