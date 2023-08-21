package com.example.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.application.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer> {
	
	@Query(value="select * from cart where uname=?1 and pname=?2",nativeQuery = true)
	Cart findByUnameAndPname(String uname,String pname);

}
