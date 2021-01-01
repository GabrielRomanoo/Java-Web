package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListaEmpresaServlet
 */
@WebServlet("/listaEmpresas") //quando digitado /listaEmpresas, o servlet vai exceutar essa classe
public class ListaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//usamos o GET pois queremos apenas acessar os dados, e não alterá-los como no POST
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		
		/* má prática colocar html direto no código java 
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<ul>");
		lista.forEach(l -> out.println("<li>" + l.getNome() + "</li>"));
		out.println("</ul>");
		out.println("</body></html>"); */
		
		//chamar o JSP abaixo
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp"); //dizemos onde está o jsp que irá trabalhar com a requisição e devolver ela 
		request.setAttribute("empresas", lista); //atribuímos, adicionamos a requisição que irá ser mandada, um novo objeto
		rd.forward(request, response); //despachamos a requisição para o jsp
		
	}
}