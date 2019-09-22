package com.santiago.avak.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.santiago.avak.domain.enuns.TipoPerfil;

@Entity
public class Usuario extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String nome;
	
	@JsonIgnore
	private String password;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PERFIS")
	private Set<Integer> perfis = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "professor")
	private List<Curso> cursos = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "aluno")
	private List<Inscricao> inscricoes = new ArrayList<>();
	
	// Construtores
	public Usuario() { 
		super(); 
		this.addPerfil(TipoPerfil.USUARIO);
	}
	
	public Usuario(Long id, String email, String nome, String password) {
		super(id);
		this.email = email;
		this.password = password;
		this.nome = nome;
		this.addPerfil(TipoPerfil.USUARIO);
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
	
	public Set<TipoPerfil> getPerfis(){
		return this.perfis.stream().map(x -> TipoPerfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(TipoPerfil perfil) {
		this.perfis.add(perfil.getCod());
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
