package com.iotbay.shop.dao;

import com.iotbay.shop.model.Shipment;
import com.iotbay.shop.model.ShipmentDetails;
import com.iotbay.shop.service.EntityManagerFactoryService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ShippingDao {
     
    private EntityManager getEntityManager() {
        return EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
    }
    private Statement st;
    
    public void addShipping(ShipmentDetails shipping) {
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(shipping);
            em.getTransaction().commit();
        } finally {
            em.close();    
        }
    }
    
    public Shipment getShippingByShippingId(Integer shippingId) {
        EntityManager em = getEntityManager();
        return em.find(Shipment.class, shippingId);
    }
    
    public ShipmentDetails getShippingByAddress(String address_line_1) {
        EntityManager em = getEntityManager();
        ShipmentDetails shipmentDetails = null;
        try {
            Query q = em.createQuery("select c from User c where c.address_line_1 = :address_line_1")
                    .setParameter("address_line_1", address_line_1);
            if (q.getResultList().size() > 0) {
                shipmentDetails = (ShipmentDetails) q.getResultList().get(0); 
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            em.close();
        }
        return shipmentDetails;
    }
    

    public ShipmentDetails getShippingDetailsByShippingDetailsId(Integer shippingDetId) {
        EntityManager em = getEntityManager();
        ShipmentDetails shipmentDetails = null;
         try {
            shipmentDetails = em.find(ShipmentDetails.class, shippingDetId);
        } finally {
            em.close();
        }
        return shipmentDetails;
    }
        
    public List<Shipment> getAllShippings() {
        return null;
    }
    
    public void updateShipping(ShipmentDetails shipping) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(shipping);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public void deleteShipping(ShipmentDetails shipping) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.find(ShipmentDetails.class, shipping.getShipment_details_id()));
            em.getTransaction().commit();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }
    }
}
