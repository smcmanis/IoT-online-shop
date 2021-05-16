/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iotbay.shop.controller.creditcard;

import com.iotbay.shop.dao.CreditCardDao;
import com.iotbay.shop.dao.UserDao;
import com.iotbay.shop.model.CreditCard;
import com.iotbay.shop.model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author josephmant
 */
@WebServlet(
        name = "GetUpdateCreditCardPageServlet",
        urlPatterns = {"/GetEditPageServletGetUpdateCreditCardPageServlet"})
public class GetUpdateCreditCardPageServlet extends HttpServlet {

    private CreditCardDao creditCardDao = new CreditCardDao();
    private UserDao userDao = new UserDao();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        User user = (User) request.getSession().getAttribute("user");
        int cardId = -1;
        try {
            cardId = Integer.parseInt(request.getParameter("cardId"));
        }catch (Exception e) {
            System.out.println("hello");
        } 
        
        CreditCard creditCard = creditCardDao.getCreditCardByCreditCardId(cardId);
        request.setAttribute("creditCard", creditCard);
        
        request.getRequestDispatcher("/editPaymentDetails.jsp").forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}