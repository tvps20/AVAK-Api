package com.santiago.avak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.avak.domain.Usuario;
import com.santiago.avak.repositories.UsuarioRepository;


@Service
public class UsuarioService extends BaseService<Usuario> {
	
	@Autowired	
	public UsuarioService(UsuarioRepository repository) {
		super(repository);
	}

	@Override
	public Class<Usuario> getTClass() {
		return Usuario.class;
	}
}
