package com.example.application.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.model.Cart;
import com.example.application.model.Orders;
import com.example.application.model.Product;
import com.example.application.model.User;
import com.example.application.repository.CartRepository;
import com.example.application.repository.OrdersRepo;
import com.example.application.repository.ProductRepo;
import com.example.application.repository.UserRepo;
@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	CartRepository cr;
	
	@Autowired
	OrdersRepo or;
	
	@Autowired
	UserRepo ur;
	
	@Autowired
	ProductRepo pr;
	
	@Override
	public boolean addToCart(Cart c) {
		try {
			User u=ur.findByUsername(c.getUname());
			if(u!=null)
			{
				Product p=pr.findByName(c.getPname());
				if(p!=null)
				{
					Cart c1=cr.findByUnameAndPname(c.getUname(), c.getPname());
					if(c1==null)
					{
						c.setPrice(p.getPrice()*c.getQty());
					cr.save(c);
					}
					else {
						c1.setQty(c1.getQty()+c.getQty());
						c1.setPrice(c1.getQty()*p.getPrice());
						cr.save(c1);
					}
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	
	@Override
	public boolean submitOrder(Orders o) {
		boolean b=false;
		try
		{
			o.setTotalprice(o.getPprice()*o.getQuantity());
			o.setOrdertime(java.sql.Date.valueOf(LocalDate.now()));
			or.save(o);
			Cart c=cr.findByUnameAndPname(o.getUsername(), o.getProductname());
			cr.deleteById(c.getId());
			b=true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}return b;
		
	}

	@Override
	public List<Orders> viewOrdersByUserName(String username) {
		return or.findByUsername(username);
	}

	@Override
	public boolean deleteOrders() {
		boolean b=false;
		try
		{
		List<Orders> l=or.findByOrderstatus("delivered");
		for(int i=0;i<l.size();i++)
		{
			or.deleteById(l.get(i).getId());
		}
		b=true;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}return b;
		
	}

	
}
