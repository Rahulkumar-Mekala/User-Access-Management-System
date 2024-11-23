
<%@page import="Manager.ManagerBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<style type="text/css">
body {
text-align: center;
	background:  silver;
	padding: 20px;
	
}
.edit{
 
background:  white;
margin-left: 400px;
margin-right: 400px;
padding: 50px;
border-radius: 20px;
}
.button {
	background: white;
	color: black;
	border-radius:20px; 
}
.button:hover {
background: blue;
	color: white;
	
}
</style>
<div class="edit">
<h2> Delete  Admin Profile Details : </h2>
<%
ManagerBean adminBean = (ManagerBean)session.getAttribute("abean");
out.println(" This Page To Admin : "+adminBean.getUsername()+"<br>");
ManagerBean bean = (ManagerBean)request.getAttribute("ubean");
%>
<form action="adminedelete" method="post">
<br>
<label>UserName : </label>
<input type="text" name="username" value=<%=bean.getUsername()%>><br><br>
<label>Password : </label>
<input type="password" name="password" value=<%=bean.getPassword()%>><br><br>
<input class="button" type="submit" value="DeleteDetails">
</form>
</div>
</body>
</html>