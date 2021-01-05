package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
//		sessao.removeAttribute("usuarioLogado"); //remove apenas um atributo do ojbeto httpsession
		sessao.invalidate(); //remove todos os atributos, remove o objeto HttpSession e todos os objetos associados a ele, ao mesmo tempo em que destrói o cookie.
				
		return "redirect:entrada?acao=LoginForm";
		
		/*
		 * Quando utilizamos o removeAtribute, nosso objeto HttpSession ainda 
		 * continua em memória (o cookie também continua lá). 
		 * Já quando usamos o invalidate, ele remove o objeto HttpSession, 
		 * todos os objetos associados e também remove o cookie!
		 */
	}

}
