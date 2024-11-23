<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	display: flex;
	justify-content: center;
	align-items: center;
	 text-align: center;

}
</style>
</head>
<body>
<div >
<%String msg = (String)request.getAttribute("msg");
out.println(msg);%>
<%@include file="UserRegistration.html" %>
</div>
</body>
</html>