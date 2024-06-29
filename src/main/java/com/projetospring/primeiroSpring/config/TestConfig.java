package com.projetospring.primeiroSpring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projetospring.primeiroSpring.entities.Category;
import com.projetospring.primeiroSpring.entities.Order;
import com.projetospring.primeiroSpring.entities.OrderItem;
import com.projetospring.primeiroSpring.entities.Product;
import com.projetospring.primeiroSpring.entities.User;
import com.projetospring.primeiroSpring.entities.enums.OrderStatus;
import com.projetospring.primeiroSpring.repositories.CategoryRepository;
import com.projetospring.primeiroSpring.repositories.OrderItemRepository;
import com.projetospring.primeiroSpring.repositories.OrderRepository;
import com.projetospring.primeiroSpring.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

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
	    
	    
	    
	    Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
	    Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
	    Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
	    Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
	    Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
	    categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
	    productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
	   
	    cat2.getProducts().add(p1);
	    cat1.getProducts().add(p2);
	    cat3.getProducts().add(p2);
	    cat3.getProducts().add(p3);
	    cat3.getProducts().add(p4);
	    cat2.getProducts().add(p5);
	   
	    categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
	    
	    OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
	    OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
	    OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
	    OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
	    
	    orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
	}
	
	
}
