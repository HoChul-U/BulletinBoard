<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>게 시 판</h1>
<c:if test="${checkAdmin}">
    <button type="button" onclick="location.href='/adminPage.do';">관리자 관리창</button>
</c:if>
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
            <td><javatime:format value="${post.writeTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
            <td>${post.viewCount}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<button type="button" onclick="location.href='PostUpload.jsp';">게시판 내용 추가</button>
<button type="button" onclick="location.href='/logout.do';">로그아웃</button>
</body>
</html>
