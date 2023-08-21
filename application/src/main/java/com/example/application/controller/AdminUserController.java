package com.example.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.model.Orders;
import com.example.application.model.User;
import com.example.application.service.AdminUserService;
import com.example.application.service.OrdersService;


@RestController
public class AdminUserController {

	
	@Autowired
	AdminUserService aus;
	
	@Autowired
	OrdersService os;
	
	@PostMapping("/adminuser/add")
	public ResponseEntity<Boolean>addUser(@RequestBody User u)
	{
		return new ResponseEntity<>(aus.addUser(u),HttpStatus.OK);
		
	}
	@DeleteMapping("/adminuser/delete/{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable("id") int id)
	{
		return new ResponseEntity<>(aus.deleteUser(id),HttpStatus.OK);
	}
	@GetMapping("/adminuser/viewall")
	public List<User> getAllUsers()
	{
		return aus.getAllUsers();
	}
	@PutMapping("/adminuser/block/{username}")
	public ResponseEntity<User> blockUser(@PathVariable("username") String username)
	{
		return new ResponseEntity<>(aus.blockUser(username),HttpStatus.OK);
	}
	@PutMapping("/adminuser/unblock/{id}")
	public ResponseEntity<User> unBlockUser(@PathVariable ("id") int id)
	{
		return new ResponseEntity<>(aus.unBlockUser(id),HttpStatus.OK);
	}
	@DeleteMapping("/orders/delete")
	public ResponseEntity<Boolean> deleteOrders()
	{
		return new ResponseEntity<> (os.deleteOrders(),HttpStatus.OK);
	}
	
	@GetMapping("/admin/order/getbyuname/{username}")
	public List<Orders> viewOrdersByUserName(@PathVariable String username)
	{
		return os.viewOrdersByUserName(username);
	}
}
