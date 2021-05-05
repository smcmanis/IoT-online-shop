package com.iotbay.shop.controller;

import com.iotbay.shop.dao.CartDao;
import com.iotbay.shop.dao.CartItemDao;
import com.iotbay.shop.dao.OrderDao;
import com.iotbay.shop.model.Cart;
import com.iotbay.shop.model.CartItem;
import com.iotbay.shop.model.Order;
import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "CartServlet",
        urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {
    
    private OrderDao orderDao = new OrderDao();
    private CartDao cartDao = new CartDao();
    private CartItemDao cartItemDao = new CartItemDao();
    
    
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer cartId;
        try {
            cartId = Integer.parseInt(request.getParameter("cartId"));
        } catch(Exception e) {
            // try session
            // get cookie or redirect
            cartId = 4;
        }

        Cart cart = cartDao.getCartByCartId(cartId);
        
        // Could move all cart tem total and cart total functions into 
        // cartdAO as validate(Cart cart)
        for (CartItem item : cart.getCartItems()) {
            item.setSubtotal(cartItemDao.calculateSubtotal(item));
        }
        
        cart.setTotalPrice(calculateCartTotal(cart));
        System.out.println(cart.getTotalPrice());
        request.setAttribute("cart", cart);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cart.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    
    private BigDecimal calculateCartTotal(Cart cart) {
        BigDecimal total = new BigDecimal(0);
        for (CartItem item : cart.getCartItems()) {
            total = total.add(item.getSubtotal());
        }
        return total;
    }
}
