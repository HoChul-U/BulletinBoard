<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="message" var="msg" scope="session"/>

<html>
<head>
    <title>loginForm</title>
</head>
<body>
<form method="post" action="/board.do">
    <span><fmt:message key="id" bundle="${msg}"/>: <input type="text" name="id"/></span><br/>
    <span><fmt:message key="pwd" bundle="${msg}"/>: <input type="text" name="password"/></span><br/>
    <input type="submit" value="<fmt:message key="login" bundle="${msg}" />">
    <button type="button" onclick="location.href='JoinMemberShip.jsp';"><fmt:message key="membership"
                                                                                     bundle="${msg}"/></button>
</form>
<button type="button" onclick="location.href='/lang.do';"><fmt:message key="language" bundle="${msg}"/></button>
</body>
</html>
