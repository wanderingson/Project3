<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="css/bootstrap.css">
<script src="./js/bootstrap.min.js"></script> -->
<script src="./js/jquery-3.6.1.min.js"></script>

<style>
.aside{
    background: teal;
    position: Sticky;
    top: 50;
    left: 0;
    width: 20%;
    height: 1000px;
    padding: 20px;
    float: left;
}

.aside ul li a{
    display: block;
    padding: 13px 30px;
    border-bottom: 1px solid #10558d;
    color: white;
    font-size: 16px;
    position: relative;
}

.aside ul{
	list-style:none;
}


</style>

</head>
<body>

	 <div class="aside">
	  <ul>
	  	<li>
	  		<a href="mypage.do?id=${sessionScope.sid}">
	  		<span class="item">회원정보</span>
	  		</a>
	  	</li>
	  	<li>
	  		<a href="orderlist.do?id=${sessionScope.sid}">
	  		<span class="item">주문목록</span>
	  		</a>
	  	</li>	    	
	  	<li>
	  		<a href="gradebenefit.do">
	  		<span class="item">회원등급별 혜택</span>
	  		</a>
	  	</li>
	  	<li>
	  		<a href="memDeleteForm.do">
	  		<span class="item">회원탈퇴</span>
	  		</a>
	  	</li>	    		    		
	  </ul>   
	 </div>

</body>
</html>