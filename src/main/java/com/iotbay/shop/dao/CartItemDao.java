package com.iotbay.shop.dao;

import com.iotbay.shop.model.Cart;
import com.iotbay.shop.model.CartItem;
import com.iotbay.shop.service.EntityManagerFactoryService;
import java.math.BigDecimal;
import java.math.MathContext;

import java.util.List;
import javax.persistence.EntityManager;

public class CartItemDao {

    private EntityManager getEntityManager() {
        return EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
    }

    public void addCartItem(CartItem cartItem) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(cartItem);
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

    public void deleteCartItem(CartItem cartItem) {
        EntityManager em = getEntityManager();
        em.remove(cartItem);
        em.close();
    }

    public void deleteAllCartItemsFromCart(Cart cart) {
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem item : cartItems) {
            deleteCartItem(item);
        }
    }

    public BigDecimal calculateSubtotal(CartItem cartItem) {
        BigDecimal subtotal = cartItem.getPrice().multiply(new BigDecimal(cartItem.getQuantity()));
        return subtotal;
    }

}
