package br.com.utfpr.tcc.ws.spring.wsjpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	private String matricula;
	
	private String senha;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean mesmaSenha(String senha) {
		return this.senha.equals(senha);
	}
 }
