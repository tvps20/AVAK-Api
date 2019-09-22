package com.santiago.avak.dtos;

import javax.validation.constraints.NotNull;

import com.santiago.avak.domain.Inscricao;
import com.santiago.avak.domain.enuns.TipoUsuario;

public class InscricaoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	private boolean completo;
	private TipoUsuario tipo;
	
	@NotNull(message = "Deve ser passando o id de um usuário")
	private Long alunoId;
	
	@NotNull(message = "Deve ser passando o id de um curso")
	private Long cursoId;

	// Construtores
	public InscricaoDTO() {
		super();
	}

	public InscricaoDTO(Long id, boolean completo, TipoUsuario tipo, Long alunoId, Long cursoId) {
		super(id);
		this.completo = completo;
		this.tipo = tipo;
		this.alunoId = alunoId;
		this.cursoId = cursoId;
	}
	
	public InscricaoDTO(Inscricao obj) {
		super(obj.getId());
		this.completo = obj.isCompleto();
		this.tipo = obj.getTipo();
		this.alunoId = obj.getAluno().getId();
		this.cursoId = obj.getCurso().getId();
		this.setCreatedAt(obj.getCreatedAt());
		this.setUpdatedAt(obj.getUpdatedAt());
	}

	// Gets e Sets
	public boolean isCompleto() {
		return completo;
	}

	public void setCompleto(boolean completo) {
		this.completo = completo;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = TipoUsuario.toEnum(tipo);
	}

	public Long getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(Long alunoId) {
		this.alunoId = alunoId;
	}

	public Long getCursoId() {
		return cursoId;
	}

	public void setCursoId(Long cursoId) {
		this.cursoId = cursoId;
	}
}
