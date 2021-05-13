package com.iotbay.shop.dao;

import com.iotbay.shop.model.Cart;
import com.iotbay.shop.service.EntityManagerFactoryService;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CartDao {

    private EntityManager getEntityManager() {
        return EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
    }


    public void addCart(Cart cart) {
        Integer cartId = cart.getId();
        if (cartId!= null) {
            updateCart(cart);
        } else {
            EntityManager em = getEntityManager();
            try {
                em.getTransaction().begin();
                em.persist(cart);
                em.getTransaction().commit();
            } finally {
                em.close();
            }
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
            Query query = em.createQuery("select c from Cart c where c.httpSessionId like :httpSessionId")
                    .setParameter("httpSessionId", httpSessionId);
            cart = (Cart) query.getResultList().get(0);
        } catch (IndexOutOfBoundsException e) {
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
