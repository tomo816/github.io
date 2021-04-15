<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
<h1>ログイン画面</h1>
<span class="error">IDまたはPASSWORDが間違っています</span>
<form action="<%=request.getContextPath() %>/login" method="post">
<p>userId
<br><input type="text" maxlength="20" name="USER_ID">
</p>
<p>パスワード
<br><input type="password" maxlength="20" name="PASSWORD">
</p>
<input type="submit" value="ログイン">
</form>
<a href="<%=request.getContextPath() %>/enroll">会員登録がまだの人はこちら</a>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/non_info.js"></script>
</body>
</html>