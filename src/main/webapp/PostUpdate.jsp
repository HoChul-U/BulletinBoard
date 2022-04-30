<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/postUpdate.do">
    제목 : <span><input type="text" name="update_title"></span><br>
    본문 : <textarea name="update_context" cols="50" rows="10"></textarea>
    <span><button type="submit">Upload</button></span>
</form>

<button type="button" onclick="location.href='board.jsp';">취소</button>
</body>
</html>
