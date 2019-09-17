package com.santiago.avak.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santiago.avak.domain.Modulo;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Long>{

}
