package com.acsanfrancisco.firstspringproject.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.acsanfrancisco.firstspringproject.entities.Category;
import com.acsanfrancisco.firstspringproject.entities.Order;
import com.acsanfrancisco.firstspringproject.entities.User;
import com.acsanfrancisco.firstspringproject.entities.enums.OrderStatus;
import com.acsanfrancisco.firstspringproject.repositories.CategoryRepository;
import com.acsanfrancisco.firstspringproject.repositories.OrderRepository;
import com.acsanfrancisco.firstspringproject.repositories.UserRepository;

@Configuration // indica que é uma classe de configuração
@Profile("test") // indica que esta configuração é para o perfil de testes, e só vai rodar quando o perfil de testes estiver ativado
public class TestConfig implements CommandLineRunner{ 
	// interface do SpringBoot para executar um código assim que o programa inicia

	@Autowired /* Spring cria uma instância do UserRepository ( faz o controle da injeção de dependência ), também pode ser feito por meio de construtor */ 
	/*   public TestConfig(UserRepository userRepository){
	this.userRepository = userRepository;
    }   */
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override 
	// Preenchimento do banco de dados H2
	public void run(String... args) throws Exception { 
		//oque estiver dentro desse método será executado 
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "998934323", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		User u3 = new User(null, "João Francisco", "joaosanneto225@gmail.com", "998934323", "12345");
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.SHIPPED, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.CANCELED , u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT , u3);
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		Category c1 = new Category(null, "Electronics");
		Category c2 = new Category(null, "Books");
		Category c3 = new Category(null, "Computers"); 
		
		categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
	}                            
}
