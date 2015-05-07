<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Inserimento nuovo prodotto</h1>
	<form action="<c:url value="productController" />" method="get">
		<div>
			Nome: <input type="text" name="nome" value="${param.nome}" />
			${errName}
		</div>
		<div>
			Codice: <input type="text" name="codice" value="${param.codice}" />
			${errCode}
		</div>
		<div>
			Descrizione:
			<textarea rows="4" cols="50" name="descrizione">${param.descrizione}</textarea>
		</div>
		<div>
			Prezzo: <input type="text" name="prezzo" value="${param.prezzo}" />
			${errPrezzo}
		</div>
		<div>
			Quantità: <input type="text" name="quantita" value="${param.quantita}" />
			${errQuantita}
		</div>
		<div>
			Fornitore del Prodotto: <input type="text" name="fornitore" value="${param.fornitore}" />
			${errFornitore}
		</div>
		<div>
			<input type="submit" name="sumbit1" value="Aggiungi nuovo fornitore" />
		</div>
		<div>
			<input type="submit" name="sumbit2" value="Aggiungi fornitore esistente" />
		</div>
	</form>

</body>
</html>
