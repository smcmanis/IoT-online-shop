package com.iotbay.shop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "orders")
public class Order implements Serializable {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 
    
    @Column( name = "order_date")
    private Date orderDate;
    
    @Column( name = "order_status")
    private String orderStatus;    
    
    @Column( name = "total_price" )
    private BigDecimal totalPrice;
    
    @OneToOne
    @JoinColumn( name = "cart_id" )
    private Cart cart;
    
    @OneToOne
    @JoinColumn( name = "customer_id" )
    private Customer customer;
    
    @OneToOne( mappedBy = "order" )
    private Shipment shipping;
    
    
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

    
//    public Integer getCustomerId() {
//        return userId;
//    }
//
//    public void setCustomerId(Integer userId) {
//        this.userId = userId;
//    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
