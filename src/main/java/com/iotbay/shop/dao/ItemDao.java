package com.iotbay.shop.dao;

import com.iotbay.shop.model.Item;
import com.iotbay.shop.service.EntityManagerFactoryService;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class ItemDao {

    private EntityManager getEntityManager() {
        return EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
    }

    public void addItem(Item item) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(item);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Item getItemByItemId(Integer itemId) {
        EntityManager em = getEntityManager();
        Item item = null;
        try {
            item = em.find(Item.class, itemId);
        } finally {
            em.close();
        }
        return item;
    }

    public List<Item> getItemsBySearchQuery(String searchQuery) {
        EntityManager em = getEntityManager();
        List<Item> itemList = new ArrayList<>();

        try {
            Query query = em.createQuery("select i from Item i where name like :name").setParameter("name", searchQuery);
            for (Object item : query.getResultList()) {
                itemList.add((Item) item);
            }
        } catch (NoResultException e) {

        } finally {
            em.close();
        }
        return itemList;
    }

    public List<Item> getItemsByItemCategory(String itemCategory) {
        EntityManager em = getEntityManager();
        List<Item> itemList = new ArrayList<>();
        try {
            Query query = em.createQuery("select i from Item i where category like :category")
                    .setParameter("category", itemCategory);
            for (Object item : query.getResultList()) {
                itemList.add((Item) item);
            }
        } catch (NoResultException e) {

        } finally {
            em.close();
        }
        return itemList;
    }

    public List<Item> getAllItems() {
        EntityManager em = getEntityManager();
        List<Item> itemList = new LinkedList<>();
        try {
            Query query = em.createQuery("select i from Item i");
            for (Object item : query.getResultList()) {
                itemList.add((Item) item);
            }
        } finally {
            em.close();
        }
        return itemList;
    }

    public void updateItem(Item item) {
        EntityManager em = getEntityManager();
        try {
            Integer itemId = item.getId();
            if (itemId != null && em.find(Item.class, itemId) != null) {
                em.getTransaction().begin();
                em.merge(item);
                em.getTransaction().commit();
            }
        } finally {
            em.close();
        }
    }

    public void deleteItem(Item item) {
        Integer itemId = item.getId();
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.find(Item.class, itemId));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
