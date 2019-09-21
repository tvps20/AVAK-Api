package com.santiago.avak.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> erros = new ArrayList<>();
	
	// Construtores
	public ValidationError(Long timeStamp, Integer status, String error, String message, String path) {
		super(timeStamp, status, error, message, path);
	}

	// Gets e Sets
	public List<FieldMessage> getErros() {
		return erros;
	}

	public void addErro(String fieldName, String message) {
		this.erros.add(new FieldMessage(fieldName, message));
	}
}
