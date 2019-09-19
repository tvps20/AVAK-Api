package com.santiago.avak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.avak.domain.Curso;
import com.santiago.avak.domain.Informacao;
import com.santiago.avak.dtos.InformacaoDTO;
import com.santiago.avak.repositories.InformacaoRepository;

@Service
public class InformacaoService extends BaseService<Informacao, InformacaoDTO> {
	
	@Autowired
	private CursoService cursoService; 
	
	@Autowired
	public InformacaoService(InformacaoRepository repository) {
		super(repository);
	}
	
	@Override
	public Class<Informacao> getTClass() {
		return Informacao.class;
	}

	@Override
	public Informacao fromDTO(InformacaoDTO dto) {
		Curso curso = this.cursoService.findById(dto.getCursoId());
		return new Informacao(dto.getId(), dto.getDescricao(), curso);
	}

	@Override
	public void updateData(Informacao newObj, Informacao obj) {
		newObj.setDescricao(obj.getDescricao());
		newObj.setCurso(obj.getCurso());
	}
}
