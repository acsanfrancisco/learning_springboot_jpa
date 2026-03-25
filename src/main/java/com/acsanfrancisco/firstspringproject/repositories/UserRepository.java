package com.acsanfrancisco.firstspringproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acsanfrancisco.firstspringproject.entities.User;

// Camada responsável por acessar o banco de dados
// Possui os métodos de consulta para o banco de dados (findAll, findById, save, deleteById etc.)
// <Entidade, Tipo do Id da Entidade>
// O SpringData JPA já faz a implementação dos métodos
public interface UserRepository extends JpaRepository<User, Long>{
}
