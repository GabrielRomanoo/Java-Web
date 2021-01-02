package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class NovaEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("acao Cadastrando uma nova empresa");
		
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
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
	
		/*
		 * O RequestDispatcher mantem a mesma requisi��o
		 * O sendRedirect manda outra requisi��o para o navegador, mandando ele enviar outra requisi��o de volta
		 * 
		 * request.setAttribute("empresa", empresa.getNome()); //request s� sobrevive a uma requisi��o, n�o tera efeito, escopo pequeno
		 * response.sendRedirect("entrada?acao=ListaEmpresas");
		*/ 
		
		return "redirect:entrada?acao=ListaEmpresas";
	}
}