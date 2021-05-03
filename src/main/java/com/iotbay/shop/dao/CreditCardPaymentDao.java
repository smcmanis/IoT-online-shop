package com.iotbay.shop.dao;

import com.iotbay.shop.model.CreditCardPayment;
import com.iotbay.shop.service.EntityManagerFactoryService;
import java.util.List;
import javax.persistence.EntityManager;

public class CreditCardPaymentDao {
    
    private EntityManager getEntityManager() {
        return EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
    }
    
    public void addCreditCardPayment(CreditCardPayment payment) {
        
    }
    
    public CreditCardPayment getCreditCardPaymentByCreditCardPaymentId(Integer paymentId) {
        EntityManager em = getEntityManager();
        return em.find(CreditCardPayment.class, paymentId);
    }
        
    public List<CreditCardPayment> getAllCreditCardPayments() {
        return null;
    }
    
    public void updateCreditCardPayment(CreditCardPayment payment) {
        
    }
    
    public void deleteCreditCardPayment(CreditCardPayment payment) {
        
    }
}
