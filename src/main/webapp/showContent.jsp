<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>><c:out value="${sessionScope.postTitle}"/></h1>
    <textarea cols="50" rows="10" disabled>
        <c:out value="${postContent}"/>
    </textarea>
</body>
<button type="button" onclick="location.href='board.jsp';"><fmt:message key="backpage" bundle="${msg}" /></button>
</html>
