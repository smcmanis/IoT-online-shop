package com.iotbay.shop.dao;

import com.iotbay.shop.model.Item;
import com.iotbay.shop.service.EntityManagerFactoryService;
import java.util.List;
import javax.persistence.EntityManager;

public class ItemDao {
    
    private EntityManager getEntityManager() {
        return EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
    }
    
    public void addItem(Item item) {
        
    }
    
    public Item getItemByItemId(Integer itemId) {
        EntityManager em = getEntityManager();
        Item item = em.find(Item.class, itemId);
        em.close();
        return item;
    }
        
    public List<Item> getAllItems() {
        return null;
    }
    
    public void updateItem(Item item) {
        
    }
    
    public void deleteItem(Item item) {
        
    }
}
