package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlterarEmpresaServlet
 */
@WebServlet("/alteraEmpresa")
public class AlterarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Alterando Empresa");
		
		String nome = request.getParameter("nome");
		Integer id = Integer.valueOf(request.getParameter("id"));
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
		
		Banco banco = new Banco();
		banco.alteraEmpresa(nome, dataAbertura, id);
		
		response.sendRedirect("listaEmpresas");
	}
}