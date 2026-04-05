package com.acsanfrancisco.firstspringproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acsanfrancisco.firstspringproject.entities.User;
import com.acsanfrancisco.firstspringproject.repositories.UserRepository;

@Service // indica que a classe pertence a camada de serviços
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.get();
	}
	
	public User insert(User user) {
		return userRepository.save(user);
	}

}
