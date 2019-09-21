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

import com.santiago.avak.domain.Forum;
import com.santiago.avak.dtos.ForumDTO;
import com.santiago.avak.services.ForumService;

@RestController
@RequestMapping("/forum")
public class ForumResource {
	
	@Autowired
	private ForumService service;
	
	@GetMapping
	public ResponseEntity<List<Forum>> listar() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/page")
	public ResponseEntity<Page<ForumDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Forum> list = service.findPage(page, linesPerPage, direction, orderBy);
		Page<ForumDTO> listDTO = list.map(obj -> new ForumDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Forum> findById(@PathVariable Long id){
		Forum aula = this.service.findById(id);
		return ResponseEntity.ok().body(aula);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody ForumDTO objDTO){
		Forum obj = service.fromDTO(objDTO);
		obj = this.service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody ForumDTO objDTO, @PathVariable Long id){
		Forum obj = service.fromDTO(objDTO);
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
