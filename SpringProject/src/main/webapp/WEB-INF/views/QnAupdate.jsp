<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${qnaupdate.qnaTitle } - 게시글 수정</title>
<%@include file="Header.jsp" %>
<style>
* {
	margin: 4px 0;
}

.controller {
	padding: 25px 0;
	margin: auto;
	width: 800px;
}

#wriTitle{
	text-align: center;
	background-color: rgb(100, 100, 100);
	width: 800px;
	height: 50px;
	padding: 12px 0;
	color: white;
}
table {
	width: 800px;
	margin: 25px 0;
	padding: 20px;
	border-collapse: collapse;
}

#category {
	width: 100px;
	height: 30px;
}

#title {
	width: 700px;
	height: 24px;
}

textarea {
	width: 800px;
	height: 400px;
}
.button {
	width: 100px;
	padding: 5px 12px;
	border: none;
	background-color: gray;
	color: white;
}

button {
	padding: 5px 12px;
	background-color: white;
	border-color: rgb(180, 180, 180);
	border-width: 1px;
}

textarea {
	resize: none;
}
</style>
</head>
<body>
	<div class="controller">
	<div id="wriTitle"><b>게시글 수정</b></div>
		<form action="qupdate.do" method="post">
			<table>
				<tr>
					<td width="100px">카테고리</td>
					<td><select name="qnaCategory" id="category" >
							<option>상품문의</option>
					<c:if test="${qnaupdate.qnaCategory.equals('배송문의') }">
						<option selected>배송문의</option>
					</c:if>
					<c:if test="${!qnaupdate.qnaCategory.equals('배송문의') }">
						<option>배송문의</option>
					</c:if>
					<c:if test="${qnaupdate.qnaCategory.equals('기타') }">
						<option selected>기타</option>
					</c:if>
					<c:if test="${!qnaupdate.qnaCategory.equals('기타') }">
						<option>기타</option>
					</c:if>
					
					</select></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" name="qnaTitle" required id="title" value="${qnaupdate.qnaTitle }" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
					<textarea rows="12" cols="50" name="qnaContent" required>${qnaupdate.qnaContent }</textarea>
					</td>
				</tr>
				<tr>
					<th align="center"><input type="submit" value="작성" class="button"></th>
					<th align="center"><input type="reset" value="수정 초기화" class="button"></th>
				</tr>
			</table>
			<div style="display: none;" >
				<input type="text" name="qnaId" value="${qnaupdate.qnaId }" />
			</div>
		</form>
		<div>
			<a href="QnA.do">
				<button>목록</button>
			</a>
		</div>
		<div>
			<a href="index.do">
				<button>홈으로</button>
			</a>
		</div>
	</div>
	<%@include file="footer.jsp" %>
</body>
</html>