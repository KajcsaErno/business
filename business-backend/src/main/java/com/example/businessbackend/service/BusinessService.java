package com.example.businessbackend.service;

import com.example.businessbackend.model.Business;
import com.example.businessbackend.model.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessService {

    @Autowired
    private BusinessRepository businessRepository;

    public Business getBusinessById(Long id) {
        var business = businessRepository.findById(id);
        return business.orElse(null);
    }

    public List<Business> getAllBusinesses() {
        return (List<Business>) businessRepository.findAll();
    }

}
