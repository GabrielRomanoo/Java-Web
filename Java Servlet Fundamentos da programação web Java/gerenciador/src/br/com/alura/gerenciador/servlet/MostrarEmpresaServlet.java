package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MostrarEmpresaServlet
 */
@WebServlet("/mostraEmpresa")
public class MostrarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPeloId(id);
		
		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
		request.setAttribute("empresa", empresa);
		rd.forward(request, response);
	}

}
