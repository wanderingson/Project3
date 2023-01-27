<%@page import="orderdb.OrderDetailsVO"%>
<%@page import="orderdb.OrderDetailsDAO"%>
<%@page import="orderdb.OrderVO"%>
<%@page import="orderdb.OrderDAO"%>



<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
   <%
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      
      String mem_id = request.getParameter("mem_id");
      
      OrderDAO odao = new OrderDAO();
      ArrayList<OrderVO> ovArray = new ArrayList<>();
      ovArray = odao.getInfo(mem_id);
      
      OrderDetailsDAO oddao = new OrderDetailsDAO();
      ArrayList<OrderDetailsVO> odvArray = new ArrayList<>();
   %>
   <h2>주문내역</h2>
   
   

   
   <table border=2>
      <tr>
         <th>주문번호</th>
         <th>상품명</th>
         <th>수량</th>
         <th>결제금액</th>
         <th>배송상태</th>
      </tr>
      <% for(OrderVO imsi1 : ovArray) {%>
      <tr>
         <td>주문일자</td>
         <td colspan=4 style="text-align:center;"><%=imsi1.getOrder_date() %></td>
      </tr>
      <% 
         odvArray = oddao.getOrderDetailsInfo(imsi1.getOrder_num());
         for(OrderDetailsVO imsi2 : odvArray) { 
      %>
      <tr>
         <td>NO.<%=imsi1.getOrder_num() %></td>
         <td><%=imsi2.getProduct_name() %></td>
         <td style="text-align:center;"><%=imsi2.getProduct_qty() %></td>
         <td><%=imsi2.getOrder_price() %>원</td>
         <td><%=imsi2.getDelivery_state() %></td>
      </tr>
      <% } %>
   <% } %>   
   </table>
   <a href="AdminSideBar.jsp">[홈으로]</a>
</body>
</html>