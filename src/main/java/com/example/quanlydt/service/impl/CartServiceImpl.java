package com.example.quanlydt.service.impl;

import com.example.quanlydt.entity.Phone;
import com.example.quanlydt.model.Cart;
import com.example.quanlydt.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    private Cart cart = new Cart();

    @Override
    public void addToCart(Phone phone) {
        cart.addItem(phone);
    }

    @Override
    public Cart getCart() {
        return cart;
    }
}
