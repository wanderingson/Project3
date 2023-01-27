<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
   width:auto;
}
</style>
</head>
<body>
   <h2>주문내역</h2>
   
   <table border=2>
      	<tr>
         	<th>주문번호</th>
         	<th>상품명</th>
         	<th>수량</th>
         	<th>결제금액</th>
         	<th>배송상태</th>
      	</tr>
		<c:forEach var="imsi1" items="${ovlist }" varStatus="status">
		<tr>
         	<td>주문일자</td>
         	<td colspan=4 style="text-align:center;"><fmt:formatDate value="${imsi1.order_date }" pattern="yyyy-MM-dd" /></td>
      	</tr>
	      	<c:forEach var="imsi2" items="${oblist[status.index] }">
	      	<tr>
		         <td>NO.${imsi1.order_num }</td>
		         <td>${imsi2.product_name }</td>
		         <td style="text-align:center;">${imsi2.product_qty }</td>
		         <td>${imsi2.order_price }원</td>
		         <td>${imsi2.delivery_state }</td>
	      	</tr>
	      	</c:forEach>
   		</c:forEach>
   </table>
   <a href="adminsidebar.do">[홈으로]</a>
</body>
</html>