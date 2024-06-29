package com.projetospring.primeiroSpring.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	//dois endpoints que servem para recuperar dados no banco de dados.
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//A anotation abaixo é utilizada quando é um método que irá inserir um dado no banco de dados
	@PostMapping
	public ResponseEntity <User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		//transforma para um location URI
		URI uri = ServletUriComponentsBuilder.
				fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	//Anotation para deletar do banco de dados
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id,@RequestBody User obj){
		obj = service.update(id,obj);
		return ResponseEntity.ok().body(obj);
	}
	
}
