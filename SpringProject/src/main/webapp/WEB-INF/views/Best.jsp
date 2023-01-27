<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="Header.jsp" %>
<%--     <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <style>
    #box{width: 900px; height: 90px;}
  #stitle{padding: 15px; font-size: 20px;}
  #font1{color: black;}
  .img1{width: 380px;height: 350px; display: block;}
  .menu1{font-size: 20px; color: black; width: 200px; height: 100px;}
  .menu2{font-size: 20px; font-weight: 700; color: #ad0000; }
  #shop1{width: 400px; margin: 0px; padding: 0px;}
  </style>
</head>
<body>
  <div align="center" class="container">
  <h1 style="padding-top: 30px;">인기상품</h1>
<div class="py-3">
  	    <ul class="nav justify-content-start"> 
  	     <c:forEach var="po" items="${pv }">
  	      <li class="nav-item px-4" id="shop1" >
  	        <a href="ProductPage.do?product=${po.product }" class="nav-link" id ="shop2" style="text-align: left;">
  	          <img src="./img/${po.product }.jpg" alt="notfound" class="img1" align="middle" /><br />
  	   	  	  <font class="menu1">${po.product}</font><br />
  	   	  	  <font class="menu2">${po.price}원</font>
  	        </a>
  	      </li>
  	      </c:forEach>
  	    </ul>
  	  </div>  	
  	 </div>
 

<%@ include file="footer.jsp"%>
</body>
</html>
