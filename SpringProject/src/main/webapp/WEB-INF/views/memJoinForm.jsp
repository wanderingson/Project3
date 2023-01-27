<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="Header.jsp" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

.idcss{margin: 0px;}
.idlabel{ vertical-align: top;}
h1{ text-align: center; }

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
	text-align: left;
	height:70px;
	width: 400px;
}

.pattern{
	text-align: right;
	font-size: 5px;
	color: red; 
}


		
			
</style>

</head>
<body>


   <section>
   <article class="card-body" style="max-width:800px; margin: auto;">
   
      
           <h1>회원가입</h1>
           <p class="w-pct60 right" style="margin: 0 auto; padding-bottom: 5px; font-size: 13px; text-align: right;">*는 필수 입력 항목입니다.</p>
           <form action="/shop/memberInsert.do" id="form1" name="form1"> 
           <table>
           <tr>
               <th class="idlabel"><label>* 아이디</label></th>
               <td>
               	<div class="row g-2">
               		<div class=" col-lg-12">
               			<input type ="text" class="form-control" placeholder="사용할 아이디를 입력해주세요" id="id1" name ="id" 
               			 minlength="4" required autocomplete="off">	<!-- 영문대소문자,숫자입력 가능 --> <!-- id=check => id=id -->
               			<p id="idtext" class="idcss">아이디를 입력해주세요</p>
               			<p class="pattern">영문 소문자 또는 숫자만 입력가능</p>
               			<input type="hidden" name="idtexth" id="hiddenid">
               		</div>
               		<!-- <div class=" col-lg-4">
               			<input type="button" class="form-control" name="user_IDcheck" value="중복확인" onclick="winopen()">
               		</div> -->
               	</div>
               </td>	
           </tr>
           <tr>
               <th class="idlabel"><label>* 비밀번호</label></th>		
               <td><input type ="password" class="form-control" placeholder="비밀번호를 입력해주세요" 
               	name ="pw" pattern="^[a-zA-Z0-9]+$" minlength="6"  maxlength='20' id="pw" onkeyup="check_pw()">
               	<p class="pattern">영문 대소문자 또는 숫자만 입력가능</p>
               	</td>
               	
           </tr>
           <tr>
               <th class="idlabel"><label>* 비밀번호 확인</label></th>		
               <td style="vertical-align: top;">
                 <input type ="password" class="form-control" placeholder="비밀번호를 한번 더 입력해주세요" 
               	  name ="pw2" pattern="^[a-zA-Z0-9]+$" maxlength='20' id="pw2" onkeyup="check_pw()"> 
               	  <span id="checkpw"></span>
               </td>		
           </tr>
           <tr>
           	   <th class="idlabel"><label>* 이름</label></th>
               <td><input type ="text" class="form-control" placeholder="이름을 입력해주세요" 
               	id="name" name ="name" maxlength='20' onkeyup="check_name()" required autocomplete="off"><span id="checkName"></span>
               	<p class="pattern">한글만 입력가능</p></td>
               	
           </tr>
           <tr>
               <th><label>* 이메일</label></th>
               <td>
 
               			<input type ="email" class="form-control" placeholder="예)market@market.com" 
                			name ="email" minlength=5; maxlength="30" id="email" onkeyup="check_email()" autocomplete="off">
                			<span id="checkMail"></span>
               		
               </td> 
           </tr>
           <tr>
               <th><label>* 전화번호</label></th>
               <td><input type ="tel" class="form-control" placeholder="휴대폰번호 입력('-' 포함)" 
                name ="tel" maxlength='20' id="tel" onkeyup="check_tel()" autocomplete="off"><span id="checkTel"></span>
                </td>
           </tr>
           <tr>
               <th><label>* 주소</label></th>
               <td>
 				<input type="button" name="postnumber" value="우편번호찾기" onclick="daum_post()">
				<input type="text" id="address" name="address"  class="w-px60" placeholder="우편번호찾기 클릭" required autocomplete="off"/>
				<input type="text" id="address2" name="address2" placeholder="지번/도로명 주소" required autocomplete="off"/> <!-- 지번 or 도로명 주소 -->
				<input type="text" id="address3" name="address3" placeholder="상세주소 입력" required autocomplete="off"/>  <!-- 상세주소 -->
				</td>              
           </tr>                      
           <tr>
           	    <th><label>* 생년월일</label></th>
           	    <td><input type="date" class="form-control" id="birth" name="birth" maxlength='20' required autocomplete="off"></td>     		
           </tr>
           </table>
           <br><br>
           <div style="text-align: center;">           
           	<!-- <input type="submit" class="btn btn-primary btn-lg" value="회원가입"> -->
           	<button type="button" class="btn btn-primary btn-lg" name="joinCheck" style="margin-bottom: 100px;">회원가입</button>
           </div>
       </form>
   </article>    
   </section>
<script src="./js/memJoin.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>	<!-- 다음 우편번호 api -->
</body>
</html>