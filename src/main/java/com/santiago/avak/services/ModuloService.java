package com.santiago.avak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.avak.domain.Curso;
import com.santiago.avak.domain.Modulo;
import com.santiago.avak.dtos.ModuloDTO;
import com.santiago.avak.repositories.ModuloRepository;

@Service
public class ModuloService extends BaseService<Modulo, ModuloDTO> {
	
	@Autowired
	private CursoService cursoService; 
	
	@Autowired
	public ModuloService(ModuloRepository repository) {
		super(repository);
	}
	
	@Override
	public Class<Modulo> getTClass() {
		return Modulo.class;
	}

	@Override
	public Modulo fromDTO(ModuloDTO dto) {
		Curso curso = this.cursoService.findById(dto.getCursoId());
		return new Modulo(dto.getId(), dto.getNome(), dto.getDescricao(), curso);
	}

	@Override
	public void updateData(Modulo newObj, Modulo obj) {
		newObj.setNome(obj.getNome());
		newObj.setDescricao(obj.getDescricao());
		newObj.setCurso(obj.getCurso());
	}
}
