package com.iotbay.shop.dao;

import com.iotbay.shop.model.CreditCard;
import com.iotbay.shop.service.EntityManagerFactoryService;
import java.util.List;
import javax.persistence.EntityManager;

public class CreditCardDao {

    private EntityManager getEntityManager() {
        return EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
    }
    
    public void addCreditCard(CreditCard card) {
        
    }
    
    public CreditCard getCreditCardByCreditCardId(Integer cardId) {
        EntityManager em = getEntityManager();
        return em.find(CreditCard.class, cardId);
    }
        
    public List<CreditCard> getAllCreditCards() {
        return null;
    }
    
    public void updateCreditCard(CreditCard card) {
        
    }
    
    public void deleteCreditCard(CreditCard card) {
        
    }
}
