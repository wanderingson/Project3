<%@page import="db.*"%>
<%@page import="db.BasketDAO"%>
<%@page import="java.util.ArrayList"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  --%>
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
</style>
<%
	BasketDAO dao = new BasketDAO();
	ArrayList<BasketVO> array1 = dao.getCartList(id);
	
	GradeDAO gdao = new GradeDAO();
	GradeVO gvo = gdao.select_gradeInfo(id);
%>
<script>
$(function name() {
	$('#sendmenu').click(function(){
		var total = <%= dao.select_cartPrice(id)%>;
		if(total == 0) {
			alert("장바구니가 비어있습니다");
		}else{
			location.href="paymenu.do";	
		}
		  	  
	});	
})

// 장바구니 + - 버튼
function count(type)  {
	var ss = "";
	var memid = '${sessionScope.sid}';
	<% for(BasketVO imsi : array1) { %>
		if(type == '<%=imsi.getName()%>plus'){
			ss = "plus";
			
		}
		else if(type == '<%=imsi.getName()%>,minus'){
			ss="minus";
		}
	<%}%> 
		 if(ss == 'plus') {
			 var res1 = document.getElementById(type);
			 let number = res1.innerText;
			 $.ajax({
				 	url      : "BPlus.do",
			        type     : 'post',
			        data     : { name:type,
			        			id : memid,
				 				num : number
			        },
			        success  : function(result) {
			        	document.location.reload();
	                        },
			        error    : function(request, status, error){
			        	alert("오류");
			        }
			    });
	    }else if(ss == 'minus')  {
	    	var minus11 = type.split(',');
	    	var add = minus11[0]+"plus";
	    	var res1 = document.getElementById(add);
			 let number = res1.innerText; 
	    	$.ajax({
	    		url      : "BMinus.do",
		        type     : 'post',
		        data     : {name:type,
		        			id : memid,
	    					num : number
		        },
		        success  : function(result) {
		        	document.location.reload();
		                        },            
		        error    : function(request, status, error){
		        	alert("오류");
		        }
		    });
	          
	      }
	    }

	  
  
  function delete1(del) {
		  var ss = "";
	  <% for(BasketVO imsi : array1) { %>
		if(del == '<%=imsi.getName() %>'){
			ss = "delete";
		}
	<%}%> 
	var memid = '${sessionScope.sid}';
	if(ss == "delete"){
	  	$.ajax({
  			url      : "BDelte.do",
	        type     : 'post',
	        data     : {name : del ,
	        			id : memid },
	        complete  : function(result) {
	        		alert('장바구니에서 삭제되었습니다');
	        		document.location.reload();
	                        },            
	        error    : function(request, status, error){
	        	alert("오류");
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
			<% for(BasketVO imsi : array1) { %>
		  <tr>
			<td>
			  <img src="./img/empty.png" alt="이미지x">
			</td>
			<td><%=imsi.getName() %></td>
			<td><%=imsi.getPrice1()%>원</td>
			<td class=cntUpdate>
			  <button class="btn btn-light" onclick='count("<%=imsi.getName() %>,minus")' >-</button>
                <span id="<%=imsi.getName()%>plus" class="<%=imsi.getName()%>minus"><%=imsi.getNum()%></span>
              <button class="btn btn-light" onclick='count("<%=imsi.getName() %>plus")'>+</button>
			</td>
			<td>무료배송</td>
			<td><%=imsi.getNum()*imsi.getPrice1()%>원</td>
			<td> 
			  <button type="button" onclick='delete1("<%=imsi.getName()%>")'
			  class="btn btn-secondary" style="font-size: 12px; width: 100px;height: 40px;">
			  장바구니 삭제
			  </button>
			</td> 
		  </tr>
			<%} %>
		</table>
		<div align="right" style="padding-top: 10px; padding-bottom: 10px;">			
		  <a href="AllBDel.do?id=<%=id%>" id="alldel" class="btn btn-dark" style=" font-size: 15px;">
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
				<td><%= dao.select_cartPrice(id)%>원</td>
				<td> - </td>
				<td><%= dao.select_cartPrice(id) * gvo.getDcPercent()/100 %>원</td>
				<td> = </td>
				<td><%=dao.select_cartPrice(id) - (dao.select_cartPrice(id) * gvo.getDcPercent()/100) %>원</td>
				<td><%=dao.select_cartPrice(id) * 1/100 %>점</td> 
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td>(<%=gvo.getgName() %>, <%= gvo.getDcPercent() %>%)</td>
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