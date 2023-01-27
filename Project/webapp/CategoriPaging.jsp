    <%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<style type="text/css">

#paging{
	text-align:center;
    font-size: 22pt;
}
</style>
</head>
<body>
<div id="paging">
<!-- 1~10까지 있는 페이지의 페이징 -->
<c:url var="action" value="bigtitle.do"/>
<c:if test="${param.prev}">
    <a href="${action}?page=${param.beginPage-1}&title=${param.title}">prev</a>
</c:if>
<c:forEach begin="${param.beginPage}" end="${param.endPage}" step="1" var="index">
    <c:choose>
        <c:when test="${param.page==index}">
            ${index}
        </c:when>
        <c:otherwise>
            <a href="${action}?page=${index}&title=${param.title}">${index}</a>
        </c:otherwise>
    </c:choose>
</c:forEach>
<c:if test="${param.next}">
    <a href="${action}?page=${param.endPage+1}&title=${param.title}">next</a>
</c:if>
</div>
