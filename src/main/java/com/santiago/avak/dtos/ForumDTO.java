package com.santiago.avak.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.santiago.avak.domain.Forum;
import com.santiago.avak.domain.enuns.TipoUsuario;

public class ForumDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min=5, max=255, message="O tamanho deve ser entre 5 e 255 caracteres")
	private String mensagem;
	
	private TipoUsuario tipo;
	
	@NotNull(message = "Deve ser passando o id de um usuário")
	private Long usuarioId;
	
	@NotNull(message = "Deve ser passando o id de uma aula")
	private Long aulaId;

	// Construtores
	public ForumDTO() {
		super();
	}

	public ForumDTO(Long id, String mensagem, TipoUsuario tipo, Long usuarioId, Long aulaId) {
		super(id);
		this.mensagem = mensagem;
		this.tipo = tipo;
		this.usuarioId = usuarioId;
		this.aulaId = aulaId;
	}
	
	public ForumDTO(Forum obj) {
		super(obj.getId());
		this.mensagem = obj.getMensagem();
		this.tipo = obj.getTipo();
		this.usuarioId = obj.getUsuario().getId();
		this.aulaId = obj.getId();
		this.setCreatedAt(obj.getCreatedAt());
		this.setUpdatedAt(obj.getUpdatedAt());
	}

	// Gets e Sets
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = TipoUsuario.toEnum(tipo);
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public Long getAulaId() {
		return aulaId;
	}

	public void setAulaId(Long aulaId) {
		this.aulaId = aulaId;
	}
}
