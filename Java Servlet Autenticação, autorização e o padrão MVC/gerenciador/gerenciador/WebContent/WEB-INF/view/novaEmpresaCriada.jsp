<% 	
	/* 
	 * Chamamos essa inser��o de codigo Java um arquivo jsp de scriptlet.
	 * JSP � uma tecnologia que renderiza as p�ginas no servidor antes de envia-la. 
	 * Todo o c�digo (scriptlet) � executado no servidor antes de enviar a resposta para o navegador.
	 
	 * String nomeEmpresa = (String) request.getAttribute("empresa"); //pegando os atributos linkados na requisi��o enviada ao jsp (enviada pelo servlet))
	 * System.out.println(nomeEmpresa);
	 *
	 * Exemplo de codigo abaixo.
	 * 
	 * 		Empresa <%= (nomeEmpresa) porcento>
	 *
	 * O '=' � a mesma coisa que out.println()
	 * 
	 * A parte negativa do scrpitle � a manuten��o do c�dgio
	 *
	 * Porem, podemos escrever o nome da empresa de uma forma mais simples, sem o scriplet
	 *
	 * Usando as Expression Language
	 *
	 * Trata-se de uma linguagem simples, por�m poderosa. 
	 * Ela analisa a requisi��o e busca o atributo "empresa", isto �, 
	 * trata-se da mesma a��o que estamos realizando na parte superior do c�digo (o scriplet).
	 *
	 * Exemplo: 
	 *
	 *		Empresa ${ empresa } cadastrada com sucesso!
	 *
	 * A Expression Language procura o nome do atributo na requisicao
	 *
	 * Podemos tambem fazer calculos, por exemplo: ${ 3 + 3}
	 * 
	 * Contudo, com as EL, nao conseguimos fazer la�os
	 *
	 * No listaEmpresas.jsp fazemos um for com as empresas, para lista-las. 
	 * Assim, temos que usar uma biblioteca externa, chamada JSTL (Java Standard Taglib)
	 * Devemos colocar o JSTL.jar na pasta lid de WEB-INF.
	 */
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<body>
	
	<c:if test="${not empty empresa}">
		Empresa ${empresa} cadastrada com sucesso! 
	</c:if>
	
	<c:if test="${empty empresa}">
		Nenhuma empresa cadastrada!
	</c:if>
	
	</body>
</html>