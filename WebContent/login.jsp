<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.uniroma3.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="/controller/customer.login" />" method="get">
	<p>Email: <input type="text" value="email" name="email"/></p>
	<p>Password: <input type="password" value="" name="password"/></p>
	<p><input type="submit" value="login" name="submit"/>
</form> 
</body>
</html>