package com.example.quanlydt.controllor;

import com.example.quanlydt.entity.Phone;
import com.example.quanlydt.service.CartService;
import com.example.quanlydt.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private PhoneService phoneService;

    @GetMapping("/cart/add")
    public String addToCart(@RequestParam Long id) {
        Phone phone = phoneService.findPhoneById(id).orElse(null);
        if (phone != null) {
            cartService.addToCart(phone);
        }
        return "redirect:/shopview"; // Trở về trang shop
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.getCart().getItems().values());
        return "cart"; // Trả về trang giỏ hàng
    }
}
