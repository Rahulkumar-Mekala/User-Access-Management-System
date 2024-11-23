<%@ page import="Manager.ManagerBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Page</title>
    <style type="text/css">
body {
	display: flex;
	justify-content: center;
	align-items: center;
	 text-align: center;

}
div {
	text-align: center;
	margin:px; 
}
</style>
</head>
<body>
<div>
  <%
  ManagerBean adminBean = (ManagerBean) session.getAttribute("abean");
        String msg = (String) request.getAttribute("msg");
        if (adminBean != null) {
            out.println("Welcome, " + adminBean.getUsername() + "<br>");
        } else {
            out.println("Welcome, Guest<br>");
        }
        out.println(msg);
  %>
</div>
<%@include file="Adminlogin.html" %>
</body>
</html>
