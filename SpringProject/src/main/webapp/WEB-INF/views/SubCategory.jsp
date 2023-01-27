<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  	      <a href="smalltitle.do?small=${fir}&main=${mainmenu}" class="nav-link" id="font1">
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
  	     <c:forEach items="${smalltitle}" var="small">
  	      <li class="nav-item" id="shop1">
  	        <a href="ProductPage.do?product=${small.product}" class="nav-link px-2" style="text-align: center;">
  	          <img src="./img/${small.product}.jpg" class="img1" align="left" /><br />
  	   	  	  <font class="menu1">${small.product}</font><br />
  	   	  	  <font class="menu2">${small.price}원</font>
  	        </a>
  	      </li>
  	      </c:forEach>
  	    </ul>
  	  </div>  	
  	</div>
	
	<jsp:include page="paging.jsp">
    <jsp:param value="${paging.page}" name="page"/>
    <jsp:param value="${paging.beginPage}" name="beginPage"/>
    <jsp:param value="${paging.endPage}" name="endPage"/>
    <jsp:param value="${paging.prev}" name="prev"/>
    <jsp:param value="${paging.next}" name="next"/>
</jsp:include>
	




<%@ include file="footer.jsp"%>
</body>
</html>