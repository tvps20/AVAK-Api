package com.santiago.avak.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santiago.avak.domain.Informacao;

@Repository
public interface InformacaoRepository extends JpaRepository<Informacao, Long>{

}
