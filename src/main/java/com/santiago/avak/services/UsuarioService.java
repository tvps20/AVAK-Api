package com.santiago.avak.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.santiago.avak.domain.Usuario;
import com.santiago.avak.domain.enuns.TipoPerfil;
import com.santiago.avak.dtos.UsuarioDTO;
import com.santiago.avak.repositories.UsuarioRepository;
import com.santiago.avak.security.UserSS;
import com.santiago.avak.services.exceptions.AuthorizationException;
import com.santiago.avak.services.exceptions.ObjectNotFoundException;


@Service
public class UsuarioService extends BaseService<Usuario, UsuarioDTO> {
	
	@Autowired
	private BCryptPasswordEncoder crypt;
	
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
		return new Usuario(dto.getId(), dto.getEmail(), dto.getNome(), this.crypt.encode(dto.getPassword()));
	}
	
    @Override
    public Usuario findById(Long id) throws ObjectNotFoundException {
    	UserSS user = this.authenticated();
    	if(user == null || !user.hasRole(TipoPerfil.ADMIN) && !id.equals(user.getId())) {
    		throw new AuthorizationException("Acesso negado");
    	}
    	
    	Optional<Usuario> obj = this.repository.findById(id);
    	return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " +  this.getTClass().getName()));
    }

	@Override
	public void updateData(Usuario newObj, Usuario obj) {
		newObj.setEmail(obj.getEmail());
		newObj.setPassword(obj.getPassword());
		newObj.setNome(obj.getNome());
	}
	
	 /**
     * Executa um cast do objeto repositorio generico da super classe para o tipo especifico do servico
     *
     * @return Repositorio especifico do servico
     */
    private UsuarioRepository getRepository() {
        return (UsuarioRepository) this.repository;
    }
	
	public Usuario findByEmail(String email) {
		return this.getRepository().findByEmail(email);
	}
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();			
		} catch (Exception e) {
			return null;
		}
	}
}
