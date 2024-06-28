package com.projetospring.primeiroSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetospring.primeiroSpring.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
