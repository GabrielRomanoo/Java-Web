package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * ANOTA��ES
 * 
 * Voltaremos nossa aten��o para o seguinte ponto: nos .nossos Servlets NovaEmpresaServlet ou OiMundoServlet, sempre chamamos o m�todo service() n�o importando se a requisi��o era do tipo POST ou GET, e isso n�o uma caracter�stica positiva. Existem casos, como no caso de um login com senha, em que o servidor n�o deve aceitar nenhuma requisi��o do tipo GET.
 * 
 * N�o h� suporte para maiores especificidades no m�todo service(), ele sempre aceitar� as duas requisi��es de forma indiscriminada. Recorreremos a outro m�todo que aceita apenas requisi��es POST, doPost(). Caso fosse do nosso interesse receber apenas requisi��es GET, usar�amos o m�todo doGet().
 * 
 * Primeiro a requisi��o chega at� o Servlet e nele � executado todo o processamento, mas o trabalho de resposta � feito pelo arquivo JSP. Com isso, realizamos uma separa��o de responsabilidades.
 * 
 * Quando despachamos a requisi��o para o JSP, podemos atribuir, pendurar, linkar, novos objetos a essa requisi��o que ir� ser enviada
 * Caso n�o seja feito isso, e fosse mandada a requisi��o limpa, original, os atributos que poder�amos usar seriam os da requisi��o original.
 */

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//	protected void service(HttpServletRequest request, HttpServletResponse response) //o service atende os dois tipos de requisi��o: GET ou POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //atende apenas para requisi��o tipo POST
		
		System.out.println("Cadastrando uma nova empresa");
		
		// http://localhost:8080/gerenciador/novaEmpresa?nome=Caelum
		String nomeEmpresa = request.getParameter("nome"); //retorna uma string e recebe como par�metro o nome do par�metro recebido na requisi��o
		String paramDataEmpresa = request.getParameter("data");
		paramDataEmpresa = paramDataEmpresa.replace("-", "/");
		System.out.println("param empresa: " + paramDataEmpresa);
		
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		
		/* simulando um banco de dados abaixo*/
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		/* m� pr�tica colocar html direto no c�digo java */
		//PrintWriter out = response.getWriter();
		//out.println("<html><body>Empresa " + nomeEmpresa + " cadastrada com sucesso!</body></html>"); //m� pr�tica possuir �digo de interface e visualiza��o HTML dentro de uma classe.
	
		/* redirecionando o fluxo */
//		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp"); //indicamos para onde a requisi��o deve ir
		
		/* redirecionando para outro servlet 
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas"); //vai pra outro servlet (redirecionamento server side)
		request.setAttribute("empresa", empresa.getNome()); //agrupamos um objeto na requisi��o
		rd.forward(request, response); //manda embora a requisi��o, despacha a requisi��o */
		
		/* redirecionando para o navegador */
		response.sendRedirect("listaEmpresas"); //dizemos para o navegador mandar uma requisi��o para o servlet listEmpresas
		request.setAttribute("empresa", empresa.getNome()); //request s� sobrevive a uma requisi��o, n�o tera efeito, escopo pequeno

	}

}
