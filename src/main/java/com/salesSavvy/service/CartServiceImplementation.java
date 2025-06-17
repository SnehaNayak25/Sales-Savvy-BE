package com.salesSavvy.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesSavvy.entity.Cart;
import com.salesSavvy.entity.CartData;
import com.salesSavvy.entity.Product;
import com.salesSavvy.entity.Users;
import com.salesSavvy.repository.CartRepository;

@Service
public class CartServiceImplementation implements CartService {

    @Autowired
    private CartRepository cartRepo;

    @Autowired
    private UsersService userService;

    @Autowired
    private ProductService productService;

    @Override
    public String addToCart(CartData data) {
        Users user = userService.getUser(data.getUsername());
        Product product = productService.searchProduct(data.getProductId());

        if (user == null || product == null) {
            return "User or Product not found";
        }

        Cart cart = cartRepo.findByUser(user);

        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
            cart.setProductList(new ArrayList<>());
        }

        cart.getProductList().add(product);
        cartRepo.save(cart);

        return "Product added to cart successfully";
    }
}
