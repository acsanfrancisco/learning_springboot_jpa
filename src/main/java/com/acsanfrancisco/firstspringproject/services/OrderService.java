package com.acsanfrancisco.firstspringproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acsanfrancisco.firstspringproject.entities.Order;
import com.acsanfrancisco.firstspringproject.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findAll(){
		return orderRepository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> order = orderRepository.findById(id);
		return order.get();
	}
}
