package com.example.businessbackend.controllers;

import com.example.businessbackend.dto.BusinessDTO;
import com.example.businessbackend.dto.adapter.BusinessAdapter;
import com.example.businessbackend.model.Business;
import com.example.businessbackend.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BusinessController {

    private final BusinessService businessService;

    @Autowired
    private BusinessAdapter businessAdapter;

    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @GetMapping("/business/{id}")
    public BusinessDTO getBusiness(@PathVariable("id") Long id) {
        return businessAdapter.toDTO(businessService.getBusinessById(id));
    }

    @GetMapping("/allBusinesses")
    public List<Business> getAllBusiness() {
        return businessService.getAllBusinesses();
    }

}
