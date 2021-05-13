package com.iotbay.shop.dao;

import com.iotbay.shop.model.User;
import com.iotbay.shop.service.EntityManagerFactoryService;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class UserDao {

    private EntityManager getEntityManager() {
        return EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
    }

    public void addUser(User user) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

    public User getUserByUserId(Integer userId) {
        EntityManager em = getEntityManager();
        User user = em.find(User.class, userId);
        em.close();
        return user;
    }

    public User getUserByUserEmail(String email) {
        EntityManager em = getEntityManager();
        User user = null;
        try {
            Query q = em.createQuery("select u from User u where u.email = :email")
                    .setParameter("email", email);
            user = (User) q.getSingleResult();

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }
        return user;
    }

    public List<User> getAllUsers() {
        EntityManager em = getEntityManager();
        List<User> userList = em.createQuery("select u from User u").getResultList();
        em.close();
        return userList;
    }

    public void updateUser(User user) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void deleteUser(User user) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(user));
            em.getTransaction().commit();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }

    }
}
