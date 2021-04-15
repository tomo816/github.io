<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>投稿画面</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/new.css">
</head>
<body>
<form action="<%=request.getContextPath() %>/submitService" method="post">
<textarea name="text_body" placeholder="投稿内容を入力してください"></textarea>
<input type="submit" value="送信">
<a href="${pageContext.request.contextPath}/home" class="homeBack">戻る</a>
</form>
</body>
</html>