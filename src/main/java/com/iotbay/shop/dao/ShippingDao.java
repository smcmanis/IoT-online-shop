package com.iotbay.shop.dao;

import com.iotbay.shop.model.Shipping;
import com.iotbay.shop.service.EntityManagerFactoryService;
import java.util.List;
import javax.persistence.EntityManager;

public class ShippingDao {
     
    private EntityManager getEntityManager() {
        return EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
    }
    
    public void addShipping(Shipping shipping) {
        
    }
    
    public Shipping getShippingByShippingId(Integer shippingId) {
        EntityManager em = getEntityManager();
        return em.find(Shipping.class, shippingId);
    }
        
    public List<Shipping> getAllShippings() {
        return null;
    }
    
    public void updateShipping(Shipping shipping) {
        
    }
    
    public void deleteShipping(Shipping shipping) {
        
    }
}
