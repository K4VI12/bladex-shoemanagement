package com.shoes.bladex.service;

import com.shoes.bladex.dto.CustomerDTO;

import java.util.List;



public interface CustomerService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(CustomerDTO customerDTO);
    boolean deleteCustomer(String id);
    List<CustomerDTO> getAllCustomers();
    List<CustomerDTO> searchCustomer(String name);

    String generateNextId();
}
