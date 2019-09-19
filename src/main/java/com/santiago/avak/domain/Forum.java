package com.santiago.avak.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.santiago.avak.domain.enuns.TipoUsuario;

@Entity
public class Forum extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "aula_id")
	private Aula aula;
	
	private String mensagem;
	private Integer tipo;
	
	// Construtores
	public Forum() {
		super();
	}
	
	public Forum(Long id, Usuario usuario, String mensagem, Aula aula, TipoUsuario tipo) {
		super(id);
		this.usuario = usuario;
		this.mensagem = mensagem;
		this.aula = aula;
		this.tipo = (tipo == null) ? null : tipo.getCod();
	}

	// Gets e Sets
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Aula getAula() {
		return aula;
	}
	
	public void setAula(Aula aula) {
		this.aula = aula;
	}
	
	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public TipoUsuario getTipo() {
		return TipoUsuario.toEnum(tipo);
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo.getCod();
	}
}
