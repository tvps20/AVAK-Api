package com.santiago.avak.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santiago.avak.domain.AulaStatus;

@Repository
public interface AulaStatusRepository extends JpaRepository<AulaStatus, Long>{

}
