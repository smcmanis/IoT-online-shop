package com.iotbay.shop.controller.cart;

import com.iotbay.shop.model.Cart;
import com.iotbay.shop.model.CartItem;
import com.iotbay.shop.service.CartItemService;
import com.iotbay.shop.service.CartService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(
        name = "CartServlet",
        urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final CartService cartService = new CartService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = cartService.getCartFromSession(request);
        if (cart != null) {
            cartService.validateCart(cart);
            cart.setTotalPrice(cartService.calculateCartTotal(cart));
            request.getSession().setAttribute("cart", cart);
            request.getRequestDispatcher("/cart.jsp").forward(request, response);
        } else {
            // If no cart found, redirect to homepage
            response.sendRedirect("/IoTBay/cart.jsp");
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
