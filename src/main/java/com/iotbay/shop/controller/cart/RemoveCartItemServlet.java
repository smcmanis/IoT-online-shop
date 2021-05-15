package com.iotbay.shop.controller.cart;

import com.iotbay.shop.dao.CartItemDao;
import com.iotbay.shop.model.Cart;
import com.iotbay.shop.model.CartItem;
import com.iotbay.shop.service.CartItemService;
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
    private final CartItemService cartItemService = new CartItemService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = cartService.getCartFromSession(request);
        String removeAllItems = request.getParameter("removeAll");
        if (removeAllItems != null) {
            cartItemDao.removeAllCartItemsFromCart(cart);
            cart.setCartItems(new LinkedList<CartItem>());
        } else {
            String cartItemId = request.getParameter("cartItemId");
            try {
                CartItem cartItem = cartItemDao.getCartItemByCartItemId(Integer.parseInt(cartItemId));
                Integer adjustedQuantity = cartItem.getQuantity() - Integer.parseInt(request.getParameter("quantity"));
                if (adjustedQuantity > 0) {
                    cartItem.setQuantity(adjustedQuantity);
                    cartItem.setSubtotal(cartItemService.calculateSubtotal(cartItem));
                    cartItemDao.updateCartItem(cartItem);
                } else {
                    removeFromCart(cart, cartItem.getId());
                    cartItemDao.removeCartItemById(cartItem.getId());
                }
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
    
    private void removeFromCart(Cart cart, Integer cartItemId) {
        CartItem cartItem = null;
        for (CartItem c : cart.getCartItems()) {
            if (c.getId().equals(cartItemId)) {
                cartItem = c;
            }
        }
        if (cartItem != null) {
            cart.getCartItems().remove(cartItem);
            cartService.updateCart(cart);
        }
        
    }
    
}
