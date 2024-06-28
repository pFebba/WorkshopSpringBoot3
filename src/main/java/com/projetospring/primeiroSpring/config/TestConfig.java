package com.projetospring.primeiroSpring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetospring.primeiroSpring.entities.User;
import com.projetospring.primeiroSpring.repositories.UserRepository;

//Mostras que é uma classe específica de configuração
@Configuration
//Mostra que a classe é específica para o perfil de teste
@Profile("test")
public class TestConfig implements CommandLineRunner {
	//Resolve a dependência e associa uma instância do UserRepository
	@Autowired

	private UserRepository userRepository;

	//Tudo dentro desse método será executado quando a aplicação for iniciada
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		//Salvo os dados no banco de dados
	    userRepository.saveAll(Arrays.asList(u1,u2));
	}
}
