package com.santiago.avak.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.santiago.avak.domain.Curso;

public class CursoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=4, max=80, message="O tamanho deve ser entre 4 e 80 caracteres")
	private String nome;
	
	private String descricao;
	
	@NotNull(message = "Deve ser passando o id de um usuário")
	private Long professorId;
	
	// Construtores
	public CursoDTO() {
		super();
	}
	
	public CursoDTO(Long id, String nome, String descricao, Long professorId) {
		super(id);
		this.nome = nome;
		this.descricao = descricao;
		this.professorId = professorId;
	}
	
	public CursoDTO(Curso obj) {
		super(obj.getId());
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
		this.professorId = obj.getProfessor().getId();
		this.setCreatedAt(obj.getCreatedAt());
		this.setUpdatedAt(obj.getUpdatedAt());
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

	public Long getProfessorId() {
		return professorId;
	}

	public void setProfessorId(Long professorId) {
		this.professorId = professorId;
	}
}
