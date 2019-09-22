package com.santiago.avak.dtos;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class PasswordNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Email(message = "email inválido")
	private String email;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String newPassword;

	// Construtores
	public PasswordNewDTO() {
		super();
	}
	
	// Gets e Sets
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
}
