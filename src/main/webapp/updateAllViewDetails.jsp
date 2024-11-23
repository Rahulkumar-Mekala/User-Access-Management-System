
<%@page import="Manager.ManagerBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
<table>
<tr>
<th> Employee ID</th>
<th> UserName :</th>
<th> Password :</th>
<th> Role</th>
<th> Status</th>
<th> Update & Delete </th>

</tr>

<%
ManagerBean bean = (ManagerBean)session.getAttribute("abean");
ArrayList<ManagerBean> arrayList = (ArrayList<ManagerBean>)session.getAttribute("alist");
out.println(" Page Belong to Admin "+bean.getUsername()+"<br>");

if(arrayList.size()==0){
	out.println(" Not Product Avalivable...<br>");
}
else{
	Iterator<ManagerBean> iterator= arrayList.iterator();
	while(iterator.hasNext()){
		ManagerBean adminBean= (ManagerBean)iterator.next();
	
		out.println("<tr>"+"<td>"+adminBean.getId()+"</td>"+"&nbsp&nbsp"+"<td>"+adminBean.getUsername()+"</td>"+"&nbsp&nbsp"+"<td>"+adminBean.getPassword()+"</td>"+"&nbsp&nbsp"+"<td>"+adminBean.getRole()+"</td>"+"&nbsp&nbsp"+"<td>"+adminBean.getStatus()+"</td>"+"&nbsp&nbsp"+"<td>&nbsp&nbsp"+"<a href ='updateedit?Email="+adminBean.getUsername()+"'><button>UpdateEdit</button></a>"+"&nbsp&nbsp"+"<a href = 'UpdateDeletepage?Email="+adminBean.getUsername()+"'><button>UpDateDelete</button></a>&nbsp&nbsp;<br>"+"</td>"+"</tr>");
	}
}
%>

</table>
<br>
<a href="AdminLogout" target="_blank"><button>Logout</button></a>
<a href="newUserAdd.html" target="_blank"><button>New Employee ADD</button></a>

</body>
</html>