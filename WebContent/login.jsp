<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.uniroma3.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<form method="GET" action="admin/controllerLogin.do" >
<p>Per effettuare il login come admin utilizzate mario come username e rossi come password</p>
<p>Tutti gli altri username e password saranno considerati utenti senza privilegi</p>
	<p>Username: <input type="text" value="" name="usernameT"/></p>
	<p>Password: <input type="password" value="" name="passwordT"/></p>
	<p><input type="submit" value="Login" name="bottoneLogin"/>
</form> 
</body>
</html>