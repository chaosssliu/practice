<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	
	<p align="center">
		<font size="5">Add new department</font>
	</p>

	<form action="<c:url value="/addDept"/>" method="post">
		<table align="center">
			<tr>
				<td>Department Name:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Department Email:</td>
				<td><input type="text" name="email"></td>
			</tr>
			
		</table>
		<p align="center">
			<input type="submit" value="Submit">
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="index.jsp">Back</a>
		</p>
	</form>
	<table align="center" border="1" cellpadding="5" cellspacing="1">
		<tr>
			<th>Department Name</th>
			<th>Department Email</th>
			<th>Employee</th>
		</tr>
		<c:forEach items="${deptList}" var="department" >
			<tr>
				<td>${department.getName()}</td>
				<td>${department.getEmail()}</td>
				<td>
					<c:forEach items="${department.empList}" var="employee">
						${employee.firstName} ${employee.lastName},
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>