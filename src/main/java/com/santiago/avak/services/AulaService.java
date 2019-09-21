package com.santiago.avak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.avak.domain.Aula;
import com.santiago.avak.domain.Modulo;
import com.santiago.avak.dtos.AulaDTO;
import com.santiago.avak.repositories.AulaRepository;

@Service
public class AulaService extends BaseService<Aula, AulaDTO> {
	
	@Autowired
	private ModuloService moduloService;
	
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
		Modulo mod = this.moduloService.findById(dto.getModuloId());
		return new Aula(dto.getId(), dto.getNome(), dto.getDescricao(), dto.getVideo(), dto.getAtividade(), mod);
	}

	@Override
	public void updateData(Aula newObj, Aula obj) {
		newObj.setNome(obj.getNome());
		newObj.setDescricao(obj.getDescricao());
		newObj.setAtividade(obj.getAtividade());
		newObj.setVideo(obj.getVideo());
		newObj.setModulo(obj.getModulo());	
	}
}
