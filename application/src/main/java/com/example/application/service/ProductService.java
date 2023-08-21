package com.example.application.service;

import java.util.List;

import com.example.application.model.Product;

public interface ProductService {

	public boolean addProduct(Product p);
	public boolean deleteProductById(int id);
	public boolean updateProduct(Product p);
	public List<Product> viewProducts();
	public Product viewProductsByName(String name);
	public boolean deleteProductByName(int quantity);
	
}
