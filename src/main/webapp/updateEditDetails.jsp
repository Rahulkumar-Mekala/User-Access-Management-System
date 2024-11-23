<%@ page import="Manager.ManagerBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Admin Profile</title>
    <style type="text/css">
        body {
            text-align: center;
            background: silver;
            padding: 20px;
        }
        .edit {
            background: white;
            margin-left: 400px;
            margin-right: 400px;
            padding: 50px;
            border-radius: 20px;
        }
        .button {
            background: white;
            color: black;
            border-radius: 20px;
        }
        .button:hover {
            background: blue;
            color: white;
        }
    </style>
</head>
<body>
    <div class="edit">
        <h2>Update Admin Profile Details:</h2>
        <%
        ManagerBean adminBean = (ManagerBean) session.getAttribute("abean");
                            ManagerBean bean = (ManagerBean) request.getAttribute("ubean");
        %>

        <form action="adminupdateprofile" method="post">
         <label>Username: </label>
            <input  type="hidden" name="username" value="<%= bean.getUsername() %>"><br><br>
           
            <label>Password: </label>
            <input type="password" name="password" value="<%= bean.getPassword() %>"><br><br>
            
            <label>ROLE: </label>
            <select name="role">
                <option value="employee" <%= bean.getRole().equals("employee") ? "selected" : "" %>>Employee</option>
                <option value="manager" <%= bean.getRole().equals("manager") ? "selected" : "" %>>Manager</option>
                <option value="admin" <%= bean.getRole().equals("admin") ? "selected" : "" %>>Admin</option>
            </select><br><br>

            <input class="button" type="submit" value="Update Details">
        </form>
    </div>
</body>
</html>
