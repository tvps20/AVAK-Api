package com.santiago.avak.services.interfaces;

import java.util.List;

import com.santiago.avak.domain.AbstractEntity;

/**
 * Define como deve ser um Serviço para interagir com a base de dados e com as Entidades
 * Representa a camada entre o controller e o repositorio
 *
 * @param <T> Entidade relacionada ao repositorio
 * @author Santiago Brothers
 */
public interface IService<T extends AbstractEntity> {
	
	 /**
     * Recupera todas as entidade da base de dados
     *
     * @return Uma lista com todas as entidades
     */
    public List<T> listAll();

    /**
     * Recupera uma entidade da base de dados
     *
     * @param id Idenficador da entidade a ser recuperada
     * @return Container que encapsula a entidade
     */
    public T findById(Long id);

    /**
     * Cria ou atualiza uma entidade
     *
     * @param entity Entitdade a ser salva
     * @return Nova ou atualizada entidade
     */
    public T save(T entity);

    /**
     * Atualiza uma entidade
     *
     * @param entity Entitdade a ser atualizada
     * @return Entitdade Atualizada
     */
    public T update(T entity);

    /**
     * Exclue uma entidade da base de dados
     *
     * @param id Idenficador da entidade a ser excluida
     */
    public void delete(Long id);
}
