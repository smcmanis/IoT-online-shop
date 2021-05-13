package com.iotbay.shop.controller.cart;

import com.iotbay.shop.dao.CartItemDao;
import com.iotbay.shop.model.Cart;
import com.iotbay.shop.model.CartItem;
import com.iotbay.shop.service.CartService;
import java.io.IOException;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(
        name = "RemoveCartItemServlet",
        urlPatterns = {"/removeCartItem"})
public class RemoveCartItemServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final CartItemDao cartItemDao = new CartItemDao();
    private final CartService cartService = new CartService();

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = cartService.getCartFromSession(request);
        if (Boolean.parseBoolean(request.getParameter("removeAll"))) {
             cartItemDao.removeAllCartItemsFromCart(cart);
             cart.setCartItems(new LinkedList<CartItem>());
        } else {
            String cartItemId = request.getParameter("cartItemId");
            try {
                CartItem cartItem = cartItemDao.getCartItemByCartItemId(Integer.parseInt(cartItemId));
                cart.getCartItems().remove(cartItem);
                cartItemDao.removeCartItem(cartItem);
            } catch (Exception e) {
                
            }
        }
        request.getRequestDispatcher("/cart").forward(request, response);                
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
