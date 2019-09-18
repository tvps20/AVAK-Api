package com.santiago.avak.dtos;

import com.santiago.avak.domain.Usuario;

public class UsuarioDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String nome;
	
	// Construtores
	public UsuarioDTO() {
		super();
	}
	
	public UsuarioDTO(Long id, String email, String nome) {
		super(id);
		this.email = email;
		this.nome = nome;
	}
	
	public UsuarioDTO(Usuario obj) {
		super(obj.getId());
		this.email = obj.getEmail();
		this.nome = obj.getNome();
	}

	// Gets e Sets
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
