package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/entrada") //mesmo mapeamento do controlador, contudo, será executado antes do controlador (UnicaEntradaServlet)
public class MonitoramentoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) // Usamos o FilterChain para mandar a requisição para frente.
			throws IOException, ServletException {
		
		System.out.println("MonitoramentoFilter");
		
		long antes = System.currentTimeMillis();
		
		String acao = request.getParameter("acao");
		
		
		//executa acao
		chain.doFilter(request, response); //vai para o proximo filtro
		
		long depois = System.currentTimeMillis();
		System.out.println("Tempo de execucao da acao " + acao + " -> " + (depois - antes));
		
	}
}