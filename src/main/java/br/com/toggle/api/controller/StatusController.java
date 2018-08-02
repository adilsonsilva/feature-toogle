package br.com.toggle.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.toggle.api.enums.Funcionalidade;

@RestController
public class StatusController {
	
	@GetMapping("/recuperar/nome")
	public ResponseEntity<String> isToggleLigada() {
		
		StringBuilder sb = new StringBuilder("Adilson");
		
		if(Funcionalidade.HABILITA_SOBRE_NOME.isActive()) {
			sb.append(" Rodrigues da Silva");
		}
		
		return new ResponseEntity<String>(sb.toString(), HttpStatus.OK);
	}
	

}
