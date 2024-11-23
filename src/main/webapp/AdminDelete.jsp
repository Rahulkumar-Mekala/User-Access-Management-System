
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
<%
ManagerBean adminBean = (ManagerBean) session.getAttribute("abean");
out.println(" This Page Be long to "+adminBean.getUsername()+"<br>");
String msg= (String)request.getAttribute("msg");
out.println(msg);
%>
<a href="AllViewDetails">AllViewDetails :</a> 
<a href="AdminLogout">AdminLogout</a>

</body>
</html>