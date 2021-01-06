package br.com.alura.cliente;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;

public class ClienteWebService {
	
	//para funcionar, foi preciso selecionar os JAR's da pasta lib e adicionar ao build path

	public static void main(String[] args) throws Exception {

		String conteudo = Request
				.Post("http://localhost:8080/gerenciador/empresas")
				.addHeader("Accept", "application/json")
				.execute()
				.returnContent()
				.asString();
		
		System.out.println(conteudo);

	}

}
