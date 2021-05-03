package com.iotbay.shop.dao;

import com.iotbay.shop.model.Supplier;
import com.iotbay.shop.service.EntityManagerFactoryService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

public class SupplierDao {
    
    private EntityManager getEntityManager() {
        return EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
    }
    
    public void addSupplier(Supplier supplier) {
        
    }
    
    public Supplier getSupplierBySupplierId(Integer supplierId) {
        EntityManager em = getEntityManager();
        return em.find(Supplier.class, supplierId);
    }
        
    public List<Supplier> getAllSuppliers() {
        return null;
    }
    
    public void updateSupplier(Supplier supplier) {
        
    }
    
    public void deleteSupplier(Supplier supplier) {
        
    }
}
