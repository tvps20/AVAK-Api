package com.santiago.avak.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santiago.avak.domain.Aula;
import com.santiago.avak.services.AulaService;

@RestController
@RequestMapping("/aulas")
public class AulaResource {
	
	@Autowired
	private AulaService service;
	
	@GetMapping
	public ResponseEntity<List<Aula>> listar() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aula> findById(@PathVariable Long id){
		Aula aula = this.service.findById(id);
		return ResponseEntity.ok().body(aula);
	}
}
