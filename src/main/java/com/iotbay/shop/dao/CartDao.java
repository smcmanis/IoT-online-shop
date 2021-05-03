package com.iotbay.shop.dao;

import com.iotbay.shop.model.Cart;
import com.iotbay.shop.service.EntityManagerFactoryService;


import javax.persistence.EntityManager;

public class CartDao {

    private EntityManager getEntityManager() {
        return EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
    }

    public void addCart(Cart cart) {

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
