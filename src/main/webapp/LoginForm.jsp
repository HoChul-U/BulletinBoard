<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>loginForm</title>
</head>
<body>
<form method="post" action="/board.do">
    <span>id: <input type="text" name="id" /></span><br/>
    <span>pwd: <input type="text" name="password" /></span><br/>
    <input type="submit" value="login">
    <button type="button" onclick="location.href='JoinMemberShip.jsp';">회원가입</button>
</form>

</body>
</html>
