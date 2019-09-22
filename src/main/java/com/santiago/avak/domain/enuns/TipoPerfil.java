package com.santiago.avak.domain.enuns;

import com.santiago.avak.domain.exceptions.IllegalEnumException;

public enum TipoPerfil {
	
	ADMIN(1, "ROLE_ADMIN"),
	USUARIO(2, "ROLE_USER");
	
	private int cod;
	private String descricao;
	
	private TipoPerfil(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return this.cod;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public static TipoPerfil toEnum(Integer cod) {
		if(cod == null) {	return null; }
		
		for(TipoPerfil x: TipoPerfil.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalEnumException("Id inválido: " + cod);
	}
	
	public static TipoPerfil toEnum(String descricao) {
		if(descricao == null) {	return null; }
		
		for(TipoPerfil x: TipoPerfil.values()) {
			if(descricao.equals(x.toString())) {
				return x;
			}
		}
		
		throw new IllegalEnumException("Tipo [" + descricao + "] inválido. Não atende aos tipos [ROLE_ADMIN, ROLE_USER]");
	}
}
