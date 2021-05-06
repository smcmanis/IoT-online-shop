package com.iotbay.shop.dao;

import com.iotbay.shop.model.Cart;
import com.iotbay.shop.model.CartItem;
import com.iotbay.shop.service.EntityManagerFactoryService;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.LinkedList;

import javax.persistence.EntityManager;

public class CartDao {

    private EntityManager getEntityManager() {
        return EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
    }

    private CartItemDao cartItemDao = new CartItemDao();

    public void validateCart(Cart cart) {
        if (cart.getCartItems() == null) {
            cart.setCartItems(new LinkedList<CartItem>());
        }
        BigDecimal totalPrice = new BigDecimal(0, new MathContext(2));
        for (CartItem cartItem : cart.getCartItems()) {
            totalPrice = totalPrice.add(cartItem.getSubtotal());
        }
        cart.setTotalPrice(totalPrice);
    }

    public void addCart(Cart cart) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cart);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Cart getCartByCartId(Integer cartId) {
        EntityManager em = getEntityManager();
        Cart cart = em.find(Cart.class, cartId);
        em.close();
        return cart;
    }

//    public void updateCart(Cart cart) {
//        double totalPrice = calculateCartTotal(cart);
//        // MathContext(2) sets BigDecimal precision to 2 decimal places
//        cart.setTotalPrice(new BigDecimal(totalPrice, new MathContext(2)));
//        EntityManager em = getEntityManager();
//        em.merge(cart);
//        em.flush();
//        em.close();
//    }
//    
//    public void deleteCart(Cart cart) {
//        EntityManager em = getEntityManager();
//        em.remove(cart);
//        em.close();
//    }
}
