package com.iotbay.shop.dao;

import com.iotbay.shop.model.User;
import com.iotbay.shop.service.EntityManagerFactoryService;

import java.util.List;
import javax.persistence.EntityManager;

public class UserDao {
    
    private EntityManager getEntityManager() {
        return EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
    }
    
    public void addUser(User user) {
        
    }
    
    public User getUserByUserId(Integer userId) {
        EntityManager em = getEntityManager();
        User user = em.find(User.class, userId);
        em.close();
        return user;
    }
        
    public List<User> getAllUsers() {
        EntityManager em = getEntityManager();
        List<User> userList = em.createQuery("select u from User u").getResultList();
        em.close();
        return userList;
    }
    
    public void updateUser(User user) {
        
    }
    
    public void deleteUser(User user) {
        
    }
}
