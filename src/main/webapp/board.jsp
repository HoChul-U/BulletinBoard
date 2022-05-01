<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
<fmt:setLocale value="${lang}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><fmt:message key="bulletinBoard" bundle="${msg}"/></h1>
<c:if test="${checkAdmin}">
    <button type="button" onclick="location.href='/adminPage.do';"><fmt:message key="adminPage" bundle="${msg}" /></button>
</c:if>
<table title="게시판" border="1px">
    <thead>
    <tr>
        <th><fmt:message key="title" bundle="${msg}" /></th>
        <th><fmt:message key="number" bundle="${msg}" /></th>
        <th><fmt:message key="writer" bundle="${msg}" /></th>
        <th><fmt:message key="uplaodTime" bundle="${msg}" /></th>
        <th colspan="3"><fmt:message key="veiwCount" bundle="${msg}" /></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="post" items="${posts}">
        <tr>
            <td><a href="/showContent.do?content=${post.id}">${post.title}</a></td>
            <td><a href="/showUsers.do?profile=${post.writerUserId}">${post.id}</a></td>
            <td>${post.writerUserId}</td>
            <td><javatime:format value="${post.writeTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
            <td>${post.viewCount}</td>
            <td>
                <form action="/boardRemove.do" method="post">
                    <input type="hidden" name="postId" value="${post.id}"/>
                    <button type="submit" name="remove_btn" value="${post.writerUserId}"><fmt:message key="remove" bundle="${msg}" /></button>
                </form>
            </td>
            <td>
                <form action="/boardModify.do" method="post">
                    <input type="hidden" name="modifyId" value="${post.id}"/>
                    <button type="submit" name="modify_btn" value="${post.writerUserId}"><fmt:message key="fix" bundle="${msg}" /></button>
                </form>
            </td>

        </tr>
    </c:forEach>
    </tbody>
</table>
<button type="button" onclick="location.href='PostUpload.jsp';"><fmt:message key="addBulletinBoard" bundle="${msg}" /></button>
<button type="button" onclick="location.href='/logout.do';"><fmt:message key="logout" bundle="${msg}"/></button>
</body>
</html>
