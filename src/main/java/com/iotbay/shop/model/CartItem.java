package com.iotbay.shop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;

@Entity
@Table(name = "cart_items")
public class CartItem implements Serializable {
    
    @Embeddable
    public static class Id implements Serializable {
        protected Integer cartId;
        protected Integer itemId;
        
        public Id() {}
        
        public Id(Integer cartId, Integer itemId) {
            this.cartId = cartId;
            this.itemId = itemId;
        }
        
        public boolean equals(Object o) {
            if (o != null && o instanceof Id) {
                Id that = (Id) o;
                return this.cartId.equals(that.cartId) && this.itemId.equals(that.itemId);
            }
            return false;
        }
        
        public int hashcode() {
            return cartId.hashCode() + itemId.hashCode();
        }
    }
    
    @EmbeddedId()
    private Id id;
    
    @ManyToOne
    @JoinColumn(name = "itemId", insertable = false, updatable = false)
    private Item item;
    
    private Integer quantity;
    
    @Column(name = "itemprice")
    private BigDecimal price;
    
    @ManyToOne
    @JoinColumn(name = "cartId", insertable = false, updatable = false)
    private Cart cart;
    
    public Id getId() {
        return this.id;
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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
       
}
