package com.santiago.avak.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Modulo extends AbstractEntity{
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "curso_id")
	@JsonIgnore
	private Curso curso;
	
	// Construtores
	public Modulo() {
		super();
	}
	
	public Modulo(Long id, String nome, String descricao, Curso curso) {
		super(id);
		this.nome = nome;
		this.descricao = descricao;
		this.curso = curso;
	}

	// Gets e Sets
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
