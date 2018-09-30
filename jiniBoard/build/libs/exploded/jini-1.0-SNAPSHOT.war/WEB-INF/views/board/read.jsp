<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: SEJIN
  Date: 2018-09-30
  Time: 오후 4:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글보기</title>
</head>
<body>
<h3>게시판</h3>
<table >
    <tr>
        <td>글쓴이</td>
        <td>${board.writer}</td>
    </tr>
    <tr>
        <td>제목</td>
        <td>${board.title}</td>
    </tr>
    <tr>
        <td>내용</td>
        <td><textarea name="content" id="content" cols="30" rows="10">
        ${board.content}
        </textarea> </td>
    </tr>
    <a href="/board/delete/${board.id}">삭제</a>
</table>
<a href="/board/modifyform/${board.id}">수정</a>
</body>
</html>
