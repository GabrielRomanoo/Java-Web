package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Acao;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
//@WebFilter("/entrada")
public class ControladorFilter implements Filter { 

	/* para definir a ordem de execucao dos filtros, é preciso configurar no xml, declarando os filros. a ordem de execucao será dada pela ordem de declaracao 
	 *
	 * Anotações não nos permitem definir a ordem dos filtros, para isso precisamos utilizar o web.xml. Ou seja, quando precisamos definir uma ordem de aplicação dos filtros, devemos optar pelo uso do web.xml.
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("ControladorFilter");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String paramAcao = request.getParameter("acao");
		String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;
		String nome;
		
		try {
			Class classe = Class.forName(nomeDaClasse); //carrega a classe com o nome
			Object objeto = classe.newInstance();
			Acao acao = (Acao) objeto;
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException | IOException e) {
			throw new ServletException(e);	
		}
		
		String[] tipoEEndereco = nome.split(":");
		
		if (tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]); //colocamos os jsp's na web-inf para eles nao serem acessados diretamente pelo navegador
			rd.forward(request, response); 
		} else {
			response.sendRedirect(tipoEEndereco[1]);
		}
		
		//nao tem mais o chain nesse filtro, por ele ser o ultimo, e representar o controlador ao inves do servlet ser o controlador
	}

}
