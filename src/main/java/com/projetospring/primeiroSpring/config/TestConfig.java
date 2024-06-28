package com.projetospring.primeiroSpring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetospring.primeiroSpring.entities.Category;
import com.projetospring.primeiroSpring.entities.Order;
import com.projetospring.primeiroSpring.entities.User;
import com.projetospring.primeiroSpring.entities.enums.OrderStatus;
import com.projetospring.primeiroSpring.repositories.CategoryRepository;
import com.projetospring.primeiroSpring.repositories.OrderRepository;
import com.projetospring.primeiroSpring.repositories.UserRepository;

//Mostras que é uma classe específica de configuração
@Configuration
//Mostra que a classe é específica para o perfil de teste
@Profile("test")
public class TestConfig implements CommandLineRunner {
	//Resolve a dependência e associa uma instância do UserRepository
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	//Tudo dentro desse método será executado quando a aplicação for iniciada
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		//Salvo os dados no banco de dados
	    userRepository.saveAll(Arrays.asList(u1,u2));
	    
	    Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),
	    		u1,OrderStatus.DELIVERED);
	    Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),
	    		u2,OrderStatus.CANCELED);
	    Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),
	    		u1,OrderStatus.PAID);
	    
	    orderRepository.saveAll(Arrays.asList(o1,o2,o3));
	    
	    Category cat1 = new Category(null, "Electronics");
	    Category cat2 = new Category(null, "Books");
	    Category cat3 = new Category(null, "Computers");
	    
	    categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
	}
	
	
}
