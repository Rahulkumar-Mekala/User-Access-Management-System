<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Profile Update Status</title>
</head>
<body>
    <h2>Profile Update Status</h2>
    <% 
        String fname = (String) request.getAttribute("fname");
        String msg = (String) request.getAttribute("msg");
        if (fname != null) {
            out.println("This page belongs to: " + fname);
        }
        if (msg != null) {
            out.println("<br>" + msg);
        }
    %>
    <a href="view"><button>View Profile</button></a>&nbsp;&nbsp;&nbsp;
    <a href="Logout"><button>Logout</button></a>
</body>
</html>
