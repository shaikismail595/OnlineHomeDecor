package com.yash.onlineHomeDecor.dao;

import com.yash.onlineHomeDecor.domain.Inventory;
import com.yash.onlineHomeDecor.exception.InventoryNotFoundException;

import java.util.List;

public interface InventoryDao {
    //void addInventory(Inventory inventory);
    Inventory getInventoryById(int inventoryId) throws InventoryNotFoundException;
    List<Inventory> getAllInventories();
    void updateInventory(Inventory inventory) throws InventoryNotFoundException;
    void deleteInventory(int inventoryId) throws InventoryNotFoundException;
}