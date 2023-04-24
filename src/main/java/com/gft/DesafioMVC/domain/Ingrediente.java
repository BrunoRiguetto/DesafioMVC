package com.gft.DesafioMVC.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ingredientes", indexes = {@Index(name = "idx_ingrediente_nome", columnList = "nome")})
public class Ingrediente extends AbstractEntity{
	private static final long serialVersionUID = 1L;

	@Column(name = "nome", unique = true, nullable = false)
	private String nome;
	
	@JsonIgnore
	@OneToMany(mappedBy = "ingrediente")
	private List<ReceitaIngrediente> receitaTemIngrediente;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ReceitaIngrediente> getReceitaTemIngrediente() {
		return receitaTemIngrediente;
	}

	public void setReceitaTemIngrediente(List<ReceitaIngrediente> receitaTemIngrediente) {
		this.receitaTemIngrediente = receitaTemIngrediente;
	}
}
