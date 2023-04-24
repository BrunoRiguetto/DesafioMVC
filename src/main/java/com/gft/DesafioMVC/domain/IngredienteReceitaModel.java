package com.gft.DesafioMVC.domain;

public class IngredienteReceitaModel {

	private long receita;
	
	private long unidadeMedida;
	
	public long getReceita() {
		return receita;
	}

	public void setReceita(long receita) {
		this.receita = receita;
	}

	public long getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(long unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public long getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(long ingrediente) {
		this.ingrediente = ingrediente;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	private long ingrediente;
	
	private Double quantidade;
}
