package com.example.application.service;



import java.util.List;

import com.example.application.model.Cart;
import com.example.application.model.Orders;

public interface OrdersService {

	
	public boolean addToCart(Cart c);
	
	public boolean submitOrder(Orders o);
	public List<Orders> viewOrdersByUserName(String username);
	public boolean deleteOrders();
	
}
