package com.santiago.avak.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santiago.avak.domain.AbstractEntity;
import com.santiago.avak.services.exceptions.ObjectNotFoundException;
import com.santiago.avak.services.interfaces.IService;

public abstract class BaseService<T extends AbstractEntity> implements IService<T> {

	 /**
     * Repositorio interno
     */
    protected JpaRepository<T, Long> repository;
    
    public BaseService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }
    
    /**
     * Recupera todas as entidades tipo T da base de dados
     *
     * @return Lista com todos os elementos da base de dados
     */
    @Override
    public List<T> listAll() {
        return this.repository.findAll();
    }

    /**
     * Recupera uma entidade atravez do seu identificador
     *
     * @param id Idenficador da entidade a ser recuperada
     * @return Container da entidade T
     */
    @Override
    public T findById(Long id) throws ObjectNotFoundException {
    	Optional<T> obj = this.repository.findById(id);
    	return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " +  this.getTClass().getName()));
    }
    
    /**
     * Cria ou atualiza uma Entidade
     *
     * @param dto Dto com as informações a serem transformadas em Entidade
     * @return Entidade T
     */
    @Override
    public T save(T entity) {
        return this.repository.save(entity);
    }

    /**
     * Atualiza uma entidade
     *
     * @param entity Entitdade a ser atualizada
     * @return Entitdade Atualizada
     */
    @Override
    public T update(T entity) {
        return this.repository.save(entity);
    }

    /**
     * Exclue uma Entidade da base de dados
     *
     * @param id Idenficador da Entidade a ser excluida
     */
    @Override
    public void delete(Long id) {

        this.repository.deleteById(id);
    }
    
    /**
     * Método para obter o nome da classe
     * @return uma instancia da classe generica do tipo T
     */
    public abstract Class<T> getTClass();
}
