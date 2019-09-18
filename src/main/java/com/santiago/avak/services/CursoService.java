package com.santiago.avak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.avak.domain.Curso;
import com.santiago.avak.dtos.CursoDTO;
import com.santiago.avak.repositories.CursoRepository;

@Service
public class CursoService extends BaseService<Curso, CursoDTO> {
	
	@Autowired
	public CursoService(CursoRepository repository) {
		super(repository);
	}
	
	@Override
	public Class<Curso> getTClass() {
		return Curso.class;
	}

	@Override
	public Curso fromDTO(CursoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
}
