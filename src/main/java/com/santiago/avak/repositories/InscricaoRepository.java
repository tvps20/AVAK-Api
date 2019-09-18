package com.santiago.avak.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santiago.avak.domain.Inscricao;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Long>{

}
