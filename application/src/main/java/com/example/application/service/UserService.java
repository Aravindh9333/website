package com.example.application.service;

import com.example.application.model.User;

public interface UserService {

	public boolean addUser(User u);
	public boolean deleteUser(int id);
	public boolean updateUser(User u);
	public boolean login(String username, String pasword);
}
