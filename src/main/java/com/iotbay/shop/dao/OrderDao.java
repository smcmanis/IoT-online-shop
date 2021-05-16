package com.iotbay.shop.dao;

import com.iotbay.shop.model.Order;
import com.iotbay.shop.service.EntityManagerFactoryService;
import java.util.LinkedList;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class OrderDao {

    private EntityManager getEntityManager() {
        return EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
    }

    public void addOrder(Order order) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(order);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Order getOrderByOrderId(Integer orderId) {
        EntityManager em = getEntityManager();
        Order order = null;
        try {
            order = em.find(Order.class, orderId);
        } finally { 
            em.close();
        }
        return order;
    }

    public List<Order> getAllOrders() {
        EntityManager em = getEntityManager();
        List<Order> orderList = new LinkedList<>();
        try {
            Query query = em.createQuery("select o from Order o");
            for (Object result : query.getResultList()) {
                orderList.add((Order) result);
            }
        } finally {
            em.close();
        }
        return orderList;
    }
   
    public void updateOrder(Order order) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(order);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void deleteOrder(Order order) {

    }

}
