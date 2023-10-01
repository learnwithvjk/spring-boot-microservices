package com.learnwithvjk.inventoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnwithvjk.inventoryservice.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

}