package com.santiago.avak.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.avak.domain.Usuario;
import com.santiago.avak.repositories.UsuarioRepository;
import com.santiago.avak.services.exceptions.ObjectNotFoundException;


@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> listAll() {
		return this.repository.findAll();
	}
	
	public Usuario findById(Long id) throws ObjectNotFoundException {
		Optional<Usuario> obj = this.repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
}
