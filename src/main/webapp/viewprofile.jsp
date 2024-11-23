
<%@page import="Register.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Profile</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        text-align: center;
    }
    table {
        margin: 20px auto;
        width: 80%; 
        border-collapse: collapse;
        background-color: #fff;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }
    th, td {
        padding: 12px 15px;
        border: 1px solid #ddd;
        text-align: center;
    }
    th {
        background-color: #0073e6;
        color: white;
        font-weight: bold;
    }
    td {
        background-color: #f9f9f9;
    }
    tr:hover {
        background-color: #f1f1f1;
    }
    button {
        margin: 10px 5px;
        padding: 10px 20px;
        background-color: #0073e6;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
    }
    button:hover {
        background-color: #005bb5;
    }
    .actions {
        margin-top: 20px;
    }
</style>
</head>
<body>

<%
    UserBean userBean = (UserBean) application.getAttribute("ubean");
    String str = (String) request.getAttribute("fname");
    out.println("<h2>Page belongs to: " + str + "</h2>");
    if (userBean != null) {
%>
<table>
    <tr>
        <th>Username</th>
        <th>Password</th>
        <th>Role</th>
        <th>Status</th>
    </tr>
    <tr>
        <td><%= userBean.getUsername() %></td>
        <td><%= userBean.getPassword() %></td>
        <td><%= userBean.getRole() %></td>
        <td><%= userBean.getStatus()%></td>
    </tr>
</table>

<div class="actions">
    <a href="edit" target="black"><button>Edit</button></a>

    <a href="Logout" target="black"><button>Logout</button></a>

</div>
<%
    } else {
        out.println("<p>No user data available.</p>");
    }
%>

</body>
</html>