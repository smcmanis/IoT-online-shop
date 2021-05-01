package com.iotbay.shop.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartItem implements Serializable {

    private Integer cartId;
    private Item item;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal subtotal;

    public CartItem(Integer cartId, Item item, Integer quantity, BigDecimal price, BigDecimal subtotal) {
        this.cartId = cartId;
        this.item = item;
        this.quantity = quantity;
        this.price = price;
        this.subtotal = subtotal;
    }


    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
    
    

}
