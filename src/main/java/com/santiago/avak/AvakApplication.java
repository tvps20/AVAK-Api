package com.santiago.avak;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.santiago.avak.domain.Curso;
import com.santiago.avak.domain.Informacao;
import com.santiago.avak.domain.Usuario;
import com.santiago.avak.repositories.CursoRepository;
import com.santiago.avak.repositories.InformacaoRepository;
import com.santiago.avak.repositories.UsuarioRepository;

@SpringBootApplication
public class AvakApplication implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private CursoRepository cursoRepository;
	@Autowired
	private InformacaoRepository informacaoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AvakApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Usuario user1 = new Usuario(null, "thiago@email.com", "Thiago", "123");
		Usuario user2 = new Usuario(null, "filipe@email.com", "Filipe", "123");
		
		Curso curso1 = new Curso(null, "Banco de dados", "Curso de banco de dados", user1);
		Curso curso2 = new Curso(null, "Spring boot", "Curso de Spring Boot", user1);
		
		user1.getCursos().addAll(Arrays.asList(curso1, curso2));
		
		Informacao info1 = new Informacao(null, "Hoje a aula sera no lab2", curso1);
		Informacao info2 = new Informacao(null, "Aula normal", curso1);
		Informacao info3 = new Informacao(null, "Aula normal", curso2);
		
		curso1.getInformacoes().addAll(Arrays.asList(info1, info2));
		curso2.getInformacoes().add(info2);
			
		this.usuarioRepository.saveAll(Arrays.asList(user1, user2));
		this.cursoRepository.saveAll(Arrays.asList(curso1, curso2));
		this.informacaoRepository.saveAll(Arrays.asList(info1, info2, info3));
	}
}
