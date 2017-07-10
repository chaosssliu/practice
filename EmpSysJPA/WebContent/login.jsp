<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Successfully</title>
</head>
<body>
<p align="center"><font size="15">
<%
if (session != null) {
	if (session.getAttribute("username") != null) {
		String username = (String) session.getAttribute("username");
		out.print("Welcome " + username);
	} else {
		response.sendRedirect("index.jsp");
	}
}
%></font></p>
<br>

<p align="center"><a href="LogoutServlet">Logout</a></p>
<p align="center"><a href="LoadListDept">Add Department</a></p>
<p align="center"><a href="LoadListEmp">Add Employee</a></p>


</body>
</html>