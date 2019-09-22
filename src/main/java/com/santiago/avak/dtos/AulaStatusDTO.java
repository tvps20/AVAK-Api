package com.santiago.avak.dtos;

import javax.validation.constraints.NotNull;

import com.santiago.avak.domain.AulaStatus;

public class AulaStatusDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	private boolean completo;
	private String resultado;
	private Integer qtdCertas;
	
	@NotNull(message = "Deve ser passando o id de uma aula")
	private Long aulaId;
	
	@NotNull(message = "Deve ser passando o id de uma inscrição")
	private Long inscricaoId;
	
	// Construtores
	public AulaStatusDTO() {
		super();
	}

	public AulaStatusDTO(Long id, Long aulaId, boolean completo, String resultado, Integer qtlCertas, Long inscricaoId) {
		super(id);
		this.aulaId = aulaId;
		this.completo = completo;
		this.resultado = resultado;
		this.qtdCertas = qtlCertas;
		this.inscricaoId = inscricaoId;
	}
	
	public AulaStatusDTO(AulaStatus obj) {
		super(obj.getId());
		this.completo = obj.isCompleto();
		this.resultado = obj.getResultado();
		this.qtdCertas = obj.getQtdCertas();
		this.aulaId = obj.getAula().getId();
		this.inscricaoId = obj.getInscricao().getId();
	}

	// Gets e Sets
	public boolean isCompleto() {
		return completo;
	}

	public void setCompleto(boolean completo) {
		this.completo = completo;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public Integer getQtdCertas() {
		return qtdCertas;
	}

	public void setQtdCertas(Integer qtdCertas) {
		this.qtdCertas = qtdCertas;
	}

	public Long getAulaId() {
		return aulaId;
	}

	public void setAulaId(Long aulaId) {
		this.aulaId = aulaId;
	}

	public Long getInscricaoId() {
		return inscricaoId;
	}

	public void setInscricaoId(Long inscricaoId) {
		this.inscricaoId = inscricaoId;
	}
}
