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
    <title>글등록</title>
</head>
<body>
<h3>게시판</h3>
<form action="/board/register" method="post">
<table >
    <tr>
        <td>글쓴이</td>
        <td><input name="writer" type="text"> </td>
    </tr>
    <tr>
        <td>제목</td>
        <td><input name="title" type="text"> </td>
    </tr>
    <tr>
        <td>내용</td>
        <td><textarea name="content" id="content" cols="30" rows="10"></textarea> </td>
    </tr>
</table>
    <button type="submit">글등록</button>
</form>
</body>
</html>
