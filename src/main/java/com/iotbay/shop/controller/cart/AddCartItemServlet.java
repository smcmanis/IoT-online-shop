package com.iotbay.shop.controller.cart;

import com.iotbay.shop.dao.ItemDao;
import com.iotbay.shop.model.Cart;
import com.iotbay.shop.model.CartItem;
import com.iotbay.shop.model.Item;
import com.iotbay.shop.model.User;
import com.iotbay.shop.service.CartService;
import com.iotbay.shop.service.CartItemService;

import java.io.IOException;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(
        name = "AddCartItemServlet",
        urlPatterns = {"/addCartItem"})
public class AddCartItemServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final ItemDao itemDao = new ItemDao();
    private final CartService cartService = new CartService();
    private final CartItemService cartItemService = new CartItemService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = cartService.getCartFromSession(request);
        if (cart == null) {
            // Initialise new cart
            cart = new Cart();
            cartService.initialiseNewCart(cart, session);
            cartService.addCart(cart);
            response.addCookie(new Cookie("cartSessionId", session.getId()));
        } 
      
        Integer quantity;
        try {
            quantity = Integer.parseInt(request.getParameter("quantity"));
        } catch (Exception e) {
            // Default quantity of item to add is 1
            quantity = 1;
        }

        Integer itemId;
        try {
            itemId = Integer.parseInt(request.getParameter("itemId"));
        } catch (Exception e) {
            itemId = null;
        }

        if (itemId != null) {
            Item item = itemDao.getItemByItemId(itemId);
            boolean itemAlreadyInCart = false;
            if (quantity > item.getQuantity()) {
                quantity = item.getQuantity();
            }
            // Check if cart already contains the item  
            for (CartItem cartItem : cart.getCartItems()) {
                if (cartItem.getItem().getId().equals(itemId)) {
                    itemAlreadyInCart = true;
                    // Update the quantity of the item
                    Integer updatedQuantity = cartItem.getQuantity() + quantity;
                    if (item.getQuantity() < updatedQuantity) {
                        updatedQuantity = item.getQuantity();
                    }
                    cartItem.setQuantity(updatedQuantity);
                    cartItem.setSubtotal(cartItemService.calculateSubtotal(cartItem));
                    cartItemService.updateCartItem(cartItem);
                }
            }
            if (!itemAlreadyInCart) {
                // The item is not in the cart, so a new cartItem must be created
                CartItem cartItem = initialiseNewCartItem(cart, item, quantity);
                cart.getCartItems().add(cartItem);
                cartItemService.addCartItem(cartItem);
            }
            cart.setTotalPrice(cartService.calculateCartTotal(cart));
            cartService.updateCart(cart);
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
    
    public CartItem initialiseNewCartItem(Cart cart, Item item, int quantity) {
        CartItem cartItem = new CartItem();
        cartItem.setItem(item);
        cartItem.setQuantity(quantity);
        cartItem.setPrice(item.getPrice());
        cartItem.setSubtotal(cartItemService.calculateSubtotal(cartItem));
        cartItem.setCart(cart);
        return cartItem;
    }
}
