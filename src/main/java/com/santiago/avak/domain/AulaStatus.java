package com.santiago.avak.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AulaStatus extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "aula_id")
	private Aula aula;
	private boolean completo;
	private String resultado;
	private Integer qtlCertas;
	
	@ManyToOne
	@JoinColumn(name = "inscricao_id")
	@JsonIgnore
	private Inscricao inscricao;
	
	// Construtores
	public AulaStatus() {
		super();
	}
	
	public AulaStatus(Long id, Aula aula, boolean completo, String resultado, Integer qtlCertas, Inscricao inscricao) {
		super(id);
		this.aula = aula;
		this.completo = completo;
		this.resultado = resultado;
		this.qtlCertas = qtlCertas;
		this.inscricao = inscricao;
	}

	// Gets e Sets
	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public boolean isCompleto() {
		return completo;
	}

	public void setCompelto(boolean completo) {
		this.completo = completo;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public Integer getQtlCertas() {
		return qtlCertas;
	}

	public void setQtlCertas(Integer qtlCertas) {
		this.qtlCertas = qtlCertas;
	}

	public Inscricao getInscricao() {
		return inscricao;
	}

	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}
}
