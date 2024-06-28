package com.projetospring.primeiroSpring.resources;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetospring.primeiroSpring.entities.Order;
import com.projetospring.primeiroSpring.services.OrderService;

//Define que essa classe é um recurso web implementada por um controlador Rest
@RestController
//url para acessar o banco de dados através do localhost
//localhost:8080/orders
@RequestMapping(value = "/orders")
public class OrderResource {
	
	//dependencia para service
	@Autowired
	private OrderService service;
	
	//metododo que encontra os dados da tabela
	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
