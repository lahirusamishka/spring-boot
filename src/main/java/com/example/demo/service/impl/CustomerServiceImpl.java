package com.example.demo.service.impl;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public ResponseEntity<?> getAll() {

        ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();

        List<Customer> customerList = customerRepository.findAll();
        for (Customer customer: customerList) {
            CustomerDTO customerDTO = new CustomerDTO();

            customerDTO.setId(customer.getId());
            customerDTO.setAddress(customer.getAddress());
            customerDTO.setName(customer.getName());
            customerDTO.setContact(customer.getContact());

            customerDTOS.add(customerDTO);
        }
        return new ResponseEntity<>(customerDTOS, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getCustomer(Long id) {
        Customer customer =  customerRepository.findById(id).get();

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId(customer.getId());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setName(customer.getName());
        customerDTO.setContact(customer.getContact());

        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(Long customerId) {
        customerRepository.deleteById(customerId);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> save(CustomerDTO customerDTO) {
        Customer customer = new Customer();

        customer.setId(customerDTO.getId());
        customer.setAddress(customerDTO.getAddress());
        customer.setName(customerDTO.getName());
        customer.setContact(customerDTO.getContact());

        customerRepository.save(customer);

        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
