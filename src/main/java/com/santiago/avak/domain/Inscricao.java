package com.santiago.avak.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.santiago.avak.domain.enuns.TipoUsuario;

@Entity
public class Inscricao extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Usuario aluno;
	private boolean completo;
	private Integer tipo;
	
	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;
	
	// Construtores
	public Inscricao() {
		super();
	}
	
	public Inscricao(Long id, Usuario aluno, boolean completo, TipoUsuario tipo, Curso curso) {
		super(id);
		this.aluno = aluno;
		this.completo = completo;
		this.tipo = tipo.getCod();
		this.curso = curso;
	}

	// Gets e Sets
	public Usuario getAluno() {
		return aluno;
	}

	public void setAluno(Usuario aluno) {
		this.aluno = aluno;
	}

	public boolean isCompleto() {
		return completo;
	}

	public void setCompleto(boolean completo) {
		this.completo = completo;
	}

	public TipoUsuario getTipo() {
		return TipoUsuario.toEnum(this.tipo);
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo.getCod();
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
