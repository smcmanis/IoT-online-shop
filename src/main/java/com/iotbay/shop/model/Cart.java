package com.iotbay.shop.model;

import java.io.Serializable;
import java.util.List;

public class Cart implements Serializable {

    private Integer cartId;
    
    private Integer userId;
    
    private List<CartItem> cartItems;


      public Cart(Integer cartId, Integer userId, List cartItems) {
        this.cartId = cartId;
        this.userId = userId;
        this.cartItems = cartItems;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    


}
