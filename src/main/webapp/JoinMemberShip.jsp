<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${lang}"/>


<html>
<head>
    <title>회원가입</title>
</head>
<body>
<h1><fmt:message key="membership" bundle="${msg}"/></h1><br>
<span>
    <form method="post" action="/membership.do" enctype="multipart/form-data">
        <span><fmt:message key="inputID" bundle="${msg}"/> <input type="text" name="id"><br></span>
        <span><fmt:message key="intputPWD" bundle="${msg}"/> <input type="text" name="pwd"><br></span>
        <span><fmt:message key="inputName" bundle="${msg}"/> <input type="text" name="name"><br></span>
        <span><fmt:message key="inputProfile" bundle="${msg}"/> <input type="file" name="profile" enctype="multipart/form-data" required></span><br>
        <button type="submit"><fmt:message key="membership" bundle="${msg}"/></button>
    </form>
</span>
</body>
</html>
