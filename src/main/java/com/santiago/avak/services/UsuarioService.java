package com.santiago.avak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.avak.domain.Usuario;
import com.santiago.avak.dtos.UsuarioDTO;
import com.santiago.avak.repositories.UsuarioRepository;


@Service
public class UsuarioService extends BaseService<Usuario, UsuarioDTO> {
	
	@Autowired	
	public UsuarioService(UsuarioRepository repository) {
		super(repository);
	}

	@Override
	public Class<Usuario> getTClass() {
		return Usuario.class;
	}

	@Override
	public Usuario fromDTO(UsuarioDTO dto) {
		return new Usuario(dto.getId(), dto.getEmail(), dto.getNome(), dto.getPassword());
	}

	@Override
	public void updateData(Usuario newObj, Usuario obj) {
		newObj.setEmail(obj.getEmail());
		newObj.setPassword(obj.getPassword());
		newObj.setNome(obj.getNome());
	}
}
