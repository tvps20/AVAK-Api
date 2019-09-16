package com.santiago.avak.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Curso extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "professor_id")
	private Usuario professor;
	
	// Construtores
	public Curso() {
		super();
	}
	
	public Curso(Long id, String nome, String descricao, Usuario professor) {
		super(id);
		this.nome = nome;
		this.descricao = descricao;
		this.professor = professor;
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
	public Usuario getProfessor() {
		return professor;
	}
	public void setProfessor(Usuario professor) {
		this.professor = professor;
	}
}
