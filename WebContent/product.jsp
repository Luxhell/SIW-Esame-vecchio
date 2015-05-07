<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
</head>
	<body>

	<h1>
		<strong>Nome prodotto: ${product.nome}</strong>
	</h1>
	<h2>Dettagli</h2>
		<div>Codice: ${product.codice}</div>
		<div>Prezzo: ${product.prezzo}</div>
		<div>Descrizione: ${product.desrizione}</div>
		<div>Quantità disponibile nello store: ${product.quantita}</div>
		<li><a href="<c:url value="/home.jsp" />">Home</a></li>
	</body>

</html>