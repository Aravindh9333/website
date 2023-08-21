package com.example.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.application.model.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

	List<Product> findByQuantity(int qty);
	Product findByName(String name);
}
