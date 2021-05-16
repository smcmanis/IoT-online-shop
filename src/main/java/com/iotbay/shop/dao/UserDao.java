package com.iotbay.shop.dao;

import com.iotbay.shop.model.User;
import com.iotbay.shop.service.EntityManagerFactoryService;
import java.util.LinkedList;

import java.util.List;
import javax.persistence.EntityManager;
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
        User user = null;
        try {
            user = em.find(User.class, userId);
        } finally {
            em.close();
        }
        return user;
    }

    public User getUserByUserEmail(String email) {
        EntityManager em = getEntityManager();
        User user = null;
        try {
            Query q = em.createQuery("select u from User u where u.email = :email")
                    .setParameter("email", email);
            if (q.getResultList().size() > 0) {
                user = (User) q.getResultList().get(0);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            em.close();
        }
        return user;
    }

    public List<User> getAllUsers() {
        EntityManager em = getEntityManager();
        List<User> userList = new LinkedList<>();
        try {
            for (Object userObject : em.createQuery("select u from User u").getResultList()) {
                userList.add((User) userObject);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
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
    
    public List<User> getAllCustomers(String firstName, String lastName) {
        EntityManager em = getEntityManager();
        String sql = "select u from User u where isadmin is not true and  lower(firstname) like lower('%"+firstName+"%') and lower(lastname) like lower('%"+lastName +"%')";
        List<User> userList =em.createQuery(sql).getResultList();
        em.close();
        return userList;
    }
    
    public List<User> getAllCustomers(String firstName, String lastName, String customertype) {
        EntityManager em = getEntityManager();
        String sql = "select u from User u where isadmin is not true and lower(firstname) like lower('%"+firstName+"%') and lower(lastname) like lower('%"+lastName +"%') and lower(customertype) like lower('%"+customertype+"%')";
        List<User> userList =em.createQuery(sql).getResultList();
        em.close();
        return userList;
    }
    
    public List<User> getAllCustomers() {
        EntityManager em = getEntityManager();
        List<User> customerList = em.createQuery("select u from User u where isadmin is not true").getResultList();
        em.close();
        return customerList;
    }
}
