/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iotbay.shop.controller.creditcard;

import com.iotbay.shop.dao.CreditCardDao;
import com.iotbay.shop.dao.UserDao;
import com.iotbay.shop.model.CreditCard;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author josephmant
 */
    @WebServlet(name = "CreditCardServlet", urlPatterns = {"/CreditCardServlet"})
public class CreditCardServlet extends HttpServlet {
    private CreditCardDao creditCardDao = new CreditCardDao();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String addCardNumber = request.getParameter("card-number");
        String addExpirationMonth = request.getParameter("expiration-month");
        String addExpirationYear = request.getParameter("expiration-year");
        String addCardOwner = request.getParameter("card-owner");
        String addCardVerificationValue = request.getParameter("card-verification-value");
        
            CreditCard creditCard = new CreditCard();
            
            creditCard.setCardNumber(addCardNumber);
            creditCard.setExpirationMonth(addExpirationMonth);
            creditCard.setExpirationYear(addExpirationYear);
            creditCard.setCardOwner(addCardOwner);
            creditCard.setCardVerificationValue(addCardVerificationValue);
            
            creditCardDao.addCreditCard(creditCard); 
            session.setAttribute("creditCard", creditCard);
            request.getRequestDispatcher("viewPaymentDetails.jsp").include(request, response);

        }
        
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    
}
