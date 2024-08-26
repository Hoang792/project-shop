package com.example.quanlydt.service.impl;

import com.example.quanlydt.entity.Phone;
import com.example.quanlydt.repository.PhoneRepository;
import com.example.quanlydt.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public List<Phone> getAllPhones() {
        return (List<Phone>) phoneRepository.findAll();
    }

    @Override
    public void savePhone(Phone phone) {
        phoneRepository.save(phone);
    }

    @Override
    public void deletePhone(Long id) {
        phoneRepository.deleteById(id);
    }

    @Override
    public Optional<Phone> findPhoneById(Long id) {
        return phoneRepository.findById(id);
    }

    @Override
    public List<Phone> searchPhones(String query) {
        return phoneRepository.findByNameContainingIgnoreCaseOrBrandContainingIgnoreCase(query, query);
    }


}
