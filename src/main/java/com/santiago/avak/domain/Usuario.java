package com.santiago.avak.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	private String email;
	
	@JsonIgnore
	private String password;
	private String nome;
	
	@JsonIgnore
	@OneToMany(mappedBy = "professor")
	private List<Curso> cursos = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "aluno")
	private List<Inscricao> inscricoes = new ArrayList<>();
	
	// Construtores
	public Usuario() { super(); }
	
	public Usuario(Long id, String email, String password, String nome) {
		super(id);
		this.email = email;
		this.password = password;
		this.nome = nome;
	}

	// Gets e Sets
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Inscricao> getInscricoes() {
		return inscricoes;
	}

	public void setInscricoes(List<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}
}
