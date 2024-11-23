<%@ page import="Manager.ManagerBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Update</title>
</head>
<body>
    <%
    ManagerBean adminBean = (ManagerBean) session.getAttribute("abean");
                out.println("This Page Belongs to " + adminBean.getUsername() + "<br>");
                String msg = (String) request.getAttribute("msg");
                out.println(msg);
    %>
    <br>
    <a href="AllViewDetails" target="_blank"><button>All View Details</button></a>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="AdminLogout" target="_blank"><button>Admin Logout</button></a>
</body>
</html>
