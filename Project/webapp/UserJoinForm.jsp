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
           <form method = "post" action="memInsert.do" id="form1" name="form1"> 
           <table>
           <tr>
               <th class="idlabel"><label>* 아이디</label></th>
               <td>
               	<div class="row g-2">
               		<div class=" col-lg-12">
               			<input type ="text" class="form-control" placeholder="사용할 아이디를 입력해주세요" id="check" name ="id" 
               			 minlength="4" required autocomplete="off">	<!-- 영문대소문자,숫자입력 가능 -->
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
               	name ="password" pattern="^[a-zA-Z0-9]+$" minlength="6"  maxlength='20' id="pw" onkeyup="check_pw()">
               	<p class="pattern">영문 대소문자 또는 숫자만 입력가능</p>
               	</td>
               	
           </tr>
           <tr>
               <th class="idlabel"><label>* 비밀번호 확인</label></th>		
               <td><input type ="password" class="form-control" placeholder="비밀번호를 한번 더 입력해주세요" 
               	name ="password2" pattern="^[a-zA-Z0-9]+$" maxlength='20' id="pw2" onkeyup="check_pw()"> <span id="checkpw"></span>
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
                			name ="email" minlength=5; maxlength="30" id=email onkeyup="check_email()" autocomplete="off">
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
				<input type="text" id="post" name="post"  class="w-px60" placeholder="우편번호찾기 클릭" required autocomplete="off"/>
				<input type="text" id="address1" name="address1" placeholder="지번/도로명 주소" required autocomplete="off"/> <!-- 지번 or 도로명 주소 -->
				<input type="text" id="address2" name="address2" placeholder="상세주소 입력" required autocomplete="off"/>  <!-- 상세주소 -->
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



//비밀번호 확인
function check_pw(){

   if(document.getElementById('pw').value !='' && document.getElementById('pw2').value!=''){
        if(document.getElementById('pw').value==document.getElementById('pw2').value){
            document.getElementById('checkpw').innerHTML='비밀번호가 일치합니다.'
            document.getElementById('checkpw').style.color='blue';
        }
        else{
            document.getElementById('checkpw').innerHTML='비밀번호가 일치하지 않습니다.';
            document.getElementById('checkpw').style.color='red';
        }
   }
}

//전화번호 형식 확인
function check_tel() {
    
    var reg = /^(01[016789]{1})-[0-9]{3,4}-[0-9]{4}$/; //전화번호 형식 정규식
    
    if(!reg.test(document.getElementById('tel').value)) {
       document.getElementById('checkTel').innerHTML='전화번호 형식에 맞게 입력해주세요.';
       document.getElementById('checkTel').style.color='red';
       
       if(document.getElementById('tel').value == '') { 
          document.getElementById('checkTel').innerHTML='전화번호를 입력해주세요.';
       }
    }else{
       document.getElementById('checkTel').innerHTML='';
    } 

 }

//이메일 형식 확인
function check_email() {
    
    var reg2 = /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/; //이메일 형식 정규식
    
    
    if(!reg2.test(document.getElementById('email').value)) {
       document.getElementById('checkMail').innerHTML='이메일 형식에 맞게 입력해주세요.';
       document.getElementById('checkMail').style.color='red';
       
       if(document.getElementById('email').value == '') { 
          document.getElementById('checkMail').innerHTML='이메일을 입력해주세요.';
       }
    }else{
       document.getElementById('checkMail').innerHTML='';
    } 

 }

//이름 형식 확인
function check_name() {
    
    var reg3 = /^[가-힣]+$/;  //한글만 입력하는 정규식
    
    
    if(!reg3.test(document.getElementById('name').value)) {
       document.getElementById('checkName').innerHTML='한글만 입력해주세요';
       document.getElementById('checkName').style.color='red';
       
       if(document.getElementById('name').value == '') { 
          document.getElementById('checkName').innerHTML='이름을 입력해주세요.';
       }
    }else{
       document.getElementById('checkName').innerHTML='';
    } 

 }
	



$(document).ready(function() {
	$("#check").keyup(function() {
		var id1 = $('#check').val();
		$.ajax({
	        type: "get",
	        url: "idchek.jsp",
	        data : { id : id1},
	        success: function(data) {
	        	
	        	if(id1 == ""){
	        		$('#idtext').text("아이디를 입력해주세요");	
	        	}
	        	else{
	        		$('#idtext').text(data);
	        		$('#hiddenid').val(data);
	        	}

	        },

	        error: function(){
	        	alert('error');
	        }

	    });

	});	
}); 
	  
</script>

<script>
$(document).ready(function() {
   $(document).on("click", "button[name='joinCheck']", function() {
      
      var reg = /^(01[016789]{1})-[0-9]{3,4}-[0-9]{4}$/; // 전화번호 010-0000-0000 형식
      var reg0 = /^[a-z0-9]*$/;
      
      if(document.getElementById('check').value ==""){
    	  
    	  alert("아이디를 입력해주세요");
    	  return false;
      
      }else if(document.getElementById('check').value.length < 4 ){
    	  
    	  alert("아이디는 4글자 이상 입력해주세요");
    	  return false;    	  
    	  
      }else if(!reg0.test(document.getElementById('check').value)){
    	  
    	  alert("아이디는 영문소문자 또는 숫자만 입력가능합니다");
    	  return false;    	  
    	  
      }else if(document.getElementById('pw').value == ""){
    	  
    	  alert("비밀번호를 입력해주세요");
    	  return false;    	  
    	  
      }else if(document.getElementById('pw').value.length < 6 ){
    	  
    	  alert("비밀번호는 6글자 이상 입력해주세요");
    	  return false;    	  
    	  
      }else if(document.getElementById('pw2').value ==""){
    	  
    	  alert("비밀번호 확인칸을 입력해주세요");
    	  return false;    	  
    	  
      }else if(document.getElementById('pw').value != document.getElementById('pw2').value) { // 현재 비밀번호 확인
          
          alert("비밀번호를 정확히 입력해주세요");
          document.getElementById('pw').select();
          return false;
                      
       }else if(document.getElementById('name').value ==""){
    	  
    	  alert("이름을 입력해주세요");
    	  return false;    	  
    	  
      }else if(document.getElementById('email').value ==""){
    	  
    	  alert("이메일을 입력해주세요");
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
         
      }else if(document.getElementById('birth').value ==""){
    	  
    	  alert("생년월일을 입력해주세요");
    	  return false;    	  
    	  
      }else{
         alert("회원가입이 완료되었습니다");
         document.getElementById("form1").submit();
      }
   });
})   ;


</script>


 


</body>
</html>