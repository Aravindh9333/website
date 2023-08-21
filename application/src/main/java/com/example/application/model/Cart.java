package com.example.application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cart {

	@Id
	int id;
	private String uname;
	String pname;
	int qty;
	double price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String name) {
		this.pname = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	} 
	
	
}
