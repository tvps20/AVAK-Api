package com.santiago.avak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.avak.domain.Aula;
import com.santiago.avak.domain.AulaStatus;
import com.santiago.avak.domain.Inscricao;
import com.santiago.avak.dtos.AulaStatusDTO;
import com.santiago.avak.repositories.AulaStatusRepository;

@Service
public class AulaStatusService extends BaseService<AulaStatus, AulaStatusDTO> {
	
	@Autowired
	private AulaService aulaService;
	@Autowired
	private InscricaoService inscricaoService;
	
	@Autowired
	public AulaStatusService(AulaStatusRepository repository) {
		super(repository);
	}
	
	@Override
	public Class<AulaStatus> getTClass() {
		return AulaStatus.class;
	}

	@Override
	public AulaStatus fromDTO(AulaStatusDTO dto) {
		Aula aula = this.aulaService.findById(dto.getAulaId());
		Inscricao inscricao = this.inscricaoService.findById(dto.getInscricaoId());
		return new AulaStatus(dto.getId(), aula, dto.isCompleto(), dto.getResultado(), dto.getQtdCertas(), inscricao);
	}

	@Override
	public void updateData(AulaStatus newObj, AulaStatus obj) {
		newObj.setAula(obj.getAula());
		newObj.setCompelto(obj.isCompleto());
		newObj.setResultado(obj.getResultado());
		newObj.setQtdCertas(obj.getQtdCertas());
		newObj.setInscricao(obj.getInscricao());
	}
}
