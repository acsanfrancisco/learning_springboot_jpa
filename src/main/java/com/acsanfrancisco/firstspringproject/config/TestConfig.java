package com.acsanfrancisco.firstspringproject.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.acsanfrancisco.firstspringproject.entities.Category;
import com.acsanfrancisco.firstspringproject.entities.Order;
import com.acsanfrancisco.firstspringproject.entities.OrderItem;
import com.acsanfrancisco.firstspringproject.entities.Payment;
import com.acsanfrancisco.firstspringproject.entities.Product;
import com.acsanfrancisco.firstspringproject.entities.User;
import com.acsanfrancisco.firstspringproject.entities.enums.OrderStatus;
import com.acsanfrancisco.firstspringproject.repositories.CategoryRepository;
import com.acsanfrancisco.firstspringproject.repositories.OrderItemRepository;
import com.acsanfrancisco.firstspringproject.repositories.OrderRepository;
import com.acsanfrancisco.firstspringproject.repositories.ProductRepository;
import com.acsanfrancisco.firstspringproject.repositories.UserRepository;

@Configuration // indica que é uma classe de configuração
@Profile("test") // indica que esta configuração é para o perfil de testes, e só vai rodar quando
					// o perfil de testes estiver ativado
public class TestConfig implements CommandLineRunner {
	// interface do SpringBoot para executar um código assim que o programa inicia

	@Autowired // Spring cria uma instância do UserRepository (faz o controle da injeção de
				// dependência), também pode ser feito por meio de construtor
	/*
	 * public TestConfig(UserRepository userRepository){ this.userRepository =
	 * userRepository; }
	 */
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	// Preenchimento do banco de dados H2
	// oque estiver dentro desse método será executado
	public void run(String... args) throws Exception {
		
		// Preenchimento da tb_user 
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "998934323", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		User u3 = new User(null, "João Francisco", "joaosanneto225@gmail.com", "998934323", "12345");
		
		// Preechimento da tb_order
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.CANCELED, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u3);
		
		// Preenchimento da tb_category
		Category c1 = new Category(null, "Electronics");
		Category c2 = new Category(null, "Books");
		Category c3 = new Category(null, "Computers");
		
		// Preenchimento da tb_product
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		// Associando um produto a(s) sua(s) categoria(s)
		p1.getCategory().add(c2);
		p2.getCategory().add(c1);
		p2.getCategory().add(c3);
		p3.getCategory().add(c3);
		p4.getCategory().add(c3);
		p5.getCategory().add(c2);
		
		// Preenchimento da tb_order_item
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice()); 
		
		// Adicionando um pagamento a um pedido
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:00:07Z"), o1);
		o1.setPayment(pay1); 

		// Salvando no banco de dados
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
	}
}
