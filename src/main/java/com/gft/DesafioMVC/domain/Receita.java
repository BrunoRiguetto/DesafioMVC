package com.gft.DesafioMVC.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "receitas", indexes = {@Index(name = "idx_receita_nome", columnList = "nome")})
public class Receita extends AbstractEntity{
	private static final long serialVersionUID = 1L;

	@Column(name = "nome")
	private String nome;

	@Column(name = "modoPreparo", columnDefinition="TEXT")
	private String modoPreparo;
	
	@Column(name = "porcoes")
	private Integer porcoes;
	
	@Column(name = "tempoPreparo")
	private Integer tempoPreparo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "receita", cascade = CascadeType.MERGE)
	private List<ReceitaIngrediente> receitaTemIngrediente;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModoPreparo() {
		return modoPreparo;
	}

	public void setModoPreparo(String modoPreparo) {
		this.modoPreparo = modoPreparo;
	}

	public Integer getPorcoes() {
		return porcoes;
	}

	public void setPorcoes(Integer porcoes) {
		this.porcoes = porcoes;
	}

	public Integer getTempoPreparo() {
		return tempoPreparo;
	}

	public void setTempoPreparo(Integer tempoPreparo) {
		this.tempoPreparo = tempoPreparo;
	}

	public List<ReceitaIngrediente> getReceitaTemIngrediente() {
		return receitaTemIngrediente;
	}

	public void setReceitaTemIngrediente(List<ReceitaIngrediente> receitaTemIngrediente) {
		this.receitaTemIngrediente = receitaTemIngrediente;
	}	
}
