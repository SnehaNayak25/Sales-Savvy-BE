package com.salesSavvy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesSavvy.entity.Cart;
import com.salesSavvy.entity.Users;

public interface CartRepository extends JpaRepository<Cart, Integer>{

	Cart findByUser(Users user);

}
