package com.example.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.application.model.User;
import com.example.application.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo ur;

	@Override
	public boolean addUser(User u) {
		boolean b=false;
		try {
			ur.save(u);
			b=true;
		}catch(Exception e){
			System.out.println(e);	
		}
		return b;
	}

	@Override
	public boolean deleteUser(int id) {
		boolean b=false;
		try
		{
			User u=ur.findById(id).get();
			ur.delete(u);
			b=true;
		}catch (Exception e)
		{
		System.out.println(e);
		}
		return b;
	}

	@Override
	public boolean updateUser(User u) {
		boolean b=false;
		try
		{
			User us=ur.findById(u.getId()).get();
			if(u.getPassword()!=null)
				us.setPassword(u.getPassword());
			if(u.getAddress()!=null)
				us.setAddress(u.getAddress());
			if(u.getMobile()!=0)
				us.setMobile(u.getMobile());
			if(u.getStatus()!=null)
				us.setStatus(u.getStatus());
			ur.save(us);
			b=true;
				
		}
		catch (Exception e)
	
		{
			System.out.println(e);
		}
		return b;
	}

}
