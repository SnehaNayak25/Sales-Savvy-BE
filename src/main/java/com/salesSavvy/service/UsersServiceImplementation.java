package com.salesSavvy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesSavvy.entity.Users;
import com.salesSavvy.repository.UsersRepository;

@Service
public class UsersServiceImplementation implements UsersService{
	@Autowired
	UsersRepository repo;

	@Override
	public void signUp(Users user) {
		repo.save(user);
		
	}

	@Override
	public Users getUser(String username) {
		return repo.findByUsername(username);
	}

	@Override
	public boolean validate(String loginpassword, String dbpassword) {
		return (loginpassword.equals(dbpassword));
	}

	
}
