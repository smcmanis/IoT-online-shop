package com.iotbay.shop.dao;

import com.iotbay.shop.model.Cart;
import com.iotbay.shop.service.EntityManagerFactoryService;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class CartDao {

    private EntityManager getEntityManager() {
        return EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
    }

    private CartItemDao cartItemDao = new CartItemDao();

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
        Cart cart;
        EntityManager em = getEntityManager();
        try {
            cart = em.find(Cart.class, cartId);
        } finally {
            em.close();
        }
        return cart;
    }
    
    public Cart getCartByHttpSessionId(String httpSessionId) {
        Cart cart;
        EntityManager em = getEntityManager();
        try {
            cart = (Cart) em.createQuery("select c from Cart c where c.httpSessionId like :httpSessionId")
                    .setParameter("httpSessionId", httpSessionId)
                    .getSingleResult();
        } catch (NoResultException e) {
            cart = null;
        } finally {
            em.close();
        }
        return cart;
    }


   
    public void updateCart(Cart cart) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(cart);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
