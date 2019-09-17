package com.santiago.avak.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Informacao extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;

	// Construtores
	public Informacao() {
		super();
	}

	public Informacao(Long id, String descricao, Curso curso) {
		super(id);
		this.descricao = descricao;
		this.curso = curso;
	}

	// Gets e Sets
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
