package com.acsanfrancisco.firstspringproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acsanfrancisco.firstspringproject.entities.User;
import com.acsanfrancisco.firstspringproject.services.UserService;

@RestController // indica que essa classe responde requisições HTTP (@Controller, @ResponseBody)
@RequestMapping("/user") // define qual a rota da URL (/user)
public class UserResource {
	
	@Autowired
	private UserService service;

	@GetMapping // define que esse método responde requisições HTTP do tipo GET
	public ResponseEntity<List<User>> findAll(){ 
		  // monta a resposta HTTP completa, cuida dos dados retornados, o status HTTP e informações extras (header)
		
		List<User> userList = service.findAll();
		return ResponseEntity.ok().body(userList); // .ok() define o status HTTP, .body() define o corpo da resposta
	}
	
	@GetMapping(value= "/{id}") //responde requisições do tipo GET com um ID na URL
	public ResponseEntity<User> findById(@PathVariable Long id){  // pega o valor da URL
		User u = service.findById(id);
		return ResponseEntity.ok().body(u);
	}
}
