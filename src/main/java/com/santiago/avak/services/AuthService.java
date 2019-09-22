package com.santiago.avak.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.santiago.avak.domain.Usuario;
import com.santiago.avak.dtos.PasswordNewDTO;
import com.santiago.avak.repositories.UsuarioRepository;
import com.santiago.avak.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder crypt;
	
	private Random rand = new Random();
	
	public String sendNewPassword(String email) {
		Usuario user = this.usuarioRepository.findByEmail(email);
		
		if(user == null) {
			throw new ObjectNotFoundException("Email não encontrado");
		}
		
		String newPassword = this.newPassword();
		user.setPassword(this.crypt.encode(newPassword));
		
		this.usuarioRepository.save(user);
		
		// O método deveria ser void e chamar um serviço de email.
		return newPassword;
	}
	
	public void changeNewPassword(PasswordNewDTO objDto) {
		Usuario user = this.usuarioRepository.findByEmail(objDto.getEmail());
		
		if(user == null) {
			throw new ObjectNotFoundException("Email não encontrado");
		}
		
		user.setPassword(this.crypt.encode(objDto.getNewPassword()));
		
		this.usuarioRepository.save(user);
	}

	private String newPassword() {
		char[] vetor = new char[10];
		
		for(int i=0; i<10; i++) {
			vetor[i] = this.randomChar();
		}
		return new String(vetor);
	}

	private char randomChar() {
		int opt = rand.nextInt(3);
		
		if(opt == 0) { // gera um digito
			return (char) (rand.nextInt(10) + 48);
		}
		else if( opt == 2) { // gera letra maiuscula
			return (char) (rand.nextInt(26) + 65);
		}
		else { // gera uma letra minuscula
			return (char) (rand.nextInt(26) + 97);
		}
	}
}
