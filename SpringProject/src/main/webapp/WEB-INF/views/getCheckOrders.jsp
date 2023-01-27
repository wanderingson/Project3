<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table border=2>
		<caption>주문확인</caption>
		<tr>
			<th>주문번호</th>
			<th>ID</th>
			<th>전화번호</th>
			<th>우편번호</th>
			<th>주소</th>
			<th>상세주소</th>
			<th>결제금액</th>
			<th>주문일자</th>
			<th>배송상태</th>
			<th>배송요청사항</th>
			<th>승인</th>
		</tr>
		<c:forEach var="imsi" items="${ovlist }">
		<tr>
			<td>
				<a href="getorderdetails.do?order_num=${imsi.order_num }">
					${imsi.order_num }
				</a>
			</td>
			<td>
				<a href="getmeminfo.do?mem_id=${imsi.mem_id }">
					${imsi.mem_id }
				</a>
			</td>
			<td>
				${imsi.tel }
			</td>
			<td>
				${imsi.address1 }
			</td>
			<td>
				${imsi.address2 }
			</td>
			<td>
				${imsi.address3 }
			</td>
			<td>
				${imsi.total_price }원
			</td>
			<td>
				<fmt:formatDate value="${imsi.order_date }" pattern="yyyy-MM-dd" />
			</td>
			<td>
				${imsi.delivery_state }
			</td>
			<td>
				${imsi.delivery_message }
			</td>
			<td>
				<a href="ordercheck.do?order_num=${imsi.order_num }" 
					class="btn btn-outline-primary btn-sm" onclick='return confirm("주문확인")'>주문확인</a>
			</td>
		</tr>
		</c:forEach>
		
	</table>
	<a href="adminsidebar.do">[홈으로]</a>
</body>
</html>