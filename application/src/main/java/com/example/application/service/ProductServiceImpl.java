package com.example.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.model.Product;
import com.example.application.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepo prepo;
	
	@Override
	public boolean addProduct(Product p) {
		boolean b=false;
		try {
			prepo.save(p);
			b=true;
		}catch(Exception e) {
			System.out.println(e);
		}
		return b;
	}

	@Override
	public boolean deleteProductById(int id) {
		boolean b=false;
		try
		{
			prepo.deleteById(id);
			b=true;
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return b;
		
	}

	@Override
	public boolean updateProduct(Product p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> viewProducts() {
		return prepo.findAll();
	}

	@Override
	public Product viewProductsByName(String name) {
		return prepo.findByName(name);
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean deleteProductByName(int quantity) {
		boolean b=false;
		try
		{
			List<Product> l=prepo.findByQuantity(quantity);
			prepo.deleteInBatch(l);
			b=true;
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return b;
		
	}

	
}
