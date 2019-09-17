package com.santiago.avak.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Aula extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String descricao;
	private String video;
	private String atividade;
	
	@ManyToOne
	@JoinColumn(name = "modulo_id")
	@JsonIgnore
	private Modulo modulo;
	
	// Construtores
	public Aula() {
		super();
	}
	public Aula(Long id, String nome, String descricao, String video, String atividade, Modulo modulo) {
		super(id);
		this.nome = nome;
		this.descricao = descricao;
		this.video = video;
		this.atividade = atividade;
		this.modulo = modulo;
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
	
	public String getVideo() {
		return video;
	}
	
	public void setVideo(String video) {
		this.video = video;
	}
	
	public String getAtividade() {
		return atividade;
	}
	
	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}
	
	public Modulo getModulo() {
		return modulo;
	}
	
	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}
}
