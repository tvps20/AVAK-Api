package com.santiago.avak.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Curso extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "professor_id")
	private Usuario professor;
	
	@JsonIgnore
	@OneToMany(mappedBy = "curso")
	private List<Informacao> informacoes = new ArrayList<>();
	
	@OneToMany(mappedBy = "curso")
	private List<Modulo> modulos = new ArrayList<>();
	
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

	public List<Informacao> getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(List<Informacao> informacoes) {
		this.informacoes = informacoes;
	}

	public List<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}
}
