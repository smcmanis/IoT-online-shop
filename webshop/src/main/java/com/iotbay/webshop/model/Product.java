package com.iotbay.webshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {
    
    @Id 
    @GeneratedValue 
    private Long productId;

    private String productName;

    private double productPrice;

    private int stockLevel;

    public Product() {}

    public Product(String productName, double productPrice, int stockLevel) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.stockLevel = stockLevel;
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }
}
