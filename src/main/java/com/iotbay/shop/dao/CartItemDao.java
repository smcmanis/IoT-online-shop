package com.iotbay.shop.dao;

import com.iotbay.shop.model.Cart;
import com.iotbay.shop.model.CartItem;
import com.iotbay.shop.service.EntityManagerFactoryService;

import java.util.List;
import javax.persistence.EntityManager;

public class CartItemDao {

    private EntityManager getEntityManager() {
        return EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
    }

    public CartItem getCartItemByCartItemId(Integer cartItemId) {
        EntityManager em = getEntityManager();
        CartItem cartItem = null;
        try {
            cartItem = em.find(CartItem.class, cartItemId);
        } finally {
            em.close();
        }
        return cartItem;
    }

    public void addCartItem(CartItem cartItem) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            if (cartItem.getId() != null && em.find(CartItem.class, cartItem.getId()) != null) {
                em.merge(cartItem);
            } else if (cartItem.getCart() != null) {
                em.persist(cartItem);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void updateCartItem(CartItem cartItem) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(cartItem);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void removeCartItemById(Integer cartItemId) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            CartItem cartItem = em.find(CartItem.class, cartItemId);
            em.remove(cartItem);
            em.flush();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void removeAllCartItemsFromCart(Cart cart) {
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem cartItem : cartItems) {
            removeCartItemById(cartItem.getId());
        }
    }

}
