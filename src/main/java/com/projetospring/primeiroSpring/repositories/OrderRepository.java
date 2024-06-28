package com.projetospring.primeiroSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetospring.primeiroSpring.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
}
