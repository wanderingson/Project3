<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="Header.jsp"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> --%>
<% pageContext.setAttribute("replace1", "\n"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/product.css">


<script >
function count(type)  {
	  // 결과를 표시할 element
	  const result = document.getElementById('number1');
	  const total = document.getElementById('total');
	  
	  // 현재 화면에 표시된 값
	  let number = result.innerText;
	  let price = result.innerText;
	  
	    if(type == 'plus') {
	      number = parseInt(number) + 1;
	      price = parseInt(${allproduct.price})*parseInt(number);
	      allbasket.totalmoney.value=price;
	      allbasket.allselect.value=number;
	      
	    }else if(type == 'minus')  {
	      if(number >1){
	          number = parseInt(number) - 1;
	          price = parseInt(${allproduct.price})*parseInt(number);
	          allbasket.totalmoney.value=price;
	          allbasket.allselect.value=number;
	      }
	      else{
	    	  price = ${allproduct.price};
	      }
	    }
	  
	  
	  // 결과 출력
	  result.innerText = number;
	  total.innerText = price;
  }



<!-- <script> --> 
	
	

   $(document).ready(function () {
	  $("#basket").click(function () {
		var memid = '${sessionScope.sid}';
		
		
		if(memid == ""){
	    alert('회원만이 장바구니 추가가 가능합니다');
	    }
	    else if(memid != ""){
	    var name = $("#basketname").val();
	    var num = $("#allselect").val();
	    $.ajax({
	    	url : "basketplus.do",
	    	type : 'post',
	    	data :{
	    		id : memid,
	    		name : name,
	    		num : num
	    	},
	    	success : function(data) {
	    						
	         },
	         error:function(request, status, error){
	        	 alert('장바구니에 추가되었습니다');

	     	}
	    });
		
	     }
	  });
	});
 

</script>


</head>
<body><!-- 상품상세내역창 -->
  <div class="container">
    <div class="row" style="padding-top: 30px;">
      <div align="center"  class="col-xl-6">
        <img src="./img/${allproduct.product}.jpg" style="width: 400px; height: 500px;" /> <!-- ${name} -->
      </div>
      <div class="col-xl-6">
        <div class="row" id="div1">새벽배송</div>
        <div class="row" id="name">${allproduct.product}</div>
        <div class="row" style="padding-top: 10px;">
         <span style="padding: 0px;">
          <font class="price1" id="money">${allproduct.price}</font> 
          <font class="price2">원</font>
          </span>
        </div>
        <div class="row" style=" padding-top: 25px;" >
          <hr class="hr1"/>
        </div>
        <div class="row">
          <div class="col-xl-2"  id="send1">배송</div>
          <div class="col-xl-10">
            <p>새벽배송</p>
            <p class="p1">23시 전 주문 시 내일 아침 7시 전 도착</p>
          </div>
          <div class="row">
            <hr class="hr1"/>
          </div>
          <div class="col-xl-2"  id="send1">판매자</div>
          <div class="col-xl-10">
            <p>배고플땐</p>
          </div>
          <div class="row">
            <hr class="hr1"/>
          </div>
          <div class="col-xl-2"  id="send1">포장타입</div>
          <div class="col-xl-10">
            <p>종이포장</p>
          </div>
          <div class="row">
            <hr class="hr1"/>
          </div>
          <div class="col-xl-2"  id="send1">상품선택</div>
          <div class="col-xl-10">
            <div class="border border-1 border-dark p-1" style="width: 340px; --bs-border-opacity: .1;">
              <div style="padding-left: 5px;">
                <span class="sel1">${allproduct.product}</span>
                <div id="count">
                  <button id="minus" class="btn btn-light" onclick='count("minus")'>-</button>
                  <span id="number1">1</span>
                  <button id="plus" class="btn btn-light" onclick='count("plus")'>+</button>
                </div>
              </div>
            </div>
          </div>
          <div class="row" style="padding-top: 30px;">
            <hr class="hr1"/>
          </div>
        </div>
      	<div id="div2">      	  
      	  <span id="tmes1">총 상품금액</span>
      	  <span id="total">${allproduct.price}</span>
      	  <span id="tmes2">원</span>
      	</div>
      	<form name="allbasket">
      	  <div id="div3">
      	    <button type="button" class="btn btn-secondary" id="basket" name="bas">
      	      <span class="basketmes">장바구니 담기</span>
      	    </button>
      	  </div>
      	  <input type="hidden" id="totalmoney" value="${allproduct.price}">
      	  <input type="hidden" id="allselect" value="1">
      	  <input type="hidden" id="basketname" value="${allproduct.product}">
      	</form>
      </div>
    </div>
    <div class="row" style="padding-top: 100px">
      <hr class="centerline"/>
    </div>
 	<div class="row" style="padding-top: 80px" align="center">
 	  <div><h1>상품설명</h1></div>
      <div><img src="./img/${allproduct.product}.jpg" style="width: 700px; height: 1000px; padding-top: 50px;"/></div>
 	</div>
 	<div class="row" align="center" style="padding-top: 80px">
 	  <h3>${allproduct.product}</h3>
 	</div>
 	<div class="row" style="padding-top: 20px">
      <hr class="centerline"/>
      	<p style="padding-top: 3px; font-size: 20px; text-align: center;">${fn:replace(allproduct.descrip,replace1,"<br/>")}</p>
    </div>
    <div class="row" style="padding-top: 50px; ">
      <hr color="black"style="margin: 0px;"/>
      <div style="padding-top: 50px; ">
        <h2>고객센터</h2>
        <h5>궁금하신 점이나 서비스 이용이에 불편하신 점이 있으신가요?</h5>
        <font style="color: #666666; font-weight: 200; font-size: 17px;">
          문제되시는 부분은 아래중 편하신 방법으로 문의 주시면 빠르게 도와드리겠습니다
        </font>
        <div style="padding-top: 30px;" class="row">
          <div class="col-xl-6">
            <div style="font-size: 20px; font-weight: 600;">
              전화문의  1234-5678
            </div>
            <div style="padding-top: 14px; font-weight: 400;">
		  	  영업시간  AM 10:00 ~ PM 17:00(주말 및 공휴일휴무)
			</div>
			<div style="padding-top: 14px; font-weight: 400;">
		  	  점심시간  PM 12:30 ~ PM 13:30
			</div>
          </div>
          <div class="col-xl-6">
            <div style="font-size: 20px; font-weight: 500;">
              홈페이지 문의
            </div>
            <div style="padding-top: 14px; font-weight: 400;">
              365일
            </div>
            <div style="padding-top: 14px; font-weight: 400;">
              홈페이지 상단의 고객센터에서의 1:1문의
            </div>
            <div style="font-weight: 200; padding-top: 14px;">
              고객센터 운영시간에 순차적으로 <br />
              답변해드리겠습니다
            </div>
          </div>
        </div>
        <br /><br /><br />
        <div class="border border-2 border-dark p-2" style="--bs-border-opacity: .2;">
            <font style="padding: 10px; font-size: 18px; font-weight: 600;">
              환불안내
            </font>
            <font style="font-weight: 200;">환불이 필요하신경우 마이페이지에서</font>
            <font style="font-weight: 200;">주문목록창에 있는 환불신청을 통해 환불이 가능합니다</font>
        </div>
      </div>
    </div>
    
    <div style=" padding-top: 70px;">
      <hr color="black"style="margin: 0px;"/>
    </div>
    
    <div class="row" style="padding-top: 50px">
      <div><h1>상품후기</h1></div>
      <hr color="black"style="margin: 0px;"/>
  	      <div class="row" align="center">
  	        <div class="col-xl-3">아이디</div>
  	        <div class="col-xl-6">후기내용</div>
  	        <div class="col-xl-3">작성일</div>
  	      </div>
      <hr color="black"/>
      <c:forEach items="${preview}" var="review">
  	      <div class="row" align="center">
  	        <div class="col-xl-3"><p>${review.id}</p></div>
  	        <div class="col-xl-6"><p>${fn:replace(review.review,replace1,"<br/>")}</p></div>
  	        <div class="col-xl-3"><p>${review.date1}</p></div>
  	      </div>
        <hr color="black"/>
      </c:forEach>
    </div>
 	   
  </div>
 
  
  



<%@ include file="footer.jsp"%>
</body>
</html>