package com.iotbay.shop.dao;

import com.iotbay.shop.model.CreditCard;
import com.iotbay.shop.service.EntityManagerFactoryService;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CreditCardDao {

    private EntityManager getEntityManager() {
        return EntityManagerFactoryService.getEntityManagerFactory().createEntityManager();
    }

    public void addCreditCard(CreditCard creditCard) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(creditCard);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public CreditCard getCreditCardByCreditCardId(Integer cardId) {
        EntityManager em = getEntityManager();

        CreditCard creditCard = null;
        try {
            creditCard = em.find(CreditCard.class, cardId);
        } finally {
            em.close();
        }
        return creditCard;
    }

    public List<CreditCard> getAllCreditCards() {
        EntityManager em = getEntityManager();
        List<CreditCard> creditCardList = new ArrayList<>();
        try {
            Query query = em.createQuery("select c from CreditCard c");
            for (Object card : query.getResultList()) {
                creditCardList.add((CreditCard) card);
            }
        } finally {
            em.close();
        }
        return creditCardList;
    }

    public void updateCreditCard(CreditCard creditCard, Integer id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(creditCard);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public void deleteCreditCard(CreditCard creditCard) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            creditCard = getCreditCardByCreditCardId(creditCard.getId());
            em.remove(creditCard);
            em.getTransaction().commit();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }
    }
}
