<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="Header.jsp" %>
<%@ include file="Sidebar.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문상세내역</title>
<style>

table{
	margin-left:auto;
	margin-right:auto;
	width:800px;
	line-height:30px;
}

tr{
	height:100px;
}

td{
	vertical-align: middle;
}

.product{
	width:500px;
	text-align:left;
}

.state{
	width:150px;
	text-align:center;
}

.cart{
	width:150px;
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
		<h1 style="text-align: center;">주문 내역 상세</h1>
		<hr>
		
		<table class="table">
		<caption align="top"><b>주문번호 : ${order_num }</b></caption>
		<c:forEach var="imsi" items="${odvlist }" varStatus="status">
		<tr>
			<td class="product"><b>
				${imsi.product_name }</b><br>
				${imsi.order_price }원 | ${imsi.product_qty }개 
			</td>
			<td class="state">
				${imsi.delivery_state }
			</td>
			<td class="refund">
				<a href=""></a>
			</td>
			<c:set var="ds" value="${imsi.delivery_state }"/>
			<c:choose>
				<c:when test="${fn:contains(ds, '환불')}">
					 <td><a class="btn btn-outline-secondary btn-sm">환불처리</a></td>
				</c:when>
				<c:otherwise>
					<td class="refund">
						<a href="refundreq.do?order_details_num=${imsi.order_details_num }&order_num=${imsi.order_num}&mem_id=${sessionScope.sid}" onclick='return confirm("환불하시겠습니까?")' class="btn btn-outline-primary btn-sm">환불요청</a>
					</td>
				</c:otherwise>		
			</c:choose>
			<c:set var="arr1" value="${arr[status.index] }"/>
			<c:choose>
				<c:when test="${arr1.intValue() eq 1}">
					<td><a class="btn btn-outline-secondary btn-sm">작성완료</a></td>
				</c:when>
				<c:otherwise>
					<td class="review">
						<a href="reviewform.do?product_name=${imsi.product_name }&order_details_num=${imsi.order_details_num}" class="btn btn-outline-primary btn-sm">후기작성</a>
					</td>
				</c:otherwise>
			</c:choose>
		</tr>
		</c:forEach>
		</table>
		
		
		<div id="moreBtn" align="center"><a href='#' id='load'>더보기</a></div>
		<div id="minusBtn" align="center"><a href='#' id='mload'>접기</a></div>
		
	</article>
</section>		

<script> 

$(function(){
    $("table").slice(0, 5).show(); // select the first ten
  	if($("table").length >= 5) {
  		$("#moreBtn").show();
  	}
    $("#load").click(function(e){ // click event for load more
        e.preventDefault();
        $("table:hidden").slice(0, 5).show(); // select next 10 hidden divs and show them
        if($("table:hidden").length == 0){ // check if any hidden divs still exist
        	$("#moreBtn").hide(); // alert if there are none left
        	$('#minusBtn').show();
        }
    });
    
    $("#mload").click(function(e) {
    	e.preventDefault();
    	$('table').hide();
    	$('table').slice(0,5).show();
    	$('#minusBtn').hide();
    	if($("table").length >= 5) {
      		$("#moreBtn").show();
      	}
    });
    
});
</script>

</body>
</html>