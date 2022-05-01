<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" language="java" %>
<fmt:setLocale value="${lang}"/>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Error</title>
</head>
<body>
<fmt:message key="error" bundle="${msg}"/> : <%= exception %>>
</body>
</html>
