package com.inter.teste.model;

public class DigitoUnicoResponse {

	private Long id;
	private Long numero;
	private Long quantidade;
	private Long resultado;
	private Long usuario;
				
	public DigitoUnicoResponse(Long id, Long numero, Long quantidade, Long resultado, Long usuario) {
		super();
		this.id = id;
		this.numero = numero;
		this.quantidade = quantidade;
		this.resultado = resultado;
		this.usuario = usuario;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getNumero() {
		return numero;
	}
	
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	
	public Long getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	public Long getResultado() {
		return resultado;
	}
	
	public void setResultado(Long resultado) {
		this.resultado = resultado;
	}
	
	public Long getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}
	
}
