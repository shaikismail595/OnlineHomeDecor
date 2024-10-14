package com.yash.onlineHomeDecor.domain;

import java.util.Date;

public class Inventory {
    private int inventoryId; // Primary Key
    private int productId;    // Foreign Key
    private int quantity;
    private Date lastUpdateDate;

    // Constructors
    public Inventory() {}

    public Inventory(int inventoryId, int productId, int quantity, Date lastUpdateDate) {
        this.inventoryId = inventoryId;
        this.productId = productId;
        this.quantity = quantity;
        this.lastUpdateDate = lastUpdateDate;
    }

    // Getters and Setters
    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryId=" + inventoryId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", lastUpdateDate=" + lastUpdateDate +
                '}';
    }
}