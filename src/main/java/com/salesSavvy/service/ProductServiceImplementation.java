package com.salesSavvy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesSavvy.entity.Product;
import com.salesSavvy.repository.ProductRepository;

@Service
public class ProductServiceImplementation implements ProductService{

	@Autowired
	ProductRepository repo;

	@Override
	public String addProduct(Product product) {
		// TODO Auto-generated method stub
		repo.save(product);
		return "Product added successfully";
	}

	@Override
	public Product searchProduct(long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
		
	}

	@Override
	public Product searchProduct(String name) {
		return repo.findByName(name);
	}

	@Override
	public String updateProduct(Product product) {
		// TODO Auto-generated method stub
		repo.save(product);
		return "Product updated successfully";
	}

	@Override
	public String deleteProduct(long id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		return "Product deleted successfully";
	}

	@Override
	public Product searchProductByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
}
