package com.santiago.avak.services.exceptions;

public class InscricaoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public InscricaoException(String msg) {
		super(msg);
	}
	
	public InscricaoException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
