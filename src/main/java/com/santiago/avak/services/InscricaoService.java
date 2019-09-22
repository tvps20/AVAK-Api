package com.santiago.avak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santiago.avak.domain.Curso;
import com.santiago.avak.domain.Inscricao;
import com.santiago.avak.domain.Usuario;
import com.santiago.avak.domain.enuns.TipoUsuario;
import com.santiago.avak.domain.exceptions.IllegalEnumException;
import com.santiago.avak.dtos.InscricaoDTO;
import com.santiago.avak.repositories.InscricaoRepository;
import com.santiago.avak.services.exceptions.InscricaoException;

@Service
public class InscricaoService extends BaseService<Inscricao, InscricaoDTO> {
	
	@Autowired
	private CursoService cursoService; 
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	public InscricaoService(InscricaoRepository repository) {
		super(repository);
	}
	
	@Override
	public Class<Inscricao> getTClass() {
		return Inscricao.class;
	}

	@Override
	public Inscricao fromDTO(InscricaoDTO dto) {
		Curso curso = this.cursoService.findById(dto.getCursoId());
		Usuario user = this.usuarioService.findById(dto.getAlunoId());
		return new Inscricao(dto.getId(), user, dto.isCompleto(), dto.getTipo(), curso);
	}

	@Override
	public void updateData(Inscricao newObj, Inscricao obj) {
		newObj.setCompleto(obj.isCompleto());
	}
	
    @Override
    public Inscricao insert(Inscricao entity) {
    	entity.setId(null);
    	this.verificaInscricao(entity);
        return this.repository.save(entity);
    }

	private void verificaInscricao(Inscricao entity) {
		if(entity.getAluno().getId() == entity.getCurso().getProfessor().getId()) {
			throw new InscricaoException("O Aluno de id " + entity.getAluno().getId() + " já é professor no curso de id " + entity.getCurso().getProfessor().getId() + ", Tipo: " +  this.getTClass().getName());
		}
		if(entity.getTipo().toString() == TipoUsuario.PROFESSOR.toString()) {
			throw new IllegalEnumException("A incrição so pode ser feita para tipos [ALUNO, TUTOR], Tipo: " +  this.getTClass().getName());
		}
	}
}
