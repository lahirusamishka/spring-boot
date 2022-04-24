package com.example.demo.controller;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public String get(){
        return "hello";
    }

    @GetMapping(value = "/all")
    public ArrayList<CustomerDTO> getAllCustomers(){
        return customerService.getAll();
    }

    @GetMapping(value = "/{id}")
    public CustomerDTO getCustomerById(@PathVariable("id") Long customerId){
        return customerService.getCustomer(customerId);
    }

    @DeleteMapping(value = "/{id}")
    public boolean deleteCustomer(@PathVariable("id") Long customerId){
        return customerService.delete(customerId);
    }

    @PostMapping("/save")
    public boolean saveCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.save(customerDTO);
    }
}
