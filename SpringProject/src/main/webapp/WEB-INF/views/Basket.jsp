
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ include file = "Header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	#cartList {  width:100%; border:1px solid; align:center; }
	#cartList th,
	#cartList td { padding:5px 12px; text-align:center;} /* border:1px solid #ccc; */
	#cartList th { background:#eee; }
	.up { background-color:transparent; border:0px; }
	.down { background-color:transparent; border:0px; }
	
	#orderInfo { width:100%; text-align:center; align:center; background-color:#eee; }
	.img1{width: 10px; height: 10px;}
</style>

<script> 
 $(function name() {
	$('#sendmenu').click(function(){
		var total = ${total};
		if(total == null) {
			alert("장바구니가 비어있습니다");
		}else{
			location.href="orderform.do?id=${sessionScope.sid}";	
		}
		  	  
	});	
})
 

// 장바구니 + - 버튼 
 	function count(type)  {
	var ss = "";
	var memid = '${sessionScope.sid}';
	<c:forEach items="${allc}" var="all">
		if(type == '${all.name},plus'){
			ss = "plus";
			
		}
		else if(type == '${all.name},minus'){
			ss="minus";
		}
	</c:forEach>
		 if(ss == 'plus') {
			 var plus11 = type.split(',');
			 var add = plus11[0]+"plus";
			 var total = plus11[0]+"onet";
			 var pr = plus11[0]+"price";
	    
			 var res1 = document.getElementById(add);
			 var res2 = document.getElementById(pr);
			 var res3 = document.getElementById(total);
			 
			 var productprice = res2.innerText;
			 const cut1 = productprice.split(" ");
			 
			 const pr2 = Number(cut1[0]);
			 
			 
			 
			 let number = res1.innerText;
			 
			 $.ajax({
				 	url      : "BPlus.do",
			        type     : 'post',
			        dataType : "json",
			        data     : { name:add,
			        			id : memid,
				 				num : number
			        },
			        success  : function(result) {
			        	
			        	res1.innerText = result.number;
			        	res3.innerText = pr2*result.number+' 원';
			       		
			        	document.getElementById('alltotal').innerText = result.alltotal+' 원';
				        document.getElementById('dc').innerText = result.dc+' 원'
				        document.getElementById('totaldc').innerText = result.totaldc+' 원' 
				        document.getElementById('tpoint').innerText = result.alltotal * 1/100+' 점'
	                        },
			        error    : function(request, status, error){
			        	alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			        	alert("오류");
			        }
			    });
	    }else if(ss == 'minus')  {
	    	
	    	
	    	var minus11 = type.split(',');
	    	var add = minus11[0]+"plus";
	    	var total = minus11[0]+"onet";
			var pr = minus11[0]+"price";
	    
			var res1 = document.getElementById(add);
			var res2 = document.getElementById(pr);
			var res3 = document.getElementById(total);
			 
			var productprice = res2.innerText;
			const cut1 = productprice.split(" ");
			 
			const pr2 = Number(cut1[0]);
	    	
			let number = res1.innerText;

			if(number > 1)	{	
			
	    	$.ajax({
	    		url      : "BMinus.do",
		        type     : 'post',
		        dataType : "json",
		        data     : {name:add,
		        			id : memid,
	    					num : number
		        },
		        success  : function(result) {
		        	res1.innerText = result.number;
		        	res3.innerText = pr2*result.number+' 원';
		       		
		        	document.getElementById('alltotal').innerText = result.alltotal+' 원';
			        document.getElementById('dc').innerText = result.dc+' 원'
			        document.getElementById('totaldc').innerText = result.totaldc+' 원' 
			        document.getElementById('tpoint').innerText = result.alltotal * 1/100+' 점'
		                        },            
		        error    : function(request, status, error){
		        	alert("오류");
		        }
		    });
		  }	
			else{
				res1.innerText = '1';
			}
	     }
	   }

	  
  
  function delete1(del) {
		  var ss = "";
	<c:forEach items="${allc}" var="all">
		if(del == '${all.name}'){
			ss = "delete";
		}
	</c:forEach>
	var memid = '${sessionScope.sid}';
	if(ss == "delete"){
	  	$.ajax({
  			url      : "BDelte.do",
	        type     : 'post',
	        data     : {name : del ,
	        			id : memid },
			success  : function(result) {
	        		alert(result.delete1)
	        		document.location.reload();
			},
			error    : function(request, status, error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	        }
			
	        
  		});
	}
  }


  $('#alldel').click(function(){
	  alert("장바구니 내역 전체삭제")
	  
  });

	  
</script>




<title>장바구니</title>
</head>
<body>


	
	<hr><br>
	
	<h1 align="center">장바구니 목록</h1>
	
	<br><br>
	  <div class="container">
		<table id="cartList" align="center">
		  <tr>
			<th colspan=2 style="border-right:none">상품명</th>
			<th>가격</th>
			<th>수량</th>
			<th>Delivery</th>
			<th>총가격</th>
			<th>주문관리</th>
		  </tr>
			
			
		<c:forEach items="${allc}" var="all">
		  <tr>
			<td>
			  <img src="./img/${all.name}.jpg" alt="이미지x" class="img1">
			</td>
			<td>${all.name}</td>
			<td id="${all.name}price">${all.price1} 원</td>
			<td class=cntUpdate>
			  <button class="btn btn-light" onclick='count("${all.name},minus")' >-</button>
                <span id="${all.name}plus">${all.num}</span>
              <button class="btn btn-light" onclick='count("${all.name},plus")'>+</button>
			</td>
			<td>무료배송</td>
			<td id="${all.name}onet">${all.price1*all.num} 원</td>
			<td> 
			  <button type="button" onclick='delete1("${all.name}")'
			  class="btn btn-secondary" style="font-size: 12px; width: 100px;height: 40px;">
			  장바구니 삭제
			  </button>
			</td> 
		  </tr>
		</c:forEach>
		</table>
		<div align="right" style="padding-top: 10px; padding-bottom: 10px;">			
		  <a href="AllBDel.do?id=${sessionScope.sid}" id="alldel" class="btn btn-dark" style=" font-size: 15px;">
		    장바구니 전체삭제
		  </a>
		</div>
		<table id="orderInfo" border=0 align="center">
			<tr>
				<th>총 상품금액</th>
				<th></th>
				<th>등급할인</th>
				<th></th>
				<th>총 결제금액</th>
				<th>적립예정 포인트</th>
			</tr>
			<tr>
				<td id="alltotal">${total} 원</td>
				<td> - </td>
				<td id="dc">${dc} 원</td><!--   -->
				<td> = </td>
				<td id="totaldc">${totaldc} 원</td>
				<td id="tpoint">${point} 점</td> 
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td>(${grade.gName},${grade.dcPercent}%)</td>
				<td></td>
				<td></td>
			</tr>				
		</table>
		<br>
	  	<div align="center">
		  <button id="sendmenu" class="btn btn-dark">주문하기</button>		
	  	</div><br>
	  </div>
	<div align="center">
		<button id="shopBtn" name="shopBtn" onclick="location='index.jsp'">쇼핑 계속하기</button>
	</div>
	
	
<%@ include file = "footer.jsp"%>
</body>
</html>