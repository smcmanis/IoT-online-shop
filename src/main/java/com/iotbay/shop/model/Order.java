package com.iotbay.shop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;



public class Order implements Serializable {
    
    private Integer id; 
    
    private Date orderDate;
    
    private String orderStatus;    
    
    private BigDecimal totalPrice;
    
    private Cart cart;
    
    private User user;
    
    private Shipment shipping;

    public Order(Integer id, Date orderDate, String orderStatus, BigDecimal totalPrice, Cart cart, User user) {
        this.id = id;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
        this.cart = cart;
        this.user = user;
    }
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Shipment getShipping() {
        return shipping;
    }

    public void setShipping(Shipment shipping) {
        this.shipping = shipping;
    }


    
}
