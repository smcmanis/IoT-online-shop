/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iotbay.shop.controller.creditcard;

import com.iotbay.shop.dao.CreditCardDao;
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
@WebServlet(
        name = "UpdateCreditCard",
        urlPatterns = {"/UpdateCreditCardServlet"})
public class UpdateCreditCardServlet extends HttpServlet {

    private CreditCardDao creditCardDao = new CreditCardDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String cardNumber = request.getParameter("cardNumber");
        CreditCard creditCard = creditCardDao.getCreditCardByCardNumber(cardNumber);

        try {
            if (creditCard != null) {
                session.setAttribute("creditCard", creditCard);
                request.getRequestDispatcher("UpdateCreditCardServlet").include(request, response);
            } else {
                session.setAttribute("existErr", "Card does not exist in the database");
                request.getRequestDispatcher("UpdateCreditCardServlet").include(request, response);
            }
        } catch (NullPointerException ex) {
            System.out.println(ex.getMessage() == null ? "Card does not exist" : "Welcome");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

}
