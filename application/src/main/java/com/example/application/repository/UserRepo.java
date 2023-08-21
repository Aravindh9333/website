package com.example.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.application.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{

	User findByUsername(String Username);
	
}
