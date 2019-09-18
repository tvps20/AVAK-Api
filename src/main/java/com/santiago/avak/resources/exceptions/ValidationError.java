package com.santiago.avak.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StantardError {
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> erros = new ArrayList<>();
	
	// Construtores
	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
	}

	// Gets e Sets
	public List<FieldMessage> getErros() {
		return erros;
	}

	public void addErro(String fieldName, String message) {
		this.erros.add(new FieldMessage(fieldName, message));
	}
}
