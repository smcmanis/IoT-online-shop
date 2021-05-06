package com.iotbay.shop.controller;

import com.iotbay.shop.dao.CartDao;
import com.iotbay.shop.dao.CartItemDao;
import com.iotbay.shop.dao.OrderDao;
import com.iotbay.shop.model.Cart;
import com.iotbay.shop.model.CartItem;
import com.iotbay.shop.model.Order;
import com.iotbay.shop.model.User;
import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
        name = "OrderServlet",
        urlPatterns = {"/order"})
public class OrderServlet extends HttpServlet {

    private OrderDao orderDao = new OrderDao();
    private CartItemDao cartItemDao = new CartItemDao();
    private CartDao cartDao = new CartDao();

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        if (action != null && action.equals("add")) {
            if (session.getAttribute("order") != null) {
                response.sendRedirect("/ordrer.jsp");
//                RequestDispatcher dispatcher = request.getRequestDispatcher("/order.jsp");
//                dispatcher.forward(request, response);
                return;
            }
            User user = (User) request.getSession().getAttribute("user");
            Cart newCart = new Cart();
            Order newOrder = new Order();
            if (user != null) {
                newCart.setUser(user);
                newOrder.setUser(user);
            }
            cartDao.validateCart(newCart);
            cartDao.addCart(newCart);
            newOrder.setCart(newCart);
            newOrder.setOrderStatus("Saved");
            newOrder.setTotalPrice(newCart.getTotalPrice());
            orderDao.addOrder(newOrder);

            session.setAttribute("order", newOrder);
            session.setAttribute("cart", newCart);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/order.jsp");
            dispatcher.forward(request, response);
        } 
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer orderId = Integer.parseInt(request.getParameter("orderId"));
        Order order = orderDao.getOrderByOrderId(orderId);
        request.setAttribute("order", order);
        Cart cart = order.getCart();
        for (CartItem item : cart.getCartItems()) {
            item.setSubtotal(cartItemDao.calculateSubtotal(item));
        }
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
