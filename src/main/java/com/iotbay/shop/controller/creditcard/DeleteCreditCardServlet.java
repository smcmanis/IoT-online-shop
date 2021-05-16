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
import java.util.List;
import javax.servlet.RequestDispatcher;
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
@WebServlet(
        name = "deleteCreditCardServlet",
        urlPatterns = {"/deleteCreditCard"})
public class DeleteCreditCardServlet extends HttpServlet{

    private CreditCardDao creditCardDao = new CreditCardDao();
    private UserDao userDao = new UserDao();

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        Integer creditCardId = null;
        try {
            creditCardId = Integer.parseInt(request.getParameter("creditCardId"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        if (user != null && creditCardId != null) {
            CreditCard creditCardToRemove = null;
            List<CreditCard> userCreditCards = user.getCreditCards();
            for (CreditCard userCreditCard : userCreditCards) {
                if (userCreditCard.getId().equals(creditCardId)) {
                    creditCardToRemove = userCreditCard;
                }
            }
            
            if (creditCardToRemove != null) {
                userCreditCards.remove(creditCardToRemove);
                user.setCreditCards(userCreditCards);
                userDao.updateUser(user);
                // Should cascade down to creditcards table
            }
            
        }
        request.getRequestDispatcher("/customer/creditCards").forward(request, response);

        
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
