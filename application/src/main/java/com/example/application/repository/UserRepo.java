package com.example.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.application.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{

	User findByUsername(String Username);
	
	@Query(value="select * from User where username=?1 and password=?2",nativeQuery = true)
	User findUserByUnameAndPassword(String username, String password);
}
