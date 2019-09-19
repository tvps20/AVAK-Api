package com.santiago.avak.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.santiago.avak.domain.Usuario;

public class CursoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=4, max=80, message="O tamanho deve ser entre 4 e 80 caracteres")
	private String nome;
	
	private String descricao;
	private Usuario professor;
	
}
