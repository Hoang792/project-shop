package com.example.quanlydt.service;

import com.example.quanlydt.entity.Phone;

import java.util.List;
import java.util.Optional;

public interface PhoneService {
    List<Phone> getAllPhones();
    void savePhone(Phone phone);
    void deletePhone(Long id);
    Optional<Phone> findPhoneById(Long id);
    List<Phone> searchPhones(String query);


}
