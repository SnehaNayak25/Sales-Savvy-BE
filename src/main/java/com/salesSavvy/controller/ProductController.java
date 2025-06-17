package com.salesSavvy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.salesSavvy.entity.CartData;
import com.salesSavvy.entity.Product;
import com.salesSavvy.entity.Users;
import com.salesSavvy.service.CartService;
import com.salesSavvy.service.ProductService;
import com.salesSavvy.service.UsersService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@CrossOrigin("*")
@RestController
public class ProductController {
	@Autowired
	ProductService service;
	@Autowired
	UsersService uService;
	@Autowired
	CartService cartService;
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Product product) {
		return service.addProduct(product);
		
	}
	
	@GetMapping("/searchProduct")
	public Product searchProduct(@RequestParam Long id) {
		return service.searchProduct(id);
	}
	
	@PostMapping("/updateProduct")
	public String updateProduct(@RequestBody Product product) {
		//TODO: process POST request
		return service.updateProduct(product);	
	}
	
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam Long id) {
		return service.deleteProduct(id);
	}
	
	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts() {
		//TODO: process POST request
		return service.getAllProducts();
	}
	
	@PostMapping("/addToCart")
	public String addToCart(@RequestBody CartData data) {
	    return cartService.addToCart(data);
	}
	
	
	
	
}
