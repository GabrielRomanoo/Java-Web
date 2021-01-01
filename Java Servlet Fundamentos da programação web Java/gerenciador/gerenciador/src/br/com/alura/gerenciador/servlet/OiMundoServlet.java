package br.com.alura.gerenciador.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/oi") //marca a classe como uma servlet e além disso a registra a URL.
public class OiMundoServlet extends HttpServlet { //no extends dizemos que a classe OiMundoServlet é um servlet do tipo protocolo http

	private static final long serialVersionUID = 1L;

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
