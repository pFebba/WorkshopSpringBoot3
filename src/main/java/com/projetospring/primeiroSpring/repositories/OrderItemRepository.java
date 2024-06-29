package com.projetospring.primeiroSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetospring.primeiroSpring.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
