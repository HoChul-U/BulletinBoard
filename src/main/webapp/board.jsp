<%@ page import="java.util.List" %>
<%@ page import="com.nhnacademy.data.User" %>
<%@ page import="com.nhnacademy.data.UserData" %>
<%@ page import="com.nhnacademy.board.PostData" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/logout.do">Logout</a><br>
<c:if test="checkAdmin"/>
<table title="게시판" border="1px">
    <thead>
    <tr>
        <th>제목</th>
        <th>번호</th>
        <th>글쓴이</th>
        <th>업로드 시간</th>
        <th>글읽은수</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="post" items="${posts}">
        <tr>
            <td>${post.title}</td>
            <td>${post.id}</td>
            <td>${post.writerUserId}</td>
            <td>${post.writeTime}</td>
            <td>${post.viewCount}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<button type="button" onclick="location.href='PostUpload.jsp';">게시판 내용 추가</button>

</body>
</html>
