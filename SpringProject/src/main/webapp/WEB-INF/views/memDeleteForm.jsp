<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="Header.jsp" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style>
article{
		text-align:center;
		}
h6{
	text-align: center;
	}
	
table{
	margin-left:auto; 
	margin-right:auto;
}	
	
table th{
	text-align:left;
	height:50px;
	width:200px;
}

table tr td {
	text-align: left;
	height:50px;
	width: 400px;
}

div{
	height:50px;
	text-align:left;
}
		
</style>


</head>
<body>

   <div>
   <article class="card-body" style="max-width:700px; margin: auto;">
       <form action="/shop/memberDelete.do"> 
           <h1  style="text-align: center;">회원탈퇴</h1>
           <hr>
           
			<h6>계정을 삭제하려는 이유를 말씀해주세요.</h6> 
			<h6>제품개선에 중요자료로 활용하겠습니다.</h6>
			<br><br>
			         
			<table>
				<tr><td>
				<div class="form-check">
			  		<input class="form-check-input" type="radio" name="radioselect" id="radioselect1">
			  		<label class="form-check-label" for="flexCheckDefault">
			    	고객서비스(상담,포장 등) 불만	
			  		</label>
			  	</div>
			  	</td></tr>	
				<tr><td>
				<div class="form-check">
			  		<input class="form-check-input" type="radio" name="radioselect" id="radioselect2" checked >
			  		<label class="form-check-label" for="flexCheckChecked">
			    		방문빈도가 낮음
			  		</label>
			  	</div>
				</td></tr>
				<tr><td>
				<div class="form-check">
			  		<input class="form-check-input" type="radio" name="radioselect" id="radioselect3" >
			  		<label class="form-check-label" for="flexCheckDefault">
			    		배송 불만
			  		</label>
			  	</div>	
				</td></tr>
				<tr><td>
				<div class="form-check">
			  		<input class="form-check-input" type="radio" name="radioselect" id="radioselect4" >
			  		<label class="form-check-label" for="flexCheckDefault">
			    		상품 가격 불만
			  		</label>
			  	</div>
				</td></tr>
				<tr><td>	
				<div class="form-check">
			  		<input class="form-check-input" type="radio" name="radioselect" id="radioselect5">
			  		<label class="form-check-label" for="flexCheckDefault">
			    		교환/환불/반품 불만
			  		</label>
			  	</div>
				</td></tr>
				<tr><td>
				<div class="form-check">
			  		<input class="form-check-input" type="radio" name="radioselect" id="radioselect6" >
			  		<label class="form-check-label" for="flexCheckDefault">
			    		쇼핑 기능 불만
			  		</label>
				</div>
				</td></tr>
			</table>	

			
			<br><br>
			
			<h6 style="color:red;"> 계정을 삭제하면 회원님의 모든 컨텐츠와 활동기록등이 삭제됩니다</h6>
			<h6 style="color:red;"> 삭제 후 복구할수 없으니 신중하게 결정해주세요</h6>
			<br><br>
 			<input type="hidden" name="id" value="${sessionScope.sid}"/>
 			
			<table>
			<!-- <tr>
				<th><label>아이디</label></th>
				<td><input type ="text" class="form-control" placeholder="아이디를 입력해주세요" 
               	name ="id" maxlength='20' required autocomplete="off"></td>
            </tr> -->
            <tr>
            	<th><label>비밀번호</label></th>
            	<td><input type ="password" class="form-control" placeholder="비밀번호를 입력해주세요" 
               	name ="pw" maxlength='20' required autocomplete="off"></td>
            </tr>   	   	
			</table>          
           
           <br><br><br>
           
           <div style="text-align : center;">
           <input type="reset" class="btn btn-outline-primary btn-lg" value="취소">           
           <input type="submit" class="btn btn-primary btn-lg" value="탈퇴">
           </div>
                      
       </form>
   </article>    
   </div>

</body>
</html>