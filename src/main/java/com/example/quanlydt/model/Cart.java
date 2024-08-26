package com.example.quanlydt.model;

import com.example.quanlydt.entity.Phone;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Long, Phone> items = new HashMap<>();

    public void addItem(Phone phone) {
        items.put(phone.getId(), phone);
    }

    public Map<Long, Phone> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }
}
