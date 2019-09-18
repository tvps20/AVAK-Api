package com.santiago.avak.dtos;

import java.io.Serializable;

public abstract class BaseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	// Construtores
	public BaseDTO() {
		super();
	}

	public BaseDTO(Long id) {
		super();
		this.id = id;
	}

	// Gets e Sets
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
