package com.iotbay.shop.controller.cart;

import com.iotbay.shop.dao.CartItemDao;
import com.iotbay.shop.dao.ItemDao;
import com.iotbay.shop.model.Cart;
import com.iotbay.shop.model.CartItem;
import com.iotbay.shop.model.Item;
import com.iotbay.shop.model.User;
import com.iotbay.shop.service.CartService;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(
        name = "AddCartItemServlet",
        urlPatterns = {"/addCartItem"})
public class AddCartItemServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final CartItemDao cartItemDao = new CartItemDao();
    private final ItemDao itemDao = new ItemDao();
    private final CartService cartService = new CartService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = cartService.getCartFromSession(request);
        if (cart == null) {
            // Initialise new cart
            cart = new Cart();
            if (session.getAttribute("user") != null) {
                User user = (User) session.getAttribute("user");
                cart.setUser(user);
            }
            cart.setCartItems(new LinkedList<CartItem>());
            cart.setHttpSessionId(session.getId());
            cartService.addCart(cart);
            response.addCookie(new Cookie("cartSessionId", session.getId()));
        }

        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        Integer itemId = Integer.parseInt(request.getParameter("itemId"));

        // Check if cart already contains the item  
        for (CartItem cartItem : cart.getCartItems()) {
            if (cartItem.getItem().getId().equals(itemId)) {
                // Update the quantity of the item 
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                cartItemDao.updateCartItem(cartItem);
                request.getRequestDispatcher("/cart").forward(request, response);
            }
        }
        
        // The item is not in the cart, so a new cartItem must be created
        CartItem cartItem = new CartItem();
        Item item = itemDao.getItemByItemId(itemId);
        cartItem.setItem(item);
        cartItem.setQuantity(quantity);
        cartItem.setPrice(item.getPrice());
        cartItem.setSubtotal(item.getPrice().multiply(new BigDecimal(cartItem.getQuantity())));
        cartItem.setCart(cart);
        cartItemDao.addCartItem(cartItem);
                
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
