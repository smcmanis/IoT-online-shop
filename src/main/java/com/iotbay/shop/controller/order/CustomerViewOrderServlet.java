package com.iotbay.shop.controller.order;

import com.iotbay.shop.dao.OrderDao;
import com.iotbay.shop.model.Order;
import com.iotbay.shop.model.User;
import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(
        name = "CustomerViewOrderServlet",
        urlPatterns = {"/customer/order/view"})
public class CustomerViewOrderServlet extends HttpServlet {

    private OrderDao orderDao = new OrderDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Check session for authenticated user
        User user = (User) request.getSession().getAttribute("user");

        // Check cookie for authenticated user
        if (user == null) {
            if (authenticateUserByCookies(request.getCookies())) {
                /// user = ...
            }
        }
        
        // Get the requested order if the user has been authenticated
        if (user != null) {
            try {
                Integer orderId = Integer.parseInt(request.getParameter("orderId"));
                Order order = orderDao.getOrderByOrderId(orderId);
                request.setAttribute("order", order);
                request.setAttribute("customer", user);
                request.getRequestDispatcher("/order.jsp").forward(request,response);
            } catch (Exception e) {
                // Inform invalid order requested
                // Redirect to orders
                request.getRequestDispatcher("/customer/order/list").forward(request,response);
            }
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

    private boolean authenticateUserByCookies(Cookie[] cookies) {
//        // Check user has cookies for user crednetials e.g.
//        Integer userId = null;
//        String password = null;
//        for (Cookie cookie: cookies) {
//            if (cookie.getName().equals("userId")) {
//                try {
//                    userId = Integer.parseInt(cookie.getValue());
//                } catch (Exception e) {
//                    System.out.println("could not parse userId from cookie");
//                }
//            } else if (cookie.getName().equals("password")) {
//                password = cookie.getValue();
//            }
//        } 
//       if (userId != null && password != null) {
//           userService.loginUser(userId, password);
//       }........ etc.
        return false;
    }
}
