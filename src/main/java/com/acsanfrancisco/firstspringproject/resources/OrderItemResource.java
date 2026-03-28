package com.acsanfrancisco.firstspringproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acsanfrancisco.firstspringproject.entities.OrderItem;
import com.acsanfrancisco.firstspringproject.entities.pk.OrderItemPk;
import com.acsanfrancisco.firstspringproject.services.OrderItemService;

@RestController
@RequestMapping(value= "/order_item")
public class OrderItemResource {

	@Autowired
	private OrderItemService orderItemService;
	
	@GetMapping
	public ResponseEntity<List<OrderItem>> findAll(){
		List<OrderItem> findAll = orderItemService.findAll();
		return ResponseEntity.ok().body(findAll);
	}
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<OrderItem> findById(@PathVariable OrderItemPk id){
		OrderItem findById = orderItemService.findById(id);
		return ResponseEntity.ok().body(findById);
	}
}
