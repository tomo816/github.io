<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
<link rel="stylesheet" href="/twitter/css/sample.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
</head>
<body>
<p class="new">新規会員登録</p>
<form action="<%= request.getContextPath() %>/enroll" method="post" >
<p>userId
<br><input type="text" maxlength="20" name="newId" id="userId">
</p>
<p>パスワード
<br><input type="password" maxlength="20" id="passwordOne"  name="newPassword">
</p>
<p>パスワード確認
<br><input type="password" maxlength="20" id="passwordTwo">
</p>
<p>ニックネーム
<br><input type="text" maxlength="20" name="name" id="userName">
</p>
<p>プロフィール画像
<br><input type="file" id="iconUrl">
</p>
<input type="image" alt="file:///C:/WorkSpace(改)/イメージ画像/nanasi.png" class="preview" src="file:///C:/WorkSpace(改)/イメージ画像/nanasi.png" >
<input type="hidden" class="preview" value="file:///C:/WorkSpace(改)/イメージ画像/nanasi.png" name="profileImage">
<br>
<input type="submit" value="新規登録" id="submitBtn">
</form>
<a href="<%=request.getContextPath() %>/login">ログイン画面に戻る</a>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/enroll-error.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/userImg-enroll.js"></script>

</body>
</html>