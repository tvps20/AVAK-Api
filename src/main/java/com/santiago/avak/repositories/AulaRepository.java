package com.santiago.avak.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santiago.avak.domain.Aula;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long>{

}
