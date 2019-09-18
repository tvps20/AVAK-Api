package com.santiago.avak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.avak.domain.Modulo;
import com.santiago.avak.repositories.ModuloRepository;

@Service
public class ModuloService extends BaseService<Modulo> {
	
	@Autowired
	public ModuloService(ModuloRepository repository) {
		super(repository);
	}
	
	@Override
	public Class<Modulo> getTClass() {
		return Modulo.class;
	}
}
