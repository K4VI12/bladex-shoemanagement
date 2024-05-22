package com.shoes.bladex.repository;

import com.shoes.bladex.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepo extends JpaRepository<Supplier,String> {
    Supplier findTopByOrderByCodeDesc();
    List<Supplier> findByName(String name);

    Supplier findByCode(String id);
}
