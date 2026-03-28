package com.acsanfrancisco.firstspringproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acsanfrancisco.firstspringproject.entities.OrderItem;
import com.acsanfrancisco.firstspringproject.entities.pk.OrderItemPk;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk>{

}
