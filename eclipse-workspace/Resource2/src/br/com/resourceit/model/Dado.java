package br.com.resourceit.model;

public class Dado {
	private Long cod_prod;
	private String produto;
	private Double valor;
	private Double taxa;
	private String tipo;

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getCod_prod() {
		return cod_prod;
	}

	public void setCod_prod(Long cod_prod) {
		this.cod_prod = cod_prod;
	}
}
