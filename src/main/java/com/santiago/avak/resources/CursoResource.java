package com.santiago.avak.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santiago.avak.domain.Curso;
import com.santiago.avak.services.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoResource {
	
	@Autowired
	private CursoService service;
	
	@GetMapping
	public ResponseEntity<List<Curso>> listar() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Curso> findById(@PathVariable Long id){
		Curso curso = this.service.findById(id);
		return ResponseEntity.ok().body(curso);
	}
}
