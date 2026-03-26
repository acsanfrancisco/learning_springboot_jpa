package com.acsanfrancisco.firstspringproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acsanfrancisco.firstspringproject.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
