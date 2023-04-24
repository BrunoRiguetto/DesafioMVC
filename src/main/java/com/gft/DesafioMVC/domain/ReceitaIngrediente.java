package com.gft.DesafioMVC.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "receita_ingrediente")
public class ReceitaIngrediente extends AbstractEntity{
	private static final long serialVersionUID = 1L;
	
	@JoinColumn(name = "quantidade")
	private Double quantidade;
	
	@ManyToOne
	@JoinColumn(name = "id_unidade_medida")
	private UnidadeMedida unidadeMedida;
	
	@ManyToOne
	@JoinColumn(name = "id_ingrediente")
	private Ingrediente ingrediente;

	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "id_receita")
	private Receita receita;

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}
}
