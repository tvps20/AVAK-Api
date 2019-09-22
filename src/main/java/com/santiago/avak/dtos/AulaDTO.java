package com.santiago.avak.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.santiago.avak.domain.Aula;

public class AulaDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=4, max=80, message="O tamanho deve ser entre 4 e 80 caracteres")
	private String nome;
	private String descricao;
	private String video;
	private String atividade;
	
	@NotNull(message = "Deve ser passando o id de um modulo")
	private Long moduloId;
	
	// Construtores
	public AulaDTO() {
		super();
	}

	public AulaDTO(Long id, String nome, String descricao, String video, String atividade, Long moduloId) {
		super(id);
		this.nome = nome;
		this.descricao = descricao;
		this.video = video;
		this.atividade = atividade;
		this.moduloId = moduloId;
	}
	
	public AulaDTO(Aula obj) {
		super(obj.getId());
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
		this.video = obj.getVideo();
		this.atividade = obj.getAtividade();
		this.moduloId = obj.getModulo().getId();
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

	public Long getModuloId() {
		return moduloId;
	}

	public void setModuloId(Long moduloId) {
		this.moduloId = moduloId;
	}
}
