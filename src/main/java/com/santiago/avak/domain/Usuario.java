package com.santiago.avak.domain;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	private String email;
	
	@JsonIgnore
	private String password;
	private String nome;
	
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
}
