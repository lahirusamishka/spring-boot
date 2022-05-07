package com.example.demo.controller;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllCustomers(){
        return customerService.getAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable("id") Long customerId){
        return customerService.getCustomer(customerId);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long customerId){
        return customerService.delete(customerId);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.save(customerDTO);
    }
}
