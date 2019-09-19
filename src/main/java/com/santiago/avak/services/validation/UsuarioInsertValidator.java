package com.santiago.avak.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.santiago.avak.domain.Usuario;
import com.santiago.avak.dtos.UsuarioDTO;
import com.santiago.avak.resources.exceptions.FieldMessage;
import com.santiago.avak.services.UsuarioService;

public class UsuarioInsertValidator implements ConstraintValidator<UsuarioInsert, UsuarioDTO>  {

	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public void initialize(UsuarioInsert ann) {
	}
	
	@Override
	public boolean isValid(UsuarioDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		Usuario aux = this.usuarioService.findByEmail(objDto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email já cadastrado"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		
		return list.isEmpty();
	}

}
