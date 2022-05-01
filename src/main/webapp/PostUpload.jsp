<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${lang}"/>


<html>
<head>
    <title>Title</title>
</head>
<form method="post" action="/postUpload.do">
    <fmt:message key="title" bundle="${msg}" /> : <span><input type="text" name="title"></span><br>
    <fmt:message key="context" bundle="${msg}" /> : <textarea name="context" cols="50" rows="10">
</textarea><span><button type="submit"><fmt:message key="upload" bundle="${msg}" /></button></span>
</form>
<body>
</body>
</html>
