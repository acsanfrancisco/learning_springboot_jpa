package com.acsanfrancisco.firstspringproject.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acsanfrancisco.firstspringproject.entities.User;

@RestController // indica que essa classe responde requisições HTTP (@Controller, @ResponseBody)
@RequestMapping("/user") // define qual a rota da URL (/user)
public class UserResource {

	@GetMapping // define que esse método responde requisições HTTP do tipo GET
	public ResponseEntity<User> findAll(){ 
		  // monta a resposta HTTP completa, cuida dos dados retornados, o status HTTP e informações extras (header)
		
		User user = new User(1L, "Maria", "maria@gmail.com", "998934323", "12345");
		return ResponseEntity.ok().body(user); // .ok() define o status HTTP, .body() define o corpo da resposta
	}
}
