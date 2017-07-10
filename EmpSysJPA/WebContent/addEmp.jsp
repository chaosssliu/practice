<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
	<p align="center">
		<font size="15">
			<%
			if (session != null) {
				if (session.getAttribute("username") != null) {
					String username = (String) session.getAttribute("username");
					out.print("Welcome " + username);
				} else {
					response.sendRedirect("index.jsp");
				}
			}
			%>
		</font>
	</p>
	<br>
	<p align="center">
		<a href="LogoutServlet">Logout</a>
	</p>
	<p align="center">
		<font size="5">Add new employee</font>
	</p>

	<form action="AddEmp" method="post">
		<table align="center">
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstName"></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName"></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<select name="deptSelected" >
						<option value="0">-----Select Department-----</option>
						<c:forEach items="${deptList}" var="department">
							<option value="${department.getId()}">${department.getName()}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table>
		<p align="center">
			<input type="submit" value="Submit">
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="login.jsp">Back</a>
		</p>
	</form>
	<table align="center" border="1" cellpadding="5" cellspacing="1">
		<tr>
			<th>Employee ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
		</tr>
		<c:forEach items="${empList}" var="employee" >
			<tr>
				<td>${employee.getId()}</td>
				<td>${employee.getFirstName()}</td>
				<td>${employee.getLastName()}</td>
				<td>${employee.getAge()}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>