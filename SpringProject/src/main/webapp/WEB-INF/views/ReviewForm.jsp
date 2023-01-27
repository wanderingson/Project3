<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기작성 페이지</title>
<style>

table{
	margin-left:auto;
	margin-right:auto;
	width : 700px;	 
}

.trclass{
	border: 1px solid #DCDCDC;
	border-right:none;
	border-left:none;	
}

.product{
	border-right:none;
	border-left:none;
	border-top:none;
	border-bottom:none;
}



th{
	text-align:center;
	width: 200px;
	background-color: #F5F5F5;
	
}

.tdclass{
	width: 500px;
}

textarea {
    width: 100%;
    height: 6.25em;
    resize: none;
}



</style>

</head>
<body>
	
<section>
	<article class="card-body" style="max-width:800px; margin: auto;">
		<br>
		<h1 style="text-align: center;">후기 작성</h1>
		<hr>
		<form action="review.do">
		<table>
			<tr class="trclass">
				<th style="height:50px">상품명</th>
				<td class="tdclass">
					<input type ="text" class="form-control" value="${product_name }"
	               				name ="product_name" maxlength='20' readonly>
					<input type="hidden" name="mem_id" value="${sessionScope.sid}">
					<input type="hidden" name="order_details_num" value="${order_details_num }">
	          	</td>
			</tr>
			<tr class="trclass">
				<th>후기작성</th>
				<td class="tdclass">
					<textarea name="review" class="form-control" placeholder="제품에 대한 후기를 남겨주세요." rows=10 cols=80
					style="height: 500px"></textarea></td>
			</tr>	
		</table>
		<br>
		<div style="text-align: center;">
			<input type="submit" class="btn btn-secondary btn-lg" value="상품후기작성">
		</div>
		
		</form>
	</article>
</section>		

</body>
</html>