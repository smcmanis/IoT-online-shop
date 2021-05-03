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
        double subtotal = calculateSubtotal(cartItem);
        // MathContext(2) sets BigDecimal precision to 2 decimal places
        cartItem.setPrice(new BigDecimal(subtotal, new MathContext(2)));
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

    public double calculateSubtotal(CartItem cartItem) {
        double subtotal = cartItem.getPrice().doubleValue() * cartItem.getQuantity();
        return subtotal;
    }

}
