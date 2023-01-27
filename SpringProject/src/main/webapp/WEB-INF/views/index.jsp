<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ include file="Header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

  .top1{color: black;}


</style>
</head>
<body>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<!-- <script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script> -->

<div id="carouselExample" class="carousel slide" data-bs-ride="carousel">
	<div class="carousel-inner">
		<div class="carousel-item active" data-bs-interval="2000">
			<a href="banner1.do">
			  <img class="d-block w-100" src="./img/gradebanner.jpg" alt="First slide" height="200px">
			  <div class="carousel-caption d-none d-md-block">
				<h2>❖등급제 도입!❖</h2>
				<p>등급별 혜택을 확인해보세요!!</p>
			  </div>
			</a>
		</div>
		<div class="carousel-item" data-bs-interval="2000">
		  <a href="banner2.do">
		    <img class="d-block w-100" src="./img/reviewbanner.jpg" alt="Second slide" height="200px">
			<div class="carousel-caption d-none d-md-block">
			  <h2>❖리뷰왕 이벤트❖</h2>
			  <p>자세한 내용은 배너를 클릭하세요</p>
		    </div>
		  </a>
		</div>
		<div class="carousel-item">
		  <c:if test="${sessionScope.sid == null}"><a href="loginpage.do" onclick="alert('로그인 후 이용하실 수 있습니다')"></c:if>
		  <c:if test="${sessionScope.sid != null}"><a href="QnA.do"></c:if>
		    <img class="d-block w-100"src="./img/qnabanner.jpg" alt="Third slide" height="200px">
			  <div class="carousel-caption d-none d-md-block">
			    <h2>❖불편사항 항시 접수중❖</h2>
			    <p>고객센터 문의시 최대한 빠른 응대중입니다</p>
			  </div>
			</a>
		</div>

		

		<!-- 왼쪽 오른쪽 화살표 버튼 -->
		<button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
     	  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    	  <span class="visually-hidden">Previous</span>
  		</button>
  		<button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
    	  <span class="carousel-control-next-icon" aria-hidden="true"></span>
    	  <span class="visually-hidden">Next</span>
  		</button>
		<!-- / 화살표 버튼 끝 -->

	  <div class="carousel-indicators">
    	<button type="button" data-bs-target="#carouselExample" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    	<button type="button" data-bs-target="#carouselExample" data-bs-slide-to="1" aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselExample" data-bs-slide-to="2" aria-label="Slide 3"></button>
      </div>
	</div>
</div> 
<br>
	<div align="center">
		<table>
			<tr align="center">
				<td colspan="3"><h3>상품추천</h3></td>
			</tr>
			<tr align="center">
				<td class="sangpoom_name"><h5>으쌰으쌰 다이어트 </h5></td>
				<td class="sangpoom_name"><h5>오늘 저녁은 소고기닷</h5></td>
				<td class="sangpoom_name"><h5>이거 하나면 냉장고 걱정 끝</h5></td>
			</tr>
			<tr align="center">
			  <td class="sangpoom_img">
			    <div style="height: 300px; width: 200px;" class="nav-item">
				  <a href="ProductPage.do?product=향긋한 풍미 닭가슴살 샐러드" class="nav-link">
				  <img src="./img/향긋한 풍미 닭가슴살 샐러드.jpg" height=200 width=200>
				  <font class="top1">향긋한 풍미 닭가슴살 샐러드</font>
				  </a>
				</div>
			  </td>
			  <td class="sangpoom_img">
			    <div style="height: 300px; width: 200px;" class="nav-item">
				  <a href="ProductPage.do?product=1등급 안창살 150g" class="nav-link">
				  <img src="./img/1등급 안창살 150g.jpg" height=200 width=200>
				  <font class="top1">1등급 안창살 150g</font>
				  </a>
				</div>
			  </td>
			  <td class="sangpoom_img">
			    <div style="height: 300px; width: 200px;" class="nav-item">
				  <a href="ProductPage.do?product=1등급 국거리 2종 200g" class="nav-link">
				  <img src="./img/1등급 국거리 2종 200g.jpg" height=200 width=200>
				  <font class="top1">1등급 국거리 2종 200g</font>
				  </a>
				</div>
			  </td>
			</tr>
			<tr align="center">
			  
			<%-- 	<c:forEach var="pi" items="${pv }">
				<c:if test= "${pi.product eq '향긋한 풍미 닭가슴살 샐러드'  or pi.product eq '1등급 안창살 150g' or pi.product eq '1등급 국거리 2종 200g'}">
				<td class="sangpoom_img"><a href="ProductPage.do?product=${pi.product}"><img src="./img/${pi.product}.jpg"  alt="no image" height=150
					width=150></a></td>
				</c:if>
					</c:forEach> --%>
			
			</tr>
			<tr align="center">
				<td colspan="3"><h3>이달의 랭킹 Top 3</h3></td>
			</tr>
			<tr align="center">
			  <td class="sangpoom_img">
			    <div style="height: 300px; width: 200px;" class="nav-item">
				  <a href="ProductPage.do?product=노르웨이 연어 200g" class="nav-link">
				  <img src="./img/노르웨이 연어 200g.jpg" height=200 width=200>
				  <font class="top1">노르웨이 연어 200g</font>
				  </a>
				</div>
			  </td>
			  <td class="sangpoom_img">
			    <div style="height: 300px; width: 200px;" class="nav-item">
				  <a href="ProductPage.do?product=오리슬라이스 500g" class="nav-link">
				  <img src="./img/오리슬라이스 500g.jpg" height=200 width=200>
				  <font class="top1">오리슬라이스 500g</font>
				  </a>
				</div>
			  </td>
			  <td class="sangpoom_img">
			    <div style="height: 300px; width: 200px;" class="nav-item">
				  <a href="ProductPage.do?product=향긋함과 단맛을 더한 유자차 620g" class="nav-link">
				  <img src="./img/향긋함과 단맛을 더한 유자차 620g.jpg" height=200 width=200>
				  <font class="top1">향긋함과 단맛을 더한 유자차 620g</font>
				  </a>
				</div>
			  </td>
			</tr>
		</table>
	</div>

<%@ include file="footer.jsp"%>

</body>
</html>
