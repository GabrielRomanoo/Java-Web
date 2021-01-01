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
       
	//usamos o GET pois queremos apenas acessar os dados, e n�o alter�-los como no POST
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		
		/* m� pr�tica colocar html direto no c�digo java 
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<ul>");
		lista.forEach(l -> out.println("<li>" + l.getNome() + "</li>"));
		out.println("</ul>");
		out.println("</body></html>"); */
		
		//chamar o JSP abaixo
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp"); //dizemos onde est� o jsp que ir� trabalhar com a requisi��o e devolver ela 
		request.setAttribute("empresas", lista); //atribu�mos, adicionamos a requisi��o que ir� ser mandada, um novo objeto
		rd.forward(request, response); //despachamos a requisi��o para o jsp
		
	}
}