<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
	    <!-- uma action que define na URL (o endere�o que receber� os dados) para onde ser� enviada a requisi��o ao submeter o formul�rio. A URL neste projeto � definida pelo mapeamento @WebServlet do objeto Servlet -->
	    <!-- <form action="/gerenciador/novaEmpresa" method="post"> <!-- Deve ter ficado claro que o m�todo "GET" � utilizado para enviar par�metros na URL, e que ele � problem�tico quando estamos trabalhando com par�metros muito longos. Al�m disso, nem sempre queremos mostrar esses par�metros. J� o m�todo "POST" esconde os par�metros no corpo da requisi��o, sem mostr�-los na URL. --> 
		
		<form action="${linkEntradaServlet }" method="post">
			Nome: <input type="text" name="nome" value="${empresa.nome }"> <!-- o name define o nome do parametro -->
			
			Data Abertura: <input type="date" name="data" value="<fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy"/>"> Data Anterior: <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/> <!-- o name define o nome do parametro -->
			
			<input type="hidden" name="id" value="${empresa.id }"> 
			
			<input type="hidden" name="acao" value="AlteraEmpresa"> 
			
			<input type="submit">
		</form>
		
		
		<!-- </form> -->
	</body>
</html>

