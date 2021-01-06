package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Empresa> empresas = new Banco().getEmpresas();
		
		String valor = request.getHeader("Accept");
		System.out.println(valor);
		
		//o navegador manda um Accept mais complexo, que precisa ser analisado, nao apenas com ifs. 
		
		//if(valor.endsWith("xml"))
		//if(valor.contains("xml"))
		//if (valor.equals("application/xml"))
		if (valor.contains("xml")) {
			XStream xstream = new XStream(); //fluxo de dados xml
			xstream.alias("empresa", Empresa.class); //para nao exibir o FQL como nome do atributo na apresentacao
			String xml = xstream.toXML(empresas);
			
			response.setContentType("application/xml"); 
			response.getWriter().print(xml); 
			
		} else if (valor.contains("json")){
			
			Gson gson = new Gson(); //biblioteca que sabe trabalhar com json
			String json = gson.toJson(empresas);
			
			response.setContentType("application/json"); //define o tipo de conteudo da resposta, (no jsp ele fazia isso de forma automatica)
			response.getWriter().print(json);
		} else {
		    response.setContentType("application/json");
		    response.getWriter().print("{'message':'no content'}");
		}
		
//		response.setContentType("text/html"); //se estivessimos trabalhando com html, seria assim. isso se chama
		// nao devolvemos html, porque queremos devolver apenas os dados, no caso o json (poderia ser um xml tb)
	}
}
