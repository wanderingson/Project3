<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>

#orderList{
   margin-left:auto;
   margin-right:auto;
   width: 900px;
   border: 5px solid #ADD8E6;
   align:center;   
}

table tr td {
   text-align: left;
   height: 70px;
   padding : 20px;
   border: 1px solid #ADD8E6;
}

#orderList th{
   background:#F0F8FF;
   text-align:left;
   height: 70px;
   padding : 20px;
   border: 1px solid #ADD8E6;
}

table caption{
   font-size:30px;
}

#allProduct th {
   background:#F4FFFF;
   
}

span { padding:5px 5px 5px 5px;
   margin-right: 5px;      
}

#sendmenu{
	margin-bottom: 60px;
	margin-top: 10px;
}
  
</style>
<title>주문창</title>
</head>
<body>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<%@ include file = "Header.jsp"%>
    
<section>
    <article class="card-body" style="max-width:800px; margin: auto;">
    
    <br>
   <h1 align="center">주문창</h1>
   <hr width=900px><br>
   <!-- 앞에 배송정보(이름, 주소, 전화번호) 주소는 수정가능하게-->
   <!-- 주문상품정보 간단하게(상품명, 가격, 수량) -->
   <!-- 결제방법 -->
   <!-- 결제버튼 -->
      
      <form action="order.do" method="post">
         <table id="orderList">
            <caption align="top"><b>배송정보</b></caption>
            <tr>
               <th><label>수령인</label></th>
               <td class="v1">
                  <input type="text" value="${mv.name }" name="name">
                  <input type="hidden" value="${mv.id }" name="id">
               </td>
            </tr>
            <tr>
               <th><label>배송지</label></th>
               <td class="v1">
                  <input type="button" name="postnumber" value="우편번호찾기" onclick="daum_post()">
                  <input type="text" name="post" class="w-px60" value="${mv.address }" readonly /><br>
                  <input type="text" name="address2" value="${mv.address2 }" required/> <!-- 지번 or 도로명 주소 -->
                  <input type="text" name="address3" value="${mv.address3 }"/>  <!-- 상세주소 -->
               </td>
            </tr>
            <tr>
               <th><label>전화번호</label></th>
               <td class="v1">
                  <input type="text" value="${mv.tel }" name="tel">
               </td>
            </tr>
            <tr>
               <th><label>배송 메모</label></th>
               <td class="v1">
                  <select name="deliveryMessage">
                     <option value="별도 요청없음" selected>배송시 요청사항을 선택해주세요</option>
                     <option value="부재시 문앞에 놓아주세요">부재시 문앞에 놓아주세요</option>
                     <option value="부재시 경비실에 맡겨주세요">부재시 경비실에 맡겨주세요</option>
                     <option value="파손위험상품입니다. 배송시 주의해주세요">파손위험상품입니다. 배송시 주의해주세요</option>
                     <option value="부재시 전화 또는 문자주세요">부재시 전화 또는 문자주세요</option>
                  </select>
               </td>
            </tr>
            <tr>
               <th><label>배송상품</label></th>
               <td class="v1">
               <table id='allProduct'>
                  <tr>
                     <th>상품명</th>
                     <th>수량</th>
                     <th>상품금액</th>
                     <th>결제금액</th>                  
                  </tr>
                 <c:forEach var="imsi" items="${cvlist }">
                  <tr>
                     <td id="prdname">${imsi.name }</td>
                     <td style="text-align:center;">${imsi.num }</td>
                     <td style="text-align:center; opacity: 0.4;"><span style="text-decoration:line-through;">${imsi.price1 }원</span></td>
                     <fmt:parseNumber var="discount_price" value="${imsi.price1-imsi.price1*gv.dcPercent/100 }" integerOnly="true"/>
                     <td style="text-align:center;">${discount_price }원</td>
                  </tr>
                 </c:forEach> 
               </table>   
               </td>
            </tr>
            <tr>
               <th>적립예정 포인트</th>
               <td>
                   ${point }점
                  <input type="hidden" value="${point }" name="point">
               </td>
            </tr>
            <tr>
               <th><label>총결제금액</label></th>
               <td class="v1">
                  ${order_price }원
                  <input type="hidden" value=" ${order_price }" name="totPrice">
               </td>
            </tr>
         </table>
      </form>
      
      <div align="center">
        <button type="button" name="orderbtn" class="btn btn-secondary" id="sendmenu">
          주문하기
        </button>
        <button type="button" class="btn btn-secondary" id="sendmenu" style="width: 82px;" onclick="orderback()">
          취소
        </button> 
      </div>
   
