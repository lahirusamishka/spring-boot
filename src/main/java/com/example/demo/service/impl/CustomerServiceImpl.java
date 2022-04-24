package com.example.demo.service.impl;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public ArrayList<CustomerDTO> getAll() {

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
        return customerDTOS;
    }

    @Override
    public CustomerDTO getCustomer(Long id) {
        Customer customer =  customerRepository.findById(id).get();

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId(customer.getId());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setName(customer.getName());
        customerDTO.setContact(customer.getContact());

        return customerDTO;
    }

    @Override
    public boolean delete(Long customerId) {
        customerRepository.deleteById(customerId);
        return true;
    }

    @Override
    public boolean save(CustomerDTO customerDTO) {
        Customer customer = new Customer();

        customer.setId(customerDTO.getId());
        customer.setAddress(customerDTO.getAddress());
        customer.setName(customerDTO.getName());
        customer.setContact(customerDTO.getContact());

        customerRepository.save(customer);

        return true;

    }
}
