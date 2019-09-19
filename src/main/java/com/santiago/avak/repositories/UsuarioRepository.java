package com.santiago.avak.repositories;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santiago.avak.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	// Especifica que nenhuma operação de DML poderá ser executada (Insert, Delete ou Update), ou seja, apenas consultas.
	@Transactional(readOnly=true)
	Usuario findByEmail(String email);
}
