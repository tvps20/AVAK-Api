package com.santiago.avak.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.santiago.avak.domain.Usuario;
import com.santiago.avak.dtos.UsuarioDTO;
import com.santiago.avak.resources.exceptions.FieldMessage;
import com.santiago.avak.services.UsuarioService;

public class UsuarioClassValidator implements ConstraintValidator<UsuarioValidator, UsuarioDTO>  {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public void initialize(UsuarioValidator ann) {
	}
	
	@Override
	public boolean isValid(UsuarioDTO objDto, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		List<FieldMessage> list = new ArrayList<>();
		Usuario aux = this.usuarioService.findByEmail(objDto.getEmail());
		
		try {
			// Fazendo um  put
			Long uriId = Long.parseLong(map.get("id"));
			
			if (aux != null && !aux.getId().equals(uriId)) {
				list.add(new FieldMessage("email", "Email já existente"));
			}
			
		} catch (NumberFormatException ex) {
			// Fazendo um post
			if (aux != null) {
				list.add(new FieldMessage("email", "Email já cadastrado"));
			}
			
		} catch (Exception ex) {
			list.add(new FieldMessage("validação", "Problemas na validação"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		
		return list.isEmpty();
	}

}
