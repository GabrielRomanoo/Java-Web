<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
	    <!-- uma action que define na URL (o endereço que receberá os dados) para onde será enviada a requisição ao submeter o formulário. A URL neste projeto é definida pelo mapeamento @WebServlet do objeto Servlet -->
	    <!-- <form action="/gerenciador/novaEmpresa" method="post"> <!-- Deve ter ficado claro que o método "GET" é utilizado para enviar parâmetros na URL, e que ele é problemático quando estamos trabalhando com parâmetros muito longos. Além disso, nem sempre queremos mostrar esses parâmetros. Já o método "POST" esconde os parâmetros no corpo da requisição, sem mostrá-los na URL. --> 
		
		<form action="${linkServletNovaEmpresa}" method="post">
			Nome: <input type="text" name="nome"> <!-- o name define o nome do parametro -->
			
			Data Abertura: <input type="date" name="data"> <!-- o name define o nome do parametro -->
			
			<input type="submit">
		</form>
		
		<!-- </form> -->
	</body>
</html>

