<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント設定画面</title>
<link rel="stylesheet" href="/twitter/css/sample.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
</head>
<body>

<form action="<%= request.getContextPath() %>/uploadPage" method="post" >
<p>userId
<br><input type="text" maxlength="20" name="newId" id="userUPId">
</p>
<p>パスワード
<br><input type="password" maxlength="20" id="passwordOne"  name="newUPPassword">
</p>
<p>パスワード確認
<br><input type="password" maxlength="20" id="passwordTwo">
</p>
<p>ニックネーム
<br><input type="text" maxlength="20" name="name" id="userUPName">
</p>
<p>プロフィール画像
<br><input type="file" id="iconUrl">
</p>
<input type="image" alt="file:///C:/WorkSpace(改)/イメージ画像/nanasi.png" class="preview" src="file:///C:/WorkSpace(改)/イメージ画像/nanasi.png" >
<input type="hidden" class="preview" value="file:///C:/WorkSpace(改)/イメージ画像/nanasi.png" name="profileUPImage">
<br>
<input type="submit" value="変更" id="submitBtn">
</form>
<a href="<%=request.getContextPath() %>/home">ホーム画面に戻る</a>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/enroll-error.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/userImg-upload.js"></script>

</body>
</html>