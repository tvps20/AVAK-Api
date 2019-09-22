package com.santiago.avak.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.santiago.avak.domain.Informacao;

public class InformacaoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=5, max=255, message="O tamanho deve ser entre 5 e 255 caracteres")
	private String descricao;
	
	@NotNull(message = "Deve ser passando o id de um curso")
	private Long cursoId;

	// Construtores
	public InformacaoDTO() {
		super();
	}
	
	public InformacaoDTO(Long id, String descricao, Long cursoId) {
		super(id);
		this.descricao = descricao;
		this.cursoId = cursoId;
	}
	
	public InformacaoDTO(Informacao obj) {
		super(obj.getId());
		this.descricao = obj.getDescricao();
		this.cursoId = obj.getCurso().getId();
		this.setCreatedAt(obj.getCreatedAt());
		this.setUpdatedAt(obj.getUpdatedAt());
	}

	// Gets e Sets
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getCursoId() {
		return cursoId;
	}

	public void setCursoId(Long cursoId) {
		this.cursoId = cursoId;
	}
}
