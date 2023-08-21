package com.example.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.model.Product;
import com.example.application.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService pser;
	
	
	@PostMapping("/product/add")
	public String addProduct(@RequestBody Product p)
	{
		boolean b=pser.addProduct(p);
		if(b)
			return "success";
		else
			return "fail";
	}
	@GetMapping("/product/viewall")
	public List<Product> viewProducts()
	{
		return pser.viewProducts();
	}
	@DeleteMapping("/product/delete/{id}")
	public String deleteProduct(@PathVariable int id)
	{
		boolean b=pser.deleteProductById(id);
		if(b)
			return "success";
		else
			return "fail";
	}
	@DeleteMapping("/product/qty/{count}")
	public boolean viewProductsByName(@PathVariable("count") int qty)
	{
		return pser.deleteProductByName(qty);
		
	}
	
}
