package com.example.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.application.model.Orders;

@Repository
public interface OrdersRepo extends JpaRepository<Orders,Integer>{

	List<Orders> findByUsername(String name);
	List<Orders> findByOrderstatus(String status);
}
