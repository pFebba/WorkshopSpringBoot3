package com.projetospring.primeiroSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetospring.primeiroSpring.entities.Order;
import com.projetospring.primeiroSpring.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepostitory;
	
	public List<Order> findAll(){
		return orderRepostitory.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = orderRepostitory.findById(id);
		return obj.get();
	}
	
}
