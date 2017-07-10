<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Success</title>
</head>
<body>

<p align="center"><font size="15">Log In</font></p>
<p align="center"><font color=red>${message1}</font></p>
<p align="center"><font color=red>${message2}</font></p>
<br>
<br>

<form action="LoginServlet" method="post">
<table align="center">
<tr>
<td>User Name:</td>
<td><input type="text" name="username"></td>
</tr>

<tr>
<td>Password:</td>
<td><input type="password" name="password"></td>
</tr>
</table>

<br>
<p align="center"><input type="submit" value="Login">
&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value ="Reset"></p>
</form>

</body>
</html>