package com.santiago.avak.resources;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santiago.avak.dtos.PasswordNewDTO;
import com.santiago.avak.security.JWTUtil;
import com.santiago.avak.security.UserSS;
import com.santiago.avak.services.AuthService;
import com.santiago.avak.services.UsuarioService;

@RestController
@RequestMapping("/auth")
public class AuthResource {
	
	@Autowired
	private JWTUtil jwtUtil;
	@Autowired
	private AuthService authService;

	@PostMapping("/refresh_token")
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		UserSS user = UsuarioService.authenticated();
		String token = jwtUtil.generateToken(user.getUsername());
		response.addHeader("Authorization", "Bearer " + token);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/forgot")
	public ResponseEntity<String> forgotPassword(@Valid @RequestBody PasswordNewDTO objDto){
		this.authService.changeNewPassword(objDto);
		return ResponseEntity.noContent().build();
	}
}
