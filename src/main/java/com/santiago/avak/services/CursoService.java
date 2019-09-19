package com.santiago.avak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.avak.domain.Curso;
import com.santiago.avak.domain.Usuario;
import com.santiago.avak.dtos.CursoDTO;
import com.santiago.avak.repositories.CursoRepository;

@Service
public class CursoService extends BaseService<Curso, CursoDTO> {
	
	@Autowired
	private UsuarioService usuarioService;
	
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
		Usuario prof = usuarioService.findById(dto.getProfessorId());
		Curso curso = new Curso(dto.getId(), dto.getNome(), dto.getDescricao(), prof);
		return curso;
	}

	@Override
	public void updateData(Curso newObj, Curso obj) {
		newObj.setNome(obj.getNome());
		newObj.setDescricao(obj.getDescricao());
		newObj.setProfessor(obj.getProfessor());
	}
}
