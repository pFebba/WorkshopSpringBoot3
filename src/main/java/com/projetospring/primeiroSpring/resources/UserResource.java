package com.projetospring.primeiroSpring.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetospring.primeiroSpring.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User( 1L,"Neias","neias@gmail.com","(11) 9 9999-1111","senha");
		return ResponseEntity.ok().body(u);
	}
}
