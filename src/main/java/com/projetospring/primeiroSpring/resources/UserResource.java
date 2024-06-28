package com.projetospring.primeiroSpring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetospring.primeiroSpring.entities.User;
import com.projetospring.primeiroSpring.services.UserService;

//Define que essa classe é um recurso web implementada por um controlador Rest
@RestController
//url para acessar o banco de dados através do localhost
//localhost:8080/users
@RequestMapping(value = "/users")
public class UserResource {
	
	//dependencia para service
	@Autowired
	private UserService service;
	
	//metododo que encontra os dados da tabela
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
