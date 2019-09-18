package com.santiago.avak;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.santiago.avak.domain.Aula;
import com.santiago.avak.domain.Curso;
import com.santiago.avak.domain.Forum;
import com.santiago.avak.domain.Informacao;
import com.santiago.avak.domain.Modulo;
import com.santiago.avak.domain.Usuario;
import com.santiago.avak.domain.enuns.TipoUsuario;
import com.santiago.avak.repositories.AulaRepository;
import com.santiago.avak.repositories.CursoRepository;
import com.santiago.avak.repositories.ForumRepository;
import com.santiago.avak.repositories.InformacaoRepository;
import com.santiago.avak.repositories.ModuloRepository;
import com.santiago.avak.repositories.UsuarioRepository;

@SpringBootApplication
public class AvakApplication implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private CursoRepository cursoRepository;
	@Autowired
	private InformacaoRepository informacaoRepository;
	@Autowired
	private ModuloRepository moduloRepository;
	@Autowired
	private AulaRepository aulaRepository;
	@Autowired
	private ForumRepository forumRepository; 
	
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
		
		Modulo mod1 = new Modulo(null, "Configurando o Ambiente", "Configuração de ambiente", curso2);
		Modulo mod2 = new Modulo(null, "Implementação do modelo conceitual", "Diagrama conceitual e implementação", curso2);
		Modulo mod3 = new Modulo(null, "Apresentação do curso", "Apresentação do curso de banco de dados", curso1);
		
		curso1.getModulos().add(mod3);
		curso2.getModulos().addAll(Arrays.asList(mod1, mod2));
		
		Aula aula1 = new Aula(null, "Implementação do modelo conceitual", "Vamos implementar o modelo conceitual", "www.video.com", "atividade 01", mod2);
		Aula aula2 = new Aula(null, "Visão geral do estudo de caso", "Visão geral do estudo de caso do capítulo", "www.video.com", "atividade 02", mod2);
	
		mod2.getAulas().addAll(Arrays.asList(aula1, aula2));
		
		Forum forum1 = new Forum(null, user1, "Galera aula hoje vai ser boa", aula1, TipoUsuario.PROFESSOR);
		Forum forum2 = new Forum(null, user2, "Tenho uma duvida", aula1, TipoUsuario.ALUNO);
		
		this.usuarioRepository.saveAll(Arrays.asList(user1, user2));
		this.cursoRepository.saveAll(Arrays.asList(curso1, curso2));
		this.informacaoRepository.saveAll(Arrays.asList(info1, info2, info3));
		this.moduloRepository.saveAll(Arrays.asList(mod1, mod2, mod3));
		this.aulaRepository.saveAll(Arrays.asList(aula1, aula2));
		this.forumRepository.saveAll(Arrays.asList(forum1, forum2));
	}
}
