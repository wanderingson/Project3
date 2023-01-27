<%@page import="review.ReviewBoardDAO"%>
<%@page import="orderdb.OrderVO"%>
<%@page import="orderdb.OrderDAO"%>
<%@page import="orderdb.OrderDetailsVO"%>
<%@page import="orderdb.OrderDetailsDAO"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="Header.jsp" %>
<%@ include file="Sidebar.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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

	<%
		int order_num = Integer.parseInt(request.getParameter("order_num"));
		OrderDetailsDAO oddao = new OrderDetailsDAO(); 
		ArrayList<OrderDetailsVO> odvArray = new ArrayList<>();
		odvArray = oddao.getOrderDetailsInfo(order_num);
		
		boolean result = oddao.select_refundCheck(order_num);
		
		OrderDAO odao = new OrderDAO();
		OrderVO odvo = odao.getOneInfo(order_num);
		
		ReviewBoardDAO rbdao = new ReviewBoardDAO();

	%>


<section>
	<article class="card-body" style="max-width:800px; margin: auto;">
		<br>
		<h1 style="text-align: center;">주문 내역 상세</h1>
		<hr>
		
		<table class="table">
		<caption align="top"><h5><b>주문번호 : <%=order_num %></b></h5></caption>
		<% for(OrderDetailsVO imsi : odvArray) { %>
		<tr>
			<td class="product"><b>
				<%=imsi.getProduct_name() %></b><br><%=imsi.getOrder_price() %>원 | <%=imsi.getProduct_qty() %>개 
			</td>
			<td class="state">
				<%=imsi.getDelivery_state() %>
			</td>
			<td class="refund">
				<a href=""></a>
			</td>
			<% if(result && !imsi.getDelivery_state().contains("환불")) {%> 
			<td class="refund">
				<a href="refundReq.do?order_details_num=<%=imsi.getOrder_details_num() %>&order_num=<%=imsi.getOrder_num() %>" onclick='return confirm("환불하시겠습니까?")' class="btn btn-outline-primary btn-sm">환불요청</a>
			</td>
			<% } else { %>
			<td></td>
			<% } %>
			
			<% if(rbdao.check_review("hong", imsi.getProduct_name())==0) {%>
			<td class="review">
				<a href="ReviewForm.jsp?product_name='<%=imsi.getProduct_name() %>'" class="btn btn-outline-primary btn-sm">후기작성</a>
			</td>
			<% } else { %>
			<td></td>
			<% } %>
		</tr>
		<% } %>		
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

