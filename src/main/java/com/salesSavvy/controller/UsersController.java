package com.salesSavvy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.salesSavvy.entity.UserLoginData;
import com.salesSavvy.entity.Users;
import com.salesSavvy.service.UsersService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin("*")
@RestController
public class UsersController {
	@Autowired
	UsersService service;
	
	@PostMapping("/signUp")
	public String signUp(@RequestBody Users user) {
		//TODO: process POST request
		String msg = "";
		String username = user.getUsername();
		Users u = service.getUser(username);
		if(u == null)
		{
			service.signUp(user);
			msg = "User created successfully";
		}
		else
		{
			msg = "Username already exists!";
		}
		return msg;
	}
	
	@PostMapping("/signIn")
	public String signIn(@RequestBody UserLoginData user) {
		//TODO: process POST request
		String msg = "";
		String username = user.getUsername();
		String password = user.getPassword();
		
		Users u = service.getUser(username);
		if(u==null)
		{
			msg = "User does not exist";
		}
		else
		{
			boolean status = service.validate(password,u.getPassword());
			if(status==true)
			{
				msg = u.getRole();
			}
			else
			{
				msg ="Wrong Credentials!..";
			}
		}
		return msg;
	}
	
	
	
	
}
