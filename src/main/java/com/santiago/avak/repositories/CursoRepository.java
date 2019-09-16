package com.santiago.avak.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santiago.avak.domain.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{

}
