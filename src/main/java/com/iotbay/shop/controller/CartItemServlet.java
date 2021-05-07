package com.iotbay.shop.controller;

import com.iotbay.shop.dao.CartDao;
import com.iotbay.shop.dao.CartItemDao;
import com.iotbay.shop.dao.ItemDao;
import com.iotbay.shop.model.Cart;
import com.iotbay.shop.model.CartItem;
import com.iotbay.shop.model.Item;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "CartItemServlet",
        urlPatterns = {"/cartItem"})
public class CartItemServlet extends HttpServlet {

    private CartItemDao cartItemDao = new CartItemDao();
    private ItemDao itemDao = new ItemDao();
    private CartDao cartDao = new CartDao();

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("remove")) {
            processRemoveCartItem(request, response);
        } else if (action.equals("add")) {
            addCartItem(request, response);
        }
// Take to product catalogue page
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/cart");
//        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    public void processRemoveCartItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cartItemIdParam = request.getParameter("cartItemId");
        Integer cartItemId = Integer.parseInt(cartItemIdParam);
        CartItem cartItem = cartItemDao.getCartItemByCartItemId(cartItemId);
        Integer cartId = cartItem.getCart().getId();

        cartItemDao.removeCartItem(cartItem);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/cart?cartId=" + cartId);
        dispatcher.forward(request, response);
    }

    private void addCartItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        Integer itemId = Integer.parseInt(request.getParameter("itemId"));
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        
        if (cart == null) {
            cart = cartDao.getCartByCartId(5);
        }
        
        Item item = itemDao.getItemByItemId(itemId);
        
        for (CartItem cartItem : cart.getCartItems()) {
            if (cartItem.getItem().getId() == item.getId()) {
                cartItem.setQuantity(cartItem.getQuantity() + quantity);
                cartItemDao.updateCartItem(cartItem);
                return;
            }
        }
        CartItem cartItem = new CartItem();
        cartItem.setItem(item);
        cartItem.setQuantity(quantity);
        cartItem.setPrice(item.getPrice());
        cartItem.setSubtotal(item.getPrice().multiply(new BigDecimal(cartItem.getQuantity())));
        cartItem.setCart(cart);
        
        cartItemDao.addCartItem(cartItem);
        
        // Take to product catalogue page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cart?cartId=" + cart.getId());
        dispatcher.forward(request, response);
    }
}
