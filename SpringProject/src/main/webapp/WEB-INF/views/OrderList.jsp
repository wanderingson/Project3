<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="Header.jsp" %>
<%@ include file="Sidebar.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문내역</title>
<style>
table{
	margin-left:auto;
	margin-right:auto;
	margin-bottom:20px;	
	padding-left:5px;
	border: 2px solid #dcdcdc;
	display:none;
	table-layout:fixed;
}

.orderDate {caption-side: top;}

table th {
	padding-right:80px;
}

table td {
	word-break:break-all;
}

.state { 
	padding-left:350px;
	padding-right:40px; 
	text-align:right;
}

.detail { 
	padding-left:100px;
	padding-right:40px;
	padding-top:10px;
	text-align:center; 
}

#moreBtn { display:none; }

#minusBtn { display:none; }

</style>

</head>
<body>
	<section>
		<article class="card-body" style="max-width:800px; margin: auto;">
			<br>
			<h1 style="text-align: center;">주문내역</h1>
			<hr>
			
			<c:forEach var="imsi" items="${ovlist }" varStatus="status">
			<table style="width:800px;">
				<caption class="orderDate">주문내역 : <fmt:formatDate value="${imsi.order_date }" pattern="yyyy-MM-dd" /></caption>
				<tr>	
					<th>주문번호</th>
					<td>${imsi.order_num }</td>
				</tr>
				<tr>
					<th>상품명</th>
					<td style="width: 310px;">${arrName[status.index]} 외 ${arrNum[status.index].intValue()-1}건</td>
				</tr>
				<tr>
					<th>배송상태</th>
					<td>${imsi.delivery_state }</td>
					<td style="padding-left:180px;">
						<a href="orderdetails.do?order_num=${imsi.order_num }&mem_id=${imsi.mem_id}" class="btn btn-outline-primary btn-sm">상세보기</a>
					</td>
				</tr>
				<tr>	
					<th>결제방법</th><td colspan=2>카카오페이</td>					
				</tr>
				<tr>	
					<th>결제금액</th><td colspan=2>${imsi.total_price } 원</td>
				</tr>	
				<tr>
				</tr>
			</table>
			</c:forEach>
			<br>
		
			<div id="moreBtn" align="center"><a href='#' id='load'>더보기</a></div>
			<div id="minusBtn" align="center"><a href='#' id='mload'>접기</a></div>
		
		</article>
	</section>
	
<script> 

$(function(){
    $("table").slice(0, 3).show(); // select the first ten
  	if($("table").length > 3) {
  		$("#moreBtn").show();
  	}
    $("#load").click(function(e){ // click event for load more
        e.preventDefault();
        $("table:hidden").slice(0, 3).show(); // select next 10 hidden divs and show them
        if($("table:hidden").length == 0){ // check if any hidden divs still exist
        	$("#moreBtn").hide(); // alert if there are none left
        	$('#minusBtn').show();
        }
    });
    
    $("#mload").click(function(e) {
    	e.preventDefault();
    	$('table').hide();
    	$('table').slice(0,3).show();
    	$('#minusBtn').hide();
    	if($("table").length > 3) {
      		$("#moreBtn").show();
      	}
    });
    
});
</script>	
</body>
</html>