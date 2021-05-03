package com.iotbay.shop.dao;

import com.iotbay.shop.model.Address;
import com.iotbay.shop.service.EntityManagerFactoryService;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class AddressDao {
    
    private EntityManager getEntityManager() {
        return EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
    }
    
    public void addAddress(Address address) {
        
    }
    
    public Address getAddressByAddressId(Integer addressId) {
        EntityManager em = getEntityManager();
        return em.find(Address.class, addressId);
    }
        
    public List<Address> getAllAddresss() {
        Query query =  getEntityManager().createQuery("select a from Address a");
        return query.getResultList();
    }
    
    public void updateAddress(Address address) {
        
    }
    
    public void deleteAddress(Address address) {
        
    }
}
