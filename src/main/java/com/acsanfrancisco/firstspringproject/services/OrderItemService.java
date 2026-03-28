package com.acsanfrancisco.firstspringproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acsanfrancisco.firstspringproject.entities.OrderItem;
import com.acsanfrancisco.firstspringproject.entities.pk.OrderItemPk;
import com.acsanfrancisco.firstspringproject.repositories.OrderItemRepository;

@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public List<OrderItem> findAll(){
		List<OrderItem> findAll = orderItemRepository.findAll();
		return findAll;
	}
	
	public OrderItem findById(OrderItemPk id) {
		Optional<OrderItem> optinal = orderItemRepository.findById(id);
		return optinal.get();
	}
}
