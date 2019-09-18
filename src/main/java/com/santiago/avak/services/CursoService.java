package com.santiago.avak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.avak.domain.Curso;
import com.santiago.avak.repositories.CursoRepository;

@Service
public class CursoService extends BaseService<Curso> {
	
	@Autowired
	public CursoService(CursoRepository repository) {
		super(repository);
	}
	
	@Override
	public Class<Curso> getTClass() {
		return Curso.class;
	}
}
