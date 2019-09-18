package com.santiago.avak.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.santiago.avak.domain.Usuario;

public class UsuarioDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String email;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=4, max=80, message="O tamanho deve ser entre 4 e 80 caracteres")
	private String nome;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String password;
	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
