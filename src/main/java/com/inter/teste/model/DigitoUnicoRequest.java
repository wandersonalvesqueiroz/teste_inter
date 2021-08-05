package com.inter.teste.model;

public class DigitoUnicoRequest {

	private long numero;
	private long quantidade = 0;
	private long usuario;

	public DigitoUnicoRequest(long numero, long quantidade, long usuario) {
		super();
		this.numero = numero;
		this.quantidade = quantidade;
		this.usuario = usuario;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}

	public long getUsuario() {
		return usuario;
	}

	public void setUsuario(long usuario) {
		this.usuario = usuario;
	}

}
