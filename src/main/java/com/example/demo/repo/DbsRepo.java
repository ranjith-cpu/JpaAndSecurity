package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.EntityDetails;

public interface DbsRepo extends JpaRepository<EntityDetails, Integer>{

	EntityDetails findByUserName(String username);

}
