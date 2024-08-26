package com.example.quanlydt.service;

import com.example.quanlydt.model.Cart;
import com.example.quanlydt.entity.Phone;
public interface CartService {
    void addToCart(Phone phone);
    Cart getCart();
}
