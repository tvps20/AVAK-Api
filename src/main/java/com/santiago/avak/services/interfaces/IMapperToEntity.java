package com.santiago.avak.services.interfaces;

import com.santiago.avak.domain.AbstractEntity;
import com.santiago.avak.dtos.BaseDTO;

public interface IMapperToEntity<K extends BaseDTO, T extends AbstractEntity>{
	
	/**
     * Executa a transformação da Dto em Entidade
     *
     * @param dto Dto a ser transformada
     * @return Entidade resultante da transformação
     */
    T fromDTO(K dto);
}
