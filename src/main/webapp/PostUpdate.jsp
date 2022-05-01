<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${lang}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/postUpdate.do">
    <fmt:message key="title" bundle="${msg}" /> : <span><input type="text" name="update_title"></span><br>
    <fmt:message key="context" bundle="${msg}" /> : <textarea name="update_context" cols="50" rows="10"></textarea>
    <span><button type="submit"><fmt:message key="upload" bundle="${msg}" /></button></span>
</form>
<button type="button" onclick="location.href='board.jsp';"><fmt:message key="cancel" bundle="${msg}" /></button>
</body>
</html>
