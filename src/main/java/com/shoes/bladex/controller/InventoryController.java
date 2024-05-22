package com.shoes.bladex.controller;


import com.shoes.bladex.dto.InventoryDTO;
import com.shoes.bladex.dto.SupplierDTO;
import com.shoes.bladex.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/inventory")
@CrossOrigin(origins = "*")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    public InventoryController() {
        System.out.println("Inventory working !");
    }

    @GetMapping("/getAll")
    public List<InventoryDTO> getAllItem(){
        return inventoryService.getAllItem();
    }

    @PostMapping("/save")
    public InventoryDTO save(@RequestBody InventoryDTO inventoryDTO){
        return inventoryService.saveItem(inventoryDTO);
    }

    @PatchMapping("/update")
    public InventoryDTO update(@RequestBody InventoryDTO inventoryDTO){
        return inventoryService.updateItem(inventoryDTO);
    }

    @DeleteMapping("/delete")
    public boolean delete(@RequestParam("code") String code){
        return inventoryService.deleteItem(code);
    }

    @GetMapping("/searchByName")
    public List<InventoryDTO> searchByName(@RequestParam("name")String name){
        return inventoryService.searchItemByName(name);
    }

    @GetMapping("/searchById")
    public InventoryDTO searchById(@RequestParam("code") String code){
        return inventoryService.searchItemById(code);
    }

    @GetMapping("/loadSuppliersCode")
    public List<SupplierDTO> loadSuppliersCode(){
        return inventoryService.loadSupplierCode();
    }
}
