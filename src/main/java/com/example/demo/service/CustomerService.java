package com.example.demo.service;

import com.example.demo.dto.CustomerDTO;

import java.util.ArrayList;

public interface CustomerService {
    ArrayList<CustomerDTO> getAll();

    CustomerDTO getCustomer(Long id);

    boolean delete(Long customerId);

    boolean save(CustomerDTO customerDTO);

}
