package com.shoes.bladex.repository;

import com.shoes.bladex.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,String> {
    Customer findTopByOrderByCodeDesc();

    List<Customer> findByNameStartingWith(String name);
}
