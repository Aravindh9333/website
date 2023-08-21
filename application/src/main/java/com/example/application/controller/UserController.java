package com.example.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.model.Cart;
import com.example.application.model.Orders;
import com.example.application.model.User;
import com.example.application.service.OrdersService;
import com.example.application.service.UserService;

@RestController
public class UserController {

	@Autowired
	OrdersService os;
	
	@Autowired
	UserService uss;
	
	@PostMapping("/user/add")
	public ResponseEntity<Boolean> addUser(@RequestBody User user)
	{
		return new ResponseEntity<>(uss.addUser(user),HttpStatus.OK);
	}
	@DeleteMapping("/user/delete/{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable int id)
	{
		return new ResponseEntity<>(uss.deleteUser(id),HttpStatus.OK);
	}
	
	@PostMapping("/user/addtocart")
	public ResponseEntity<Boolean> addToCart(@RequestBody Cart c)
	{
		return new ResponseEntity<>(os.addToCart(c),HttpStatus.OK);
	}
	
	@PostMapping("/orders/submit")
	public ResponseEntity<Boolean> submitOrders(@RequestBody Orders o) {
		return new ResponseEntity<>(os.submitOrder(o),HttpStatus.OK);
	}
	
	@GetMapping("/order/getbyuname/{username}")
	public List<Orders> viewOrdersByUserName(@PathVariable String username)
	{
		return os.viewOrdersByUserName(username);
	}
}
