<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%> 
<%@ include file="Header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배고플땐</title>
<style>	
  #box{width: 900px; height: 90px;}
  #stitle{padding: 15px; font-size: 20px;}
  #font1{color: black;}
  .img1{width: 380px;height: 350px; display: block;}
  .menu1{font-size: 20px; color: black; width: 200px; height: 100px;}
  .menu2{font-size: 20px; font-weight: 700; color: #ad0000; }
  #shop1{width: 400px; margin: 0px; padding: 0px; margin-left: 10px; margin-bottom: 40px;}
  
</style>
</head>
<body>
  <div align="center" class="container">
  	<h1 style="padding-top: 30px;">${mainmenu}</h1> <!-- 대분류제목 -->
  	<div id="box" class="border border-2 border-dark p-2" style="--bs-border-opacity: .2;"> <!-- 소분류 제목 -->
  	  <ul class="nav justify-content-center">
  	    <li class="nav-item" id="stitle">
  	      <a href="smalltitle.do?small=${fir}&main=${mainmenu}" class="nav-link" id="font1"><!-- href="smalltitle.do?small=${fir}&main=${mainmenu}" -->
  	        ${fir}
  	      </a>
  	    </li>
  	    <li class="nav-item" id="stitle">
  	      <a href="smalltitle.do?small=${sec}&main=${mainmenu}" class="nav-link" id="font1">
  	        ${sec}
  	      </a>
  	    </li>
  	    <li class="nav-item" id="stitle">
  	      <a href="smalltitle.do?small=${third}&main=${mainmenu}" class="nav-link" id="font1">
  	        ${third}
  	      </a>
  	    </li>
  	    <li class="nav-item" id="stitle">
  	      <a href="smalltitle.do?small=${four}&main=${mainmenu}" class="nav-link" id="font1">
  	        ${four}
  	      </a>
  	    </li>
  	  </ul>
  	</div>
  	  <div class="py-3">
  	    <ul class="nav justify-content-start"> <!-- 상품창출력 -->
  	     <c:forEach items="${bigtitle}" var="big">
  	      <li class="nav-item px-4" id="shop1" >
  	        <a href="ProductPage.do?product=${big.product}" class="nav-link" id="shop2" style="text-align: left;" >
  	          <img src="./img/${big.product}.jpg" class="img1"align="middle"/><br />
  	   	  	  <font class="menu1">${big.product}</font><br />
  	   	  	  <font class="menu2">${big.price}원</font>
  	        </a>
  	      </li>
  	      </c:forEach>
  	    </ul>
  	  </div>  	
  	</div>
  	
  <%-- <jsp:include page="CategoriPaging.jsp">
	<jsp:param value="${cpaging.page}" name="page"/>
    <jsp:param value="${cpaging.beginPage}" name="beginPage"/>
    <jsp:param value="${cpaging.endPage}" name="endPage"/>
    <jsp:param value="${cpaging.prev}" name="prev"/>
    <jsp:param value="${cpaging.next}" name="next"/>
  </jsp:include> --%>

<jsp:include page="CategoriPaging.jsp">
    <jsp:param value="${cpaging.page}" name="page"/>
    <jsp:param value="${cpaging.beginPage}" name="beginPage"/>
    <jsp:param value="${cpaging.endPage}" name="endPage"/>
    <jsp:param value="${cpaging.prev}" name="prev"/>
    <jsp:param value="${cpaging.next}" name="next"/>
</jsp:include>
	




<%@ include file="footer.jsp"%>
</body>
</html>