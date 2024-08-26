package com.example.quanlydt.repository;

import com.example.quanlydt.entity.Phone;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PhoneRepository extends CrudRepository<Phone, Long> {
    List<Phone> findByNameContainingIgnoreCaseOrBrandContainingIgnoreCase(String name, String brand);
}
