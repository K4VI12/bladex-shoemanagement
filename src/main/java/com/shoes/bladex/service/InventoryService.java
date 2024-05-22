package com.shoes.bladex.service;

import com.shoes.bladex.dto.InventoryDTO;
import com.shoes.bladex.dto.SupplierDTO;

import java.util.List;

public interface InventoryService {
    InventoryDTO saveItem(InventoryDTO inventoryDTO);
    InventoryDTO updateItem(InventoryDTO inventoryDTO);
    boolean deleteItem(String id);
    List<InventoryDTO> getAllItem();
    List<InventoryDTO> searchItemByName(String name);
    InventoryDTO searchItemById(String id);
    String generateNextId();
    List<SupplierDTO> loadSupplierCode();
}
