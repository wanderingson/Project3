<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배고플땐</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<link rel="stylesheet" href="./css/style_footer.css">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<script src="./js/jquery-3.6.1.min.js"></script>
  <style>
   .dropdown:hover .dropdown-menu {
    display: block;
    margin-top: 0;
	}
	.carousel-inner>.carousel-item>img {height: 200px;}
	.sangpoom_name {padding: 30px;}
	.sangpoom_img {padding: 50px;}
	
	#header1{width: 1050px;}
	#head1{padding: 0px; margin: 0px; width: 60px;}
	#head2{padding: 0px; margin: 0px; width: 50px;}
	.class-n1{ cursor: pointer; }
	.class-n2{ cursor: pointer; }
	.class-n3{ cursor: pointer;}
	.cart1{ padding-left: 200px; font-style: italic;}
	#title1{ color:#000000; font-size: 35px; cursor: pointer;}
	#title3{ cursor: pointer; margin-left: 48%; }
	 #css-nav{margin-left: 18%;}
	#css-nav1{ color:#000000; cursor: pointer; margin-left: 15%; }
	#css-nav2{ cursor: pointer; margin-left: 12%;} 
	#css-nav3{ color:#000000;cursor: pointer;}
	#ser { width: 300px; height: 50px;}
	
  </style>


<script>
	
function move(){
	history.pushState(null, null, "index.jsp");
	 
	window.onpopstate = function(event) {
	history.go(1);
	}; 
	alert("로그아웃 되었습니다");

	location.replace("logout.do");
} 

$(document).ready(function () {
	  $(".basket1").click(function () {
		  var id = '${sessionScope.sid}'
	    <%-- <%if(id.equals("")){%> --%>
	    if(id==""){
	    	alert('로그인을 해주십시오');
	    }
	    
	    
	    else{
	    $('.basket1').prop('href','Basket.do?id=${sessionScope.sid}')
	    
	    }
	  });
	});
</script>

</head>
<body>
  <c:if test="${sessionScope.sid!=null}">
    <div class="container-fluid">
      <div style="margin-left: 66%; font-size: 16px;" class="row" align="right">
        <div class="row" style="padding-right: 10px;">
          <div class="col-xl-4" style="width: 100px; padding: 0px;">
            <a href="mypage.do?id=${sessionScope.sid}" class="class-n1">
      	  	  <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
  		  		<path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
  		  		<path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
	  	  	  </svg>
		  	  ${sessionScope.sid }
	  		</a>
	  	  </div>
	  	  <div class="col-xl-4" style="width: 60px; padding: 0px;">
	  	  	<a href="QnA.do" class="class-n2">고객센터</a>
	  	  </div>
	  	  <div class="col-xl-4" id="head1">
	  	  	<a href="#" onclick="move();" class="class-n3">로그아웃</a>
	  	  </div>
 	    </div>
	  </div>
    </div>
  </c:if>
  <c:if test="${sessionScope.sid == null}">
    <div class="container-fluid">
      <div style="margin-left: 66%; font-size: 16px;" class="row" align="right"> 
        <div class="row" style="padding-right: 10px;">
          <div class="col-xl-4 " id="head1">
            <a href="memJoinForm.do" class="class-n1"><font>회원가입</font></a>
          </div>
          <div class="col-xl-4" id="head2">
      	    <a href="loginpage.do" class="class-n2">로그인</a>
          </div>
          <div class="col-xl-4" id="head1">
      	    <a href="loginpage.do" class="class-n3" onclick="alert('로그인후 고객센터에 접근이 가능합니다')"><font>고객센터</font></a>
          </div>
        </div>
      </div>
    </div>
  </c:if>


  <div class="container" style="font-size: 20px;" id="header1"> <!-- 사이트제목 검색 장바구니위치  -->
    <div class="row">
    <div class="col-xl-3 mx-auto" align="center">
	  <a href="index.jsp" class="nav-link active fst-italic" id="title1">
	    배고플땐
	  </a>
    </div>
	<div class="col-xl-6 mx-auto" align="center">
      <form action="pagelist.do" id="title2">
          <input type="text" placeholder="검색어를 입력해주세요" id="ser" name="search" autocomplete="off"/>
          <button class="btn btn-secondary" type="submit" style="height: 45px">
            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
  		      <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
	        </svg>  
          </button>
      </form>
      </div>
      <div class="col-xl-3 mx-auto">
        <a href="" style="height: 100px;" id="title3" class="basket1">
          <img src="./img/cart.svg" style="height : 55px; width: 30px;" />
        </a>  
      </div>
    </div>
  </div>
   
   <nav class="navbar navbar-expand-lg bg-light"> <!-- 카테고리 인기상품,신상품,공지사항 사이트이동 -->
      <div class="container-fluid" style="font-size: 20px;">
        <div class="col-12" >
          <ul class="navbar-nav" id="css-nav" >
            <li class="nav-item dropdown">
              <a id="css-nav1" class="nav-link dropdown-toggle" href="#" role="button" aria-expanded="false">
                <img src="./img/list.svg" style="width: 25px;" >
			    카테고리
		      </a>
		      <ul class="dropdown-menu">
	  	   	  	<li><a class="dropdown-item" href="bigtitle.do?title=1">채소/과일</a></li>
            	<li><a class="dropdown-item" href="bigtitle.do?title=2">수산/해산물</a></li>
                <li><a class="dropdown-item" href="bigtitle.do?title=3">정육</a></li>
            	<li><a class="dropdown-item" href="bigtitle.do?title=4">음료</a></li>
          	  </ul>
		    </li>
		    <li class="nav-item" id=css-nav2>
          	  <a class="nav-link active" id=css-nav3 href="Best.do">인기상품</a>
        	</li>
        	<li class="nav-item" id=css-nav2>
          	  <a class="nav-link" id=css-nav3 href="NewProduct.do">신상품/제철상품</a>
        	</li>
    	    <li class="nav-item" id=css-nav2 >
              <a class="nav-link" id=css-nav3 href="bbs.do">공지사항/이벤트</a>
	        </li>
		  </ul>
        </div>
      </div>
    </nav>
   


   



</body>
</html>