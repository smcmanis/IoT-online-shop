package com.iotbay.shop.dao;

import com.iotbay.shop.model.Cart;
import com.iotbay.shop.model.CartItem;
import com.iotbay.shop.service.EntityManagerFactoryService;
import java.math.BigDecimal;

import java.util.List;
import javax.persistence.EntityManager;

public class CartItemDao {

    private EntityManager getEntityManager() {
        return EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
    }

    public CartItem getCartItemByCartItemId(Integer cartItemId) {
        EntityManager em = getEntityManager();
        CartItem cartItem = em.find(CartItem.class, cartItemId);
        em.close();
        return cartItem;
    }

    public void addCartItem(CartItem cartItem) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        if (cartItem.getId() != null && em.find(CartItem.class, cartItem.getId()) != null) {
            em.merge(cartItem);
        } else {
            if (cartItem.getCart() == null) {
                System.out.println("null cart");
            } else {
                System.out.println("not null cart");
                System.out.println(cartItem.getCart().getId());
            }
            em.persist(cartItem);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void updateCartItem(CartItem cartItem) {
        BigDecimal subtotal = calculateSubtotal(cartItem);
        cartItem.setPrice(subtotal);
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(cartItem);
        em.getTransaction().commit();
        em.close();
    }

    public void removeCartItem(CartItem cartItem) {
        EntityManager em = getEntityManager();
        try {
            // Start transaction with database
            em.getTransaction().begin();
            
            // Get the real copy of the cartItem from the database (The existing one is just copy)
            cartItem = em.find(CartItem.class, cartItem.getId());
            
            // This will ASK the entitymanager to remove the cartItem from the database
            // However, it will only really remove it from database after we "commit" the 
            // transaction, using: em.getTransaction().commit()
            em.remove(cartItem);
            
            // We must also remove the cartItem from the cart. This is because the cart owns 
            // the cartItem (ONE cart has MANY cartItems). The cart still has a reference to 
            // the cartItem, so, the cart will just recreate the cartItem in the database 
            // unless we remove manually remove the cartItem from the cart as well.
            Cart cart = em.find(Cart.class, cartItem.getCart().getId());
            List<CartItem> cartItems = cart.getCartItems();
            cartItems.remove(cartItem);
            
            // Commit ends the transaction and "commits" it to the database
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void removeAllCartItemsFromCart(Cart cart) {
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem cartItem : cartItems) {
            removeCartItem(cartItem);
        }
    }

    public BigDecimal calculateSubtotal(CartItem cartItem) {
        BigDecimal subtotal = cartItem.getPrice().multiply(new BigDecimal(cartItem.getQuantity()));
        return subtotal;
    }

}
