<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>여기가 열려야 한다.</title>
</head>
<body>
<span><h1>관리자 화면</h1></span>
<a href="LoginForm.jsp">로그인 페이지로</a>
<table border="1px">
    <thead>
    <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>프로필사진</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${sessionScope.userlist}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form method="post" action="/adminMembership.do">
    <span>ID를 입력하세여<input type="text" name="id"><br></span>
    <span>PWD를 입력하세요<input type="text" name="pwd"><br></span>
    <span>이름을 기입하세요<input type="text" name="name"><br></span>
<%--    <span>사진을 기입하세요<input type="file" name="profile"></span><br>--%>
    <button type="submit">사용자추가</button>
</form>
<form method="post" action="/adminMembershipFix.do">
    <span>조회할 ID를 입력하세여<input type="text" name="id"><br></span>
    <span>변경할 ID를 입력하세여<input type="text" name="c_id"><br></span>
    <span>변경하실 PWD를 입력하세요<input type="text" name="pwd"><br></span>
    <span>변경하실 이름을 기입하세요<input type="text" name="name"><br></span>
<%--    <span>사진을 기입하세요<input type="file" name="profile"></span><br>--%>
    <button type="submit">사용자수정</button>
</form>
<form method="post" action="/adminMembershipRemove.do">
    <span>삭제할 ID를 입력하세요<input type="text" name="id"><br></span>
  <%--    <span>사진을 기입하세요<input type="file" name="profile"></span><br>--%>
    <button type="submit">사용자삭제</button>
</form>
</body>
</html>
