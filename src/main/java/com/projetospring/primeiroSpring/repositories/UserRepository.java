package com.projetospring.primeiroSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetospring.primeiroSpring.entities.User;

//Não precisa do @Repository, pois já extende um Repository
public interface UserRepository extends JpaRepository<User, Long>{
}
