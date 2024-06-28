package com.projetospring.primeiroSpring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.projetospring.primeiroSpring.entities.User;
import com.projetospring.primeiroSpring.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRespository;
	
	public List<User> findAll(){
		return userRespository.findAll();
	}
	
	public User findById(Long id) {
		//Optionalpode se considerar um contêiner 
		//de valor único que, ou contém um valor ou não contém
		Optional<User> obj = userRespository.findById(id);
		return obj.get();
	}
	

}
