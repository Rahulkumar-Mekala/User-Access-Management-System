<%@page import="Register.UserBean"%>
<%@page import="java.util.List"%>
<%@page import="Register.UserBeanDAO"%>
<%@page import="Manager.ManagerBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manager Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            color: #333;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #4CAF50;
            color: white;
            padding: 20px;
            text-align: center;
        }
        .section {
            margin: 20px auto;
            width: 80%;
            border-radius: 5px;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
            padding: 15px;
        }
        .pending {
            background-color: #e3f9e5; /* Light Green for Pending */
        }
        .approved {
            background-color: #e1f5fe; /* Light Blue for Approved */
        }
        .rejected {
            background-color: #ffe0e0; /* Light Red for Rejected */
        }
        h3 {
            color: #333;
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid black;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        td a {
            text-decoration: none;
            color: white;
            padding: 6px 12px;
            border-radius: 4px;
            margin: 0 5px;
            display: inline-block;
        }
        td a.approve {
            background-color: #4CAF50;
        }
        td a.approve:hover {
            background-color: #45a049;
        }
        td a.reject {
            background-color: #f44336;
        }
        td a.reject:hover {
            background-color: #e53935;
        }
        .no-requests {
            font-size: 1.1em;
            text-align: center;
            color: #ff6347;
            margin: 10px 0;
        }
     .welcome-message {
    text-align: center;
    font-family: serif;
    color: blue; 
    margin: 30px;
}

    </style>
</head>

<body>

<header>
    <h1>Manager Dashboard</h1>
</header>

<%
ManagerBean managerBean = (ManagerBean) session.getAttribute("abean");
if (managerBean != null) {
     out.println("<div class='welcome-message' >Welcome Manager: " + managerBean.getUsername() + "</div>");

    UserBeanDAO userBeanDAO = new UserBeanDAO();
    List<UserBean> pendingRequests = userBeanDAO.getPendingRequests();
    List<UserBean> approvedRequests = userBeanDAO.getApprovedServet();
    List<UserBean> rejectedRequests = userBeanDAO.getRejectRequestServelt();

    // Pending Requests Section
    out.println("<div class='section pending'>");
    out.println("<h3>Pending Requests</h3>");
    if (pendingRequests.isEmpty()) {
        out.println("<div class='no-requests'>No pending requests.</div>");
    } else {
        out.println("<table>");
        out.println("<tr><th>ID</th><th>Username</th><th>Password</th><th>Role</th><th>Status</th><th>Actions</th></tr>");
        for (UserBean user : pendingRequests) {
            out.println("<tr>");
            out.println("<td>" + user.getId() + "</td>");
            out.println("<td>" + user.getUsername() + "</td>");
            out.println("<td>" + user.getPassword() + "</td>");
            out.println("<td>" + user.getRole() + "</td>");
            out.println("<td>" + user.getStatus() + "</td>");
            out.println("<td>");
            out.println("<a href='approveRequest?id=" + user.getId() + "' class='approve'>Approve</a>");
            out.println("<a href='rejectRequest?id=" + user.getId() + "' class='reject'>Reject</a>");
            out.println("</td>");
            out.println("</tr>");
        }
        out.println("</table>");
    }
    out.println("</div>");

    // Approved Requests Section
    out.println("<div class='section approved'>");
    out.println("<h3>Approved Requests</h3>");
    if (approvedRequests.isEmpty()) {
        out.println("<div class='no-requests'>No approved requests.</div>");
    } else {
        out.println("<table>");
        out.println("<tr><th>ID</th><th>Username</th><th>Password</th><th>Role</th><th>Status</th></tr>");
        for (UserBean user : approvedRequests) {
            out.println("<tr>");
            out.println("<td>" + user.getId() + "</td>");
            out.println("<td>" + user.getUsername() + "</td>");
            out.println("<td>" + user.getPassword() + "</td>");
            out.println("<td>" + user.getRole() + "</td>");
            out.println("<td>" + user.getStatus() + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
    }
    out.println("</div>");

    // Rejected Requests Section
    out.println("<div class='section rejected'>");
    out.println("<h3>Rejected Requests</h3>");
    if (rejectedRequests.isEmpty()) {
        out.println("<div class='no-requests'>No rejected requests.</div>");
    } else {
        out.println("<table>");
        out.println("<tr><th>ID</th><th>Username</th><th>Password</th><th>Role</th><th>Status</th></tr>");
        for (UserBean user : rejectedRequests) {
            out.println("<tr>");
            out.println("<td>" + user.getId() + "</td>");
            out.println("<td>" + user.getUsername() + "</td>");
            out.println("<td>" + user.getPassword() + "</td>");
            out.println("<td>" + user.getRole() + "</td>");
            out.println("<td>" + user.getStatus() + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
    }
    out.println("</div>");
} else {
    out.println("<div class='no-requests'>No manager logged in.</div>");
}
%>

</body>
</html>
