package com.shoes.bladex.service;

import com.shoes.bladex.dto.CustomerDTO;
import com.shoes.bladex.entity.Customer;
import com.shoes.bladex.repository.CustomerRepo;
import com.shoes.bladex.service.exception.DuplicateRecordException;
import com.shoes.bladex.service.exception.NotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getCode())){
            throw new DuplicateRecordException("Customer Id is already exists !!");
        }
        return mapper.map(customerRepo.save(mapper.map(customerDTO, Customer.class)),CustomerDTO.class);
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        if (!customerRepo.existsById(customerDTO.getCode())){
            throw new NotFoundException("Can't find customer id !!");
        }

        Customer customer = customerRepo.findById(customerDTO.getCode()).get();
        System.out.println("customer is "+customer);

        customerDTO.setLoyaltyLevel(customer.getLoyaltyLevel());
        customerDTO.setLoyaltyPoints(customer.getLoyaltyPoints());
        customerDTO.setRecentPurchaseDate(customer.getRecentPurchaseDate());

        return mapper.map(customerRepo.save(mapper.map(customerDTO, Customer.class)), CustomerDTO.class);
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public boolean deleteCustomer(String id) {
        if (!customerRepo.existsById(id)){
            throw new NotFoundException("Can't find customer id !!");
        }
        return false;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepo.findAll().stream().map(customer -> mapper.map(customer, CustomerDTO.class)).toList();
    }

    @Override
    public List<CustomerDTO> searchCustomer(String name) {
        return customerRepo.findByNameStartingWith(name).stream().map(customer -> mapper.map(customer, CustomerDTO.class)).toList();
    }

    @Override
    public String generateNextId() {
        String prefix = "C";
        String id = "";

        Customer lastCustomer = customerRepo.findTopByOrderByCodeDesc();
        int nextNumericPart;
        if (lastCustomer != null) {
            String lastCode = lastCustomer.getCode();
            String numericPartString = lastCode.substring(prefix.length());
            try {
                int numericPart = Integer.parseInt(numericPartString);
                nextNumericPart = numericPart + 1;
            } catch (NumberFormatException e) {
                nextNumericPart = 1;
            }
        } else {
            nextNumericPart = 1;
        }
        id = prefix + String.format("%03d", nextNumericPart);

        return id;
    }
}

