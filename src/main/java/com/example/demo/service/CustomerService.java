package com.example.demo.service;

import com.example.demo.dto.CustomerDTO;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

public interface CustomerService {
    ResponseEntity<?> getAll();
    ResponseEntity<?> getCustomer(Long id);
    ResponseEntity<?> delete(Long customerId);
    ResponseEntity<?> save(CustomerDTO customerDTO);

}
