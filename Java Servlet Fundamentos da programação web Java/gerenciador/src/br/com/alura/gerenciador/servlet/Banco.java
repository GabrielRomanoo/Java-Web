package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<Empresa>();
	private static Integer chaveSequencial = 1;
	
	//bloco abaixo é executado quando a JVM carrega a classe
	static {
		Empresa empresa1 = new Empresa();
		empresa1.setId(Banco.chaveSequencial++);
		empresa1.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setId(Banco.chaveSequencial++);
		empresa2.setNome("Caelum");
		Banco.lista.add(empresa1);
		Banco.lista.add(empresa2);
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {
		Banco.lista = Banco.lista.stream().filter(empresa->empresa.getId()!=id).collect(Collectors.toList());		
	}

	public Empresa buscaEmpresaPeloId(Integer id) {
		for (Empresa empresa : lista) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public void alteraEmpresa(String nome, Date dataAbertura, Integer id) {
		Empresa empresa = this.buscaEmpresaPeloId(id);
		empresa.setNome(nome);
		empresa.setDataAbertura(dataAbertura);
	}

}
