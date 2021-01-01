package br.com.alura.gerenciador.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * O Tomcat s� ir� instanciar as servlets de acordo com a necessidade! 
 * Al�m disso, ele instanciar� apenas uma servlet de cada (singleton).
 */

@WebServlet(urlPatterns="/oi", loadOnStartup=1) //marca a classe como uma servlet e al�m disso a registra a URL.
public class OiMundoServlet extends HttpServlet { //no extends dizemos que a classe OiMundoServlet � um servlet do tipo protocolo http

	private static final long serialVersionUID = 1L;
	
	public OiMundoServlet() {//o Servlet � chamado de Singleton, um escopo, que sobrevive no projeto por tempo indeterminado enquanto o Tomcat estiver no ar, sem nunca recri�-lo.
		System.out.println("Criando Oi Mundo Servlet");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter writer = resp.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("oi mundo, parabens vc escreveu o primeiro servlts.");
		writer.println("</body>");
		writer.println("</html>");

		System.out.println("o servlet OiMundoServlet foi chamado");
	}
}
