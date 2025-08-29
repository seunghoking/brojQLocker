package com.broj.brojqlocker.controller;

import com.broj.brojqlocker.dto.CustomerInfo;
import com.broj.brojqlocker.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    
    private final CustomerService customerService;
    
    @GetMapping
    public List<CustomerInfo> getAllCustomers() {
        return customerService.getAllCustomers();
    }
    
    @GetMapping("/search")
    public List<CustomerInfo> searchByPhoneNumber(@RequestParam String phoneNumber) {
        return customerService.searchByPhoneNumber(phoneNumber);
    }
}