package com.santiago.avak.services.exceptions;

public class ProfessorException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ProfessorException(String msg) {
		super(msg);
	}
	
	public ProfessorException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
