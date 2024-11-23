<%@page import="Register.UserBean"%>
<%@page import="java.util.List"%>
<%@page import="Register.UserBeanDAO"%>
<%@page import="AdminLogin.AdminBean"%>
<%@page import="Manager.ManagerBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manager Dashboard</title>
</head>

<body>
<%
ManagerBean managerBean = (ManagerBean) session.getAttribute("abean");
if (managerBean != null) {
    out.println("Welcome Manager: " + managerBean.getUsername() + "<br>");
    
    UserBeanDAO userBeanDAO = new UserBeanDAO();
    List<UserBean> pendingRequests = userBeanDAO.getPendingRequests();

    if (pendingRequests.isEmpty()) {
        out.println("No pending requests.<br>");

    
} else {
    out.println("<h3>Pending Access Requests:</h3>");
    out.println("<table border='1'><tr><th>Username</th><th>Role</th><th>Actions</th></tr>");
    
    
    

    for (UserBean user : pendingRequests) {
        out.println("<tr>");
        out.println("<td>" + user.getUsername() + "</td>");
        out.println("<td>" + user.getRole() + "</td>");
        out.println("<td>");
        out.println("<a href='approveRequest?id=" + user.getId() + "'>Approve</a>");
        out.println(" | ");
        out.println("<a href='rejectRequest?id=" + user.getId() + "'>Rej</a>");
        out.println("</td>");
        out.println("</tr>");
    }
    out.println("</table>");
}
} else {
out.println("No manager logged in.<br>");
}
%>


</body>
</html>
