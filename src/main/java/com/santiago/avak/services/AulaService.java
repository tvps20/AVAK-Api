package com.santiago.avak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.avak.domain.Aula;
import com.santiago.avak.dtos.AulaDTO;
import com.santiago.avak.repositories.AulaRepository;

@Service
public class AulaService extends BaseService<Aula, AulaDTO> {
	
	@Autowired
	public AulaService(AulaRepository repository) {
		super(repository);
	}
	
	@Override
	public Class<Aula> getTClass() {
		return Aula.class;
	}

	@Override
	public Aula fromDTO(AulaDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
}
