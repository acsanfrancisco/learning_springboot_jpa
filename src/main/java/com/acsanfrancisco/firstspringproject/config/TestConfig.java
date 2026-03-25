package com.acsanfrancisco.firstspringproject.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.acsanfrancisco.firstspringproject.entities.User;
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

	@Override 
	public void run(String... args) throws Exception { 
		//oque estiver dentro desse método será executado 
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "998934323", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1,u2));
	}                            
}
