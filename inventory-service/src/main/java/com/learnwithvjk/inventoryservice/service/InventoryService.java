package com.learnwithvjk.inventoryservice.service;

import org.springframework.stereotype.Service;

import com.learnwithvjk.inventoryservice.dto.InventoryRequest;
import com.learnwithvjk.inventoryservice.model.Inventory;
import com.learnwithvjk.inventoryservice.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public void createInventory(InventoryRequest inventoryRequest) {
        Inventory inventory = Inventory.builder()
                .skuCode(inventoryRequest.getSkuCode())
                .quantity(inventoryRequest.getQuantity())
                .build();
        inventoryRepository.save(inventory);
    }

}
