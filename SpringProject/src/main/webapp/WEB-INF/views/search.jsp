<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="Header.jsp"%>
<%-- <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<style>
  .img1{width: 380px;height: 350px; display: block;}
  .menu1{font-size: 20px; color: black; width: 200px; height: 100px;}
  .menu2{font-size: 20px; font-weight: 700; color: #ad0000; }
  #shop1{width: 400px; margin: 0px; padding: 0px;}
  </style>
<body>
<%String search = request.getParameter("search");%>
	
	<c:choose>
	<c:when test="${fn:length(memList) != 0}">
	<div align="center" class="container">
	<div>
			<div class="main-pagetitle" align="center">
				<h1 class="main-pagetitle-word">[<%=search %>] 검색결과</h1>
			</div>
		</div>
	<div class="py-3">
  	    <ul class="nav justify-content-start"> 
  	     <c:forEach items="${memList}" var="co">
  	      <li class="nav-item px-4" id="shop1">
  	        <a href="ProductPage.do?product=${co.product }" class="nav-link" id="shop2" style="text-align: left;">
  	          <img src="./img/${co.product }.jpg" alt="notfound" class="img1" align="middle" /><br />
  	   	  	  <font class="menu1">${co.product}</font><br />
  	   	  	  <font class="menu2">${co.price}원</font>
  	        </a>
  	      </li>
  	      </c:forEach>
  	    </ul>
  	  </div>  	
  	    	 </div>
  	  
  	  </c:when>
  	  <c:otherwise>
		<div>
			<div class="main-pagetitle">
				<h1 class="main-pagetitle-word">[<%=search %>] 검색어에 해당하는 결과가 없습니다.</h1>
			</div>
		</div>
	</c:otherwise>
	</c:choose>
	
	<jsp:include page="paging.jsp">
    <jsp:param value="${paging.page}" name="page"/>
    <jsp:param value="${paging.beginPage}" name="beginPage"/>
    <jsp:param value="${paging.endPage}" name="endPage"/>
    <jsp:param value="${paging.prev}" name="prev"/>
    <jsp:param value="${paging.next}" name="next"/>
</jsp:include>

	
	



	<%@ include file="footer.jsp"%>