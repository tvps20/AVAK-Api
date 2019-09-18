package com.santiago.avak.domain.enuns;

public enum TipoUsuario {
	
	ALUNO(1, "Aluno"),
	PROFESSOR(2, "Professor"),
	TUTOR(3, "Tutor");
	
	private int cod;
	private String descricao;
	
	private TipoUsuario(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return this.cod;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static TipoUsuario toEnum(Integer cod) {
		if(cod == null) {	return null; }
		
		for(TipoUsuario x: TipoUsuario.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
