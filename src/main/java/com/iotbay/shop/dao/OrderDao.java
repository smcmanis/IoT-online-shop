package com.iotbay.shop.dao;

import com.iotbay.shop.model.Order;
import com.iotbay.shop.service.EntityManagerFactoryService;

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
        Order order = em.find(Order.class, orderId);
        em.close();
        return order;
    }

    public List<Order> getAllOrders() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("select o from Order o");
        List<Order> orderList = query.getResultList();
        em.close();
        return orderList;
    }

    public void updateOrder(Order order) {

    }

    public void deleteOrder(Order order) {

    }

}
