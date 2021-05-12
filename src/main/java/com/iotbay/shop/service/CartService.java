package com.iotbay.shop.service;


import com.iotbay.shop.dao.CartDao;
import com.iotbay.shop.model.Cart;
import com.iotbay.shop.model.CartItem;
import java.math.BigDecimal;
import java.util.LinkedList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CartService {

    private CartDao cartDao = new CartDao();
    
    public CartService() {}
    
    public void addCart(Cart cart) {
        validateCart(cart);
        cartDao.addCart(cart);
    }
    
    public void updateCart(Cart cart) {
        validateCart(cart);
        cartDao.updateCart(cart);
    }
    
    public Cart getCart(HttpServletRequest request) {
        // Look for cart in session
        Cart cart = getCartFromSession(request.getSession());
        if (cart == null) {
            // Look for cart in cookies
            cart = getCartFromCookies(request.getCookies());
        }
        if (cart != null) {
            validateCart(cart);
        }
        return cart;
    }

    public Cart getCartFromSession(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            // Check for cart for session in database
            cart = cartDao.getCartByHttpSessionId(session.getId());
        }

        return cart;
    }

    public Cart getCartFromCookies(Cookie[] cookies) {
        Cart cart = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("cartId")) {
                cart = cartDao.getCartByCartId(Integer.parseInt(cookie.getValue()));
                return cart;
            }
        }
        return cart;
    }
    
    private BigDecimal calculateCartTotal(Cart cart) {
        BigDecimal total = new BigDecimal(0);
        for (CartItem item : cart.getCartItems()) {
            total = total.add(item.getSubtotal());
        }
        return total;
    }

    public void validateCart(Cart cart) {
        if (cart.getCartItems() == null) {
            cart.setCartItems(new LinkedList<CartItem>());
        }

        cart.setTotalPrice(calculateCartTotal(cart));
        cartDao.updateCart(cart);
    }
}
