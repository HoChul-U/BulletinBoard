<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${lang}"/>
<html>
<head>
    <title></title>
</head>
<body>
<span><h1><fmt:message key="adminPage" bundle="${msg}"/></h1></span>
<a href="LoginForm.jsp"><fmt:message key="goLoginPage" bundle="${msg}"/></a>
<table border="1px">
    <thead>
    <tr>
        <th><fmt:message key="adminPage" bundle="${msg}"/></th>
        <th><fmt:message key="name" bundle="${msg}"/></th>
        <th><fmt:message key="profileImg" bundle="${msg}"/></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${sessionScope.userlist}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td><img src="/loadImage.do?file=${user.id}", width="50" height="50"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form method="post" action="/adminMembership.do"  enctype="multipart/form-data">
    <span><fmt:message key="inputID" bundle="${msg}"/><input type="text" name="id" required><br></span>
    <span><fmt:message key="intputPWD" bundle="${msg}"/><input type="text" name="pwd" required><br></span>
    <span><fmt:message key="inputName" bundle="${msg}"/><input type="text" name="name" required><br></span>
    <span><fmt:message key="inputPoto" bundle="${msg}"/><input type="file" name="profile" enctype="multipart/form-data" required></span><br>
    <button type="submit"><fmt:message key="addUser" bundle="${msg}"/></button>
</form>

<form method="post" action="/adminMembershipFix.do" enctype="multipart/form-data">
    <span><fmt:message key="enterIdToQuery" bundle="${msg}"/><input type="text" name="id" required><br></span>
    <span><fmt:message key="enterIdToChange" bundle="${msg}"/><input type="text" name="c_id" required><br></span>
    <span><fmt:message key="enterPwdToChange" bundle="${msg}"/><input type="text" name="pwd" required><br></span>
    <span><fmt:message key="enterNameToChange" bundle="${msg}"/><input type="text" name="name" required ><br></span>
    <span><fmt:message key="inputPoto" bundle="${msg}"/><input type="file" name="profile" required enctype="multipart/form-data"></span><br>
    <button type="submit"><fmt:message key="fixUser" bundle="${msg}"/></button>
</form>

<form method="post" action="/adminMembershipRemove.do">
    <span><fmt:message key="enterIdtoDelete" bundle="${msg}"/><input type="text" name="id"><br></span>
    <button type="submit"><fmt:message key="userDelete" bundle="${msg}"/></button>
</form>
</body>
</html>