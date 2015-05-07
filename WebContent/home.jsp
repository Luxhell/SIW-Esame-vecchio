 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>esame siw giugno 2015</title>
</head>
<body>
<h1>Esame siw giugno 2015</h1>
<ul>
<li><a href="<c:url value="/controller/product.create" />">Aggiungi un nuovo prodotto</a></li>

<li><a href="<c:url value="/controller/provider.create" />">Aggiungi un nuovo fornitore</a></li>

<li><a href="<c:url value="/controller/product.list" />">Visualizza tutti prodotti in catalogo</a></li>


</ul>
${action}
</body>
</html>