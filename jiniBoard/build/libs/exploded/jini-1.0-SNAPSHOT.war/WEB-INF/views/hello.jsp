<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h3>게시판</h3>
<a href="/board/registerform">글등록</a>
<table >
    <tr>
        <td>글번호</td>
        <td>제목</td>
        <td>글쓴이</td>
        <td>등록일</td>
    </tr>
    <c:if test="${boardList != null}">
        <c:forEach items = "${boardList}" var="board">
            <tr >
                <td>${board.id}</td>
                <td><a href="/board/read/${board.id}">${board.title}</a></td>
                <td>${board.writer}</td>
                <td>${board.regdate}</td>
            </tr>
        </c:forEach>

    </c:if>

</table>
</body>
</html>