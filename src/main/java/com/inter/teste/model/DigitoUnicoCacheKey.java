package com.inter.teste.model;

public class DigitoUnicoCacheKey {

	private long numero;
	private long quantidade;

	public DigitoUnicoCacheKey(long numero, long quantidade) {
		super();
		this.numero = numero;
		this.quantidade = quantidade;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (numero ^ (numero >>> 32));
		result = prime * result + (int) (quantidade ^ (quantidade >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DigitoUnicoCacheKey other = (DigitoUnicoCacheKey) obj;
		if (numero != other.numero)
			return false;
		if (quantidade != other.quantidade)
			return false;
		return true;
	}

}
