package br.com.utfpr.tcc.ws.spring.wsjpa.model;

public class Resposta {

	private int httpStatus;
	
	private String mensagemErro;
	
	private Object retorno;

	public Resposta(int httpStatus, String mensagemErro) {
		this.httpStatus = httpStatus;
		this.mensagemErro = mensagemErro;
	}
	
	public Resposta(int httpStatus, String mensagemErro, Object retorno) {
		this.httpStatus = httpStatus;
		this.mensagemErro = mensagemErro;
		this.retorno = retorno;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public String getMensagemErro() {
		return mensagemErro;
	}

	public Object getRetorno() {
		return retorno;
	}
}
