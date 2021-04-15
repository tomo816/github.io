<%@page import="model.UserInfoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="model.UserInfoDto"%>
<%@ page import="model.textDto" %>
<%UserInfoDto userInfo= (model.UserInfoDto)request.getAttribute("userInfo"); %>
<%List<textDto> message = (ArrayList<model.textDto>)request.getAttribute("message"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>twitter</title>
<link rel="stylesheet" href="/twitter/css/Home.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
</head>
<body>
<div class="top-wrapper">

<img class="userImage" src="<%=userInfo.getProfileImage() %>">

<div class="userInfo">
<p><%=userInfo.getUserId()%></p>
<p><%=userInfo.getUserName() %></p>
</div>
<div class="varietyBtn">
<a href="<%=request.getContextPath() %>/uploadPage">アカウント設定</a>
<a href="<%= request.getContextPath() %>/logOut" class="logOut">ログアウト</a>
</div>

</div>

<a href="<%=request.getContextPath() %>/submitService">
<img src="file:///C:/WorkSpace(改)/twitter/src/controller/Twitter_Social_Icon_Circle_Color.png" width="50" height="50" class="upload">
</a>


<%
    for (int i = 0; i < message.size(); i++) {
    	textDto dto= message.get(i);
    	int deleteNumber =i+1;
    	%>
<div class="textFlame">
<img  class="userImage" src="<%=dto.getProfileIcon()%>">
<div class="userInfo">
<p><%=dto.getUserName() %></p>
<p><%=dto.getText() %></p>
</div>
<p class="writingTime"><%=dto.getInsert_date() %></p>
<form action="<%=request.getContextPath() %>/home" method="post">
<input type="hidden" value="<%= dto.getText() %> " name="deleteText">
<input type="hidden" value="<%=dto.getUserName() %>" name="deleteUser">
<input type="hidden" value="<%=dto.getInsert_date() %>" name="deleteTime">
<input type="hidden" value="<%=userInfo.getUserName() %>" name="UserName">
<input type="submit" value="削除" name="deleteBtn" onclick="return deleteCheck()" class="deleteBtn">
</form>
</div>

<%} %>


<script type="text/javascript" src="${pageContext.request.contextPath}/js/myhomeEdit.js">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/userImg.js">
</script>

</body>
</html>