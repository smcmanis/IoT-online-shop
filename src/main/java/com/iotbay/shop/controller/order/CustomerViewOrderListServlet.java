package com.iotbay.shop.controller.order;

import com.iotbay.shop.dao.OrderDao;
import com.iotbay.shop.model.Order;
import com.iotbay.shop.model.User;
import com.iotbay.shop.service.UserService;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
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
            // Check request parameters for dat filter and order Id search
            LocalDate filterDateStart = null;
            LocalDate filterDateEnd = null;
            try {
                filterDateStart = LocalDate.parse(request.getParameter("filterDateStart"));
                filterDateEnd = LocalDate.parse(request.getParameter("filterDateEnd"));
            } catch (Exception e) {

            }

            if (filterDateStart != null && filterDateEnd != null) {
                List<Order> filteredOrders = new LinkedList<>();
                LocalDate orderDate;
                for (Order order : user.getOrders()) {
                    orderDate = order.getOrderDate().toLocalDate();
                    // .isbefore() and .isAfter() are exclusive. We want inclusive date so I am using
                    // the negation of the ranges to be filtered out
                    // A better wayh would probably be to use orderDao to directly query DB
                    if (!orderDate.isBefore(filterDateStart) && !orderDate.isAfter(filterDateEnd)) {
                        filteredOrders.add(order);
                    }
                }
                request.setAttribute("customerOrders", filteredOrders);
                request.setAttribute("filterDateStart", filterDateStart);
                request.setAttribute("filterDateEnd", filterDateEnd);
            } else {
                request.setAttribute("customerOrders", user.getOrders());
            }

            request.setAttribute("customer", user);
            request.getRequestDispatcher("/CustomerViewOrderListServlet").forward(request, response);
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
