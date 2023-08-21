package com.example.application.service;

import java.util.List;

import com.example.application.model.User;

public interface AdminUserService {
	public boolean addUser(User u);
	public boolean deleteUser(int id);
	public List<User> getAllUsers();
	public User blockUser(String username);
	public User unBlockUser(int id);
	
}
