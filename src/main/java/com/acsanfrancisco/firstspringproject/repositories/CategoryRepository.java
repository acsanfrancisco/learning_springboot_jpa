package com.acsanfrancisco.firstspringproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acsanfrancisco.firstspringproject.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
