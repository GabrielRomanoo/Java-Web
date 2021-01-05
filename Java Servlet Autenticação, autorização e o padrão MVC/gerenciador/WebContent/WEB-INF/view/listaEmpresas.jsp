<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="br.com.alura.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada" var="linkServletRemoveEmpresa"/>
<c:url value="/entrada" var="linkServletMostraEmpresa"/>


<% /* O @ sempre signifca que é uma declaracao da pagina
	*
	* O nome do mundo de bibliotecas de tags é definido por meio de do atributo uri.
	* Quando adicionamos o nome da tag lib "http://java.sun.com/jsp/jstl/core", 
	* trata-se apenas de um apelido, que faz referência a uma biblioteca de mesmo nome.
	*
	* O tomcat vai pegar o nome definido na uri, e procurar no jstl.jar
	* Ou seja, vai encontrar as tags da biblioteca que teve seu nome definido na uri.
	*
	* A bilbioteca de tags que vamos usar para substituir o scriplet, é a JSTL.
	* Existem outras bibliotecas dentro do JSTL. No caso, estamos importando a biblioteca core.
	*
	* Para indicar que o <forEach> vem da biblioteca que importamos, 
	* adicionaremos um prefixo (prefix), definido como c, fazendo uma referencia à core.
	* Pode-se colocar qualquer coisa no prefix, contudo, o comum é colocar a "c" quando é core
    */%>

<% /* scriplet
    * List<Empresa> lista = (List<Empresa>) request.getAttribute("empresas");
    *
	*<% for (Empresa empresa : lista) { porcento>
			<li> <%= (empresa.getNome()) porcento> </li>
	 <% } porcento>
	*
	* Para nao usar o scriplet para lacos de repeticao, podemos usar a biblioteca JSTL.
	* Assim, temos que usar uma biblioteca externa, chamada JSTL (Java Standard Taglib)
	* Devemos colocar o JSTL.jar na pasta lid de WEB-INF.
	*
	* O tomcat por padrao consegue interpretar o Scriplet e as Expression Languages, 
	* Contudo, nao consegue interpretar o JSTL. 
	* Assim, fazemos o import com o @, igual fizemos com as classes e objetos
	*
	* Exemplo de codigo:
	*
	* <c:forEach items="${empresas}" var="empresa">
		<li>${empresa.nome}</li>
	  </c:forEach>
	* 
	* Os items definem os elementos que queremos usar para fazer o laço, no caso, nossa lista de empresas
	* Usamos uma EL, que faz a busca nos atributos da requiscao
	*
	* O var define a variavel do laço, da iteracao
	*
	* Na parte <li>${empresa.nome}</li>, a Expression Language por baixo dos panos
	* ira chamar o metodo getNome()
	*
	* Usar as tags é uma forma mais amigavel dentro do mundo html
	*/
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Java Standard Taglib</title>
	</head>
	<body>
	
		<c:import url="logout-parcial.jsp"></c:import>
	
		Usuario Logado: ${usuarioLogado.login } <!s-- a EL irá buscar no httpsessions se existe este objeto -->
	
	    <br>
	    <br>
	    <br>
	    
		<c:if test="${not empty empresa}">
			Empresa ${empresa} cadastrada com sucesso! 
		</c:if>
	
		Lista de Empresas: <br/>
		<ul>
			<c:forEach items="${empresas}" var="empresa">
				<li>
					${empresa.nome} <fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy"/> 
					<!-- enviando via GET na url do navegador atraves do ?-->
					<a href = "${linkServletMostraEmpresa}?acao=MostraEmpresa&id=${empresa.id}">editar</a> 
					<a href = "${linkServletRemoveEmpresa}?acao=RemoveEmpresa&id=${empresa.id}">remove</a> 					
				</li>
			</c:forEach>
		
		</ul>
	</body>
</html>