package com.iotbay.shop.controller.creditcard;

import com.iotbay.shop.dao.CreditCardDao;
import com.iotbay.shop.model.CreditCard;
import com.iotbay.shop.model.Payment;
import com.iotbay.shop.model.User;
import com.iotbay.shop.service.UserService;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
        name = "CreditCardListServlet",
        urlPatterns = {"/customer/creditCards"})
public class CreditCardListServlet extends HttpServlet {

    private CreditCardDao creditCardDao = new CreditCardDao();
    private UserService userService = new UserService();

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher;
        // Check session for authenticated user
        User user = (User) request.getSession().getAttribute("user");

        // Check cookie for authenticated user
        if (user == null) {
            // check for userCookie, and get user by id if authenticated
            if (userService.authenticateUserByCookies(request.getCookies())) {
                // ...
            }
        }

        if (user != null) { 
            List<CreditCard> creditCards = user.getCreditCards();
            System.out.println(creditCards.size());
            session.setAttribute("userCreditCards", creditCards);
            
            List<Payment> payments = user.getPayments();
            System.out.println(payments.size());
            session.setAttribute("userPayments", payments);
            
            dispatcher = request.getRequestDispatcher("/viewPaymentDetails.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("/IoTBay/login.jsp");
        }
        
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
