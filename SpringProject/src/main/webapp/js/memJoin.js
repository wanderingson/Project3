   

   

//우편번호 검색
function daum_post() {
    new daum.Postcode({
        oncomplete: function(data) {
			$('[name=address]').val( data.zonecode );	//우편번호
            //지번 주소 : J, 도로명 주소 : R
            var address0 = data.userSelectedType == 'J' ? data.jibunAddress : data.roadAddress;	//클릭한 지번주소나, 도로명주소가 저장됨
            if(data.buildingName != '') {
				address0 += ' (' + data.buildingName + ')';	//건물 명이 있으면 건물 명을 붙여줌
            }
            $('[name=address2]').eq(0).val( address0 );
        }
    }).open();
}



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
       
       if(document.getElementBy


('tel').value == '') { 
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
	$("#id1").on("keyup",function() {
		var id1 = $('#id1').val();
		$.ajax({
	        type: "post",
	        url: "idcheck.do",
	        datatype : "json",
	        data : { id : id1},
	        success: function(result) {
	        	
	        	var text1 = result.check;
	        	
	        	/* alert(text1); */
				if(text1 == "I"){
					document.getElementById('idtext').innerText = "아이디를 입력해주세요";
					document.getElementById('idtext').style.color='black';
				}else if(text1 == "Y"){
					document.getElementById('idtext').innerText = "아이디 생성이 가능합니다";
					document.getElementById('idtext').style.color='green';
				}else if(text1 == "N"){
					document.getElementById('idtext').innerText = "이미 있는 아이디 입니다";
					document.getElementById('idtext').style.color='red';
				}	        	

	
	        },

	        error: function(request,status,error){
	        	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	        }

	    });

	});	
}); 
	  



$(document).ready(function() {
   $(document).on("click", "button[name='joinCheck']", function() {
      
      var reg = /^(01[016789]{1})-[0-9]{3,4}-[0-9]{4}$/; // 전화번호 010-0000-0000 형식
      var reg0 = /^[a-z0-9]*$/;
      
      if(document.getElementById('id1').value ==""){
    	  
    	  alert("아이디를 입력해주세요");
    	  return false;
      
      }else if(document.getElementById('id1').value.length < 4 ){
    	  
    	  alert("아이디는 4글자 이상 입력해주세요");
    	  return false;    	 
    	  
      }else if(!reg0.test(document.getElementById('id1').value)){
    	  
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
      
      } else if(document.getElementById('address').value == "" || document.getElementById('address2').value == "" || document.getElementById('address3').value == "") {
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



