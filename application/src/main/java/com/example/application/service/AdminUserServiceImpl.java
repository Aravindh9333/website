package com.example.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.model.User;
import com.example.application.repository.UserRepo;

@Service
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired
	UserRepo ur;
	@Override
	public boolean addUser(User u) {
		try {
		ur.save(u);
		return true;
		}
		catch(Exception e) 
		
		{
			return false;
		}
	}

	@Override
	public boolean deleteUser(int id) {
		try
		{
			System.out.println(ur.findById(id).get().getId());
			ur.deleteById(id);
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<User> getAllUsers() {
		return ur.findAll();
	}

	@Override
	public User blockUser(String username) {
		User u=ur.findByUsername(username);
		u.setStatus("blocked");
		return ur.save(u);
	}

	@Override
	public User unBlockUser(int id) {
		User u=ur.findById(id).get();
		u.setStatus("unblocked");
		return ur.save(u);
	}

}
