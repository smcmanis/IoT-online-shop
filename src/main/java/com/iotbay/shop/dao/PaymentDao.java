package com.iotbay.shop.dao;

import com.iotbay.shop.model.Payment;
import com.iotbay.shop.service.EntityManagerFactoryService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PaymentDao {

    private EntityManager getEntityManager() {
        return EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
    }

    public void addPayment(Payment payment) {

    }

    public Payment getPaymentByPaymentId(Integer paymentId) {
        EntityManager em = getEntityManager();
        Payment payment = null;
        try {
            payment = em.find(Payment.class, paymentId);
        } finally {
            em.close();
        }
        return payment;

    }

    public List<Payment> getAllPayments() {
        return null;
    }

    public void updatePayment(Payment payment) {

    }

    public void deletePayment(Payment payment) {

    }
}
