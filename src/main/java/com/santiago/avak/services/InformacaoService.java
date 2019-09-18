package com.santiago.avak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.avak.domain.Informacao;
import com.santiago.avak.dtos.InformacaoDTO;
import com.santiago.avak.repositories.InformacaoRepository;

@Service
public class InformacaoService extends BaseService<Informacao, InformacaoDTO> {
	
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
		// TODO Auto-generated method stub
		return null;
	}
}
