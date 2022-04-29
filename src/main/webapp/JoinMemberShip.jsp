<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<h1>회원 가입</h1><br>
<span>
    <form method="post" action="/membership.do">
        <span>ID를 입력하세여<input type="text" name="id"><br></span>
        <span>PWD를 입력하세요<input type="text" name="pwd"><br></span>
        <span>이름을 기입하세요<input type="text" name="name"><br></span>
        <span>사진을 기입하세요<input type="file" name="profile"></span><br>
        <button type="submit">회원가입</button>
    </form>

</span>
</body>
</html>
