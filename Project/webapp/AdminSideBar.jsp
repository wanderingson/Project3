<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css">
<script src="./js/bootstrap.min.js"></script>
<script src="./js/jquery-3.6.1.min.js"></script>
<%@ include file="Header.jsp"%>
<style>

.allm{
float:left;
margin-left: 17%;

}
.all{
	margin-top: 20px;
	margin-bottom: 250px;
}


.submenu {
	display:none;
    color: white;
    font-size: 16px;
    align-items: left;
	padding-left:0;
	padding-top: 20px;
}
.submenu li{
	list-style: none;
	padding-bottom: 30px;
}


</style>

</head>
<body>
<br>
<h1 style="text-align: center;">관리자페이지</h1><br>
	<div class="all">
		<span class="allm">
	  		<span class="menu">상품관리</span>
	  		<ul class="submenu">
	  			<li><a href="getAllProduct.jsp">상품목록</a></li>
	  			<li><a href="getPrdInsert.jsp">상품등록</a></li>
	  			<li><a href="getPrdDelete.jsp">상품삭제</a></li>
	  		</ul>
	  		 </span>
	  	
	  			<span class="allm">
	  	
	  		<a href="getAllInfo.jsp" style="text-decoration-line: none; color:black;">
	  		<span class="menu">회원관리</span>
	  		</a>
	  			  		 </span>
	  		
	  			<span class="allm">
	  	
	  		<span class="menu">주문관리</span>
	  		<ul class="submenu">
	  			<li><a href="getCheckOrders.jsp">주문확인</a></li>
	  			<li><a href="getAllOrders.jsp">주문내역</a></li>
	  		</ul>
	  		  		 </span>
	  	
	  			<span class="allm">
	  	
	  		<span class="menu">환불관리</span>
	 		<ul class="submenu">
	 			<li><a href="getCheckRefund.jsp">환불확인</a></li>
	 			<li><a href="getAllRefund.jsp">환불내역</a></li>
	 		</ul>
	  		  		 </span>
	  		  		 </div>
	
	 
	 		<%@include file="footer.jsp" %>
	 
	
	<script>
		$(document).ready(function() {
			$(document).on("click", ".menu", function() {
				$(this).next(".submenu").slideToggle(300); 
			});
			
		});
	</script>
</body>
</html>

