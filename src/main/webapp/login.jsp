<%@page import="Register.UserBean"%>
<%@page import="AdminLogin.AdminBean"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%UserBean userbean= (UserBean) application.getAttribute("ubean");
out.println(" This Page belong to : "+userbean.getUsername());%>
<br><br>

<a href="view" target="black"><button>View Profile</button></a>

</body>
</html>