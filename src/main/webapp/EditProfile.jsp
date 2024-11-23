<%@page import="Register.UserBean"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Profile</title>
    <style type="text/css">
        body { text-align: center; background: silver; padding: 20px; }
        .edit { background: white; margin-left: 400px; margin-right: 400px; padding: 50px; border-radius: 20px; }
        .button { background: white; color: black; border-radius: 20px; }
        .button:hover { background: blue; color: white; }
    </style>
</head>
<body>
<div class="edit">
    <h2>Update Profile Details:</h2>
    <% 
        UserBean bean = (UserBean) application.getAttribute("ubean");
        String str = (String) request.getAttribute("fname");
        if (str != null) {
            out.println("This Page Belongs to: " + str);
        }
    %>

    <form action="update" method="post">
          <label>Password: </label>
        <input type="password" name="password" value="<%= bean != null ? bean.getPassword() : "" %>"><br><br>
      
        <input class="button" type="submit" value="Update Profile">
    </form>
</div>
</body>
</html>
