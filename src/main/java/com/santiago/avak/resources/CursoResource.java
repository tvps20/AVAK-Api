package com.santiago.avak.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.santiago.avak.domain.Curso;
import com.santiago.avak.dtos.CursoDTO;
import com.santiago.avak.services.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoResource {
	
	@Autowired
	private CursoService service;
	
	@GetMapping
	public ResponseEntity<List<Curso>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/page")
	public ResponseEntity<Page<CursoDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Curso> list = service.findPage(page, linesPerPage, direction, orderBy);
		Page<CursoDTO> listDTO = list.map(obj -> new CursoDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Curso> findById(@PathVariable Long id){
		Curso obj = this.service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody CursoDTO objDTO){
		Curso obj = service.fromDTO(objDTO);
		obj = this.service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody CursoDTO objDTO, @PathVariable Long id){
		Curso obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = this.service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		this.service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
