package com.santiago.avak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.avak.domain.Aula;
import com.santiago.avak.domain.Forum;
import com.santiago.avak.domain.Usuario;
import com.santiago.avak.dtos.ForumDTO;
import com.santiago.avak.repositories.ForumRepository;

@Service
public class ForumService extends BaseService<Forum, ForumDTO> {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private AulaService aulaService;
	
	@Autowired
	public ForumService(ForumRepository repository) {
		super(repository);
	}
	
	@Override
	public Class<Forum> getTClass() {
		return Forum.class;
	}

	@Override
	public Forum fromDTO(ForumDTO dto) {
		Usuario user = this.usuarioService.findById(dto.getUsuarioId());
		Aula aula = this.aulaService.findById(dto.getAulaId());
		return new Forum(dto.getId(), user, dto.getMensagem(), aula, dto.getTipo());
	}

	@Override
	public void updateData(Forum newObj, Forum obj) {
		newObj.setMensagem(obj.getMensagem());
		newObj.setAula(obj.getAula());
		newObj.setUsuario(obj.getUsuario());
	}
}
