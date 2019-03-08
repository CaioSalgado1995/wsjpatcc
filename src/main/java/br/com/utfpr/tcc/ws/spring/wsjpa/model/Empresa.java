package br.com.utfpr.tcc.ws.spring.wsjpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Empresa {

	@Id
	private String cnpj;
	
	private String nome;
	
	private boolean representanteLegal;

	public String getCnpj() {
		return cnpj;
	}
	
	public String getNome() {
		return nome;
	}

	public boolean isRepresentanteLegal() {
		return representanteLegal;
	}	
}