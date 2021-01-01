package br.com.alura.gerenciador.servlet;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Empresa {
	
	private Integer id;
	private String nome;
	private Date dataAbertura = new Date();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public String getDataComFormatada() {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date todayWithZeroTime = formatter.parse(formatter.format(this.dataAbertura));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "3000-30-03";
	}
	
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
}