</article>
</section>
   
   
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>   <!-- 다음 우편번호 api -->
   <script>   
   function orderback() {
	alert('주문이 취소되었습니다')
	location.href='Basket.do?id=${sessionScope.sid}';
	}
   //우편번호 검색
   function daum_post() {
       new daum.Postcode({
           oncomplete: function(data) {
            $('[name=post]').val( data.zonecode );   //우편번호
               //지번 주소 : J, 도로명 주소 : R
               var address = data.userSelectedType == 'J' ? data.jibunAddress : data.roadAddress;   //클릭한 지번주소나, 도로명주소가 저장됨
               if(data.buildingName != '') {
               address += ' (' + data.buildingName + ')';   //건물 명이 있으면 건물 명을 붙여줌
               }
               $('[name=address2]').eq(0).val( address );
           }
       }).open();
   }
   </script>
 
<script>
/*     const { IMP } = window; */
    $(document).ready(function(){
       $(document).on("click", "button[name='orderbtn']", function() {
          kaja();
       })
    });                               
      
      function kaja(data){
      IMP.init('imp23174441');   
       IMP.request_pay({
           pg : 'html5_inicis',
           pay_method : 'card',
           merchant_uid : 'merchant_' + new Date().getTime(),
           name : "${cvlist[0].name}"+"외"+"${cvlist.size()-1}"+"개",
           amount : $('input[name=totPrice]').val(),
           buyer_email : $('input[name=id]').val(),
           buyer_name : $('input[name=name]').val(),
           buyer_tel : $('input[name=tel]').val(),
           buyer_addr : $('input[name=post]').val() + $('input[name=address2]').val() + $('input[name=address3]').val(),
   /*         buyer_postcode : '123-456'*/
         }, function(rsp) {
           if ( rsp.success ) {
              $.ajax({
                url : "order.do",// url : "hello.jsp" //open(method,url,async)
                data : { //json (jaavscript object notation)
                   id : $('input[name=id]').val(),//open,send,name:value
                   address1 : $('input[name=post]').val(),
                   address2 : $('input[name=address2]').val(),
                   address3 : $('input[name=address3]').val(),
                   tel : $('input[name=tel]').val(),
                   totPrice : $('input[name=totPrice]').val(),
                   deliveryMessage : $('select[name=deliveryMessage]').val(),
                   point : $('input[name=point]').val()
                //kaja.jsp?irum=hong&na2=35
                }, //<input type="text" name="irum"
                dataType : "text",//responseText, responseXML
                type : "post",//open
                success : function(result1) {// json //4,200 //메소드 2형식 정의문
                  alert("응답받는 다는 " + result1);

                  location.href = "orderlist.do?mem_id=${mv.id}";    
                },
                error : function(xhr1, status) {
                   alert("에러상대 : " + "\t" + xhr1.status);//statusText
                   
                }
             });//$.ajax-end
           
               var msg = '결제가 완료되었습니다.';
               msg += '고유ID : ' + rsp.imp_uid;
               msg += '상점 거래ID : ' + rsp.merchant_uid;
               msg += '결제 금액 : ' + rsp.paid_amount;
               msg += '카드 승인번호 : ' + rsp.apply_num;
               alert(msg);
               
           } else {
               var msg = '결제에 실패하였습니다.';
               msg += '에러내용 : ' + rsp.error_msg;
               alert(msg);
           }
   
           
       });
      }
</script>
</body>
</html>