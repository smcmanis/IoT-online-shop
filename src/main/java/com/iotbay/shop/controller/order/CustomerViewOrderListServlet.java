package com.iotbay.shop.controller.order;

import com.iotbay.shop.dao.OrderDao;
import com.iotbay.shop.model.Order;
import com.iotbay.shop.model.User;
import com.iotbay.shop.service.UserService;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(
        name = "CustomerViewOrderListServlet",
        urlPatterns = {"/customer/order/list"})
public class CustomerViewOrderListServlet extends HttpServlet {

    private OrderDao orderDao = new OrderDao();
    private UserService userService = new UserService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            request.setAttribute("customer", user);
            request.setAttribute("customerOrders", user.getOrders());
            request.getRequestDispatcher("/orderList.jsp").forward(request, response);
        } else {
            // Redirect unauthenticated user to login
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
