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
 * ANOTAÇÕES
 * 
 * Voltaremos nossa atenção para o seguinte ponto: nos .nossos Servlets NovaEmpresaServlet ou OiMundoServlet, sempre chamamos o método service() não importando se a requisição era do tipo POST ou GET, e isso não uma característica positiva. Existem casos, como no caso de um login com senha, em que o servidor não deve aceitar nenhuma requisição do tipo GET.
 * 
 * Não há suporte para maiores especificidades no método service(), ele sempre aceitará as duas requisições de forma indiscriminada. Recorreremos a outro método que aceita apenas requisições POST, doPost(). Caso fosse do nosso interesse receber apenas requisições GET, usaríamos o método doGet().
 * 
 * Primeiro a requisição chega até o Servlet e nele é executado todo o processamento, mas o trabalho de resposta é feito pelo arquivo JSP. Com isso, realizamos uma separação de responsabilidades.
 * 
 * Quando despachamos a requisição para o JSP, podemos atribuir, pendurar, linkar, novos objetos a essa requisição que irá ser enviada
 * Caso não seja feito isso, e fosse mandada a requisição limpa, original, os atributos que poderíamos usar seriam os da requisição original.
 */

/**
 * Servlet implementation class NovaEmpresaServlet
 */
@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//	protected void service(HttpServletRequest request, HttpServletResponse response) //o service atende os dois tipos de requisição: GET ou POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //atende apenas para requisição tipo POST
		
		System.out.println("Cadastrando uma nova empresa");
		
		// http://localhost:8080/gerenciador/novaEmpresa?nome=Caelum
		String nomeEmpresa = request.getParameter("nome"); //retorna uma string e recebe como parâmetro o nome do parâmetro recebido na requisição
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
		
		/* má prática colocar html direto no código java */
		//PrintWriter out = response.getWriter();
		//out.println("<html><body>Empresa " + nomeEmpresa + " cadastrada com sucesso!</body></html>"); //má prática possuir ódigo de interface e visualização HTML dentro de uma classe.
	
		/* redirecionando o fluxo */
//		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp"); //indicamos para onde a requisição deve ir
		
		/* redirecionando para outro servlet 
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas"); //vai pra outro servlet (redirecionamento server side)
		request.setAttribute("empresa", empresa.getNome()); //agrupamos um objeto na requisição
		rd.forward(request, response); //manda embora a requisição, despacha a requisição */
		
		/* redirecionando para o navegador */
		response.sendRedirect("listaEmpresas"); //dizemos para o navegador mandar uma requisição para o servlet listEmpresas
		request.setAttribute("empresa", empresa.getNome()); //request só sobrevive a uma requisição, não tera efeito, escopo pequeno

	}

}
