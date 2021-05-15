package com.iotbay.shop.service;

import com.iotbay.shop.dao.CartDao;
import com.iotbay.shop.model.Cart;
import com.iotbay.shop.model.CartItem;
import com.iotbay.shop.model.User;
import java.math.BigDecimal;
import java.util.LinkedList;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CartService {

    private final CartDao cartDao = new CartDao();
    private final CartItemService cartItemService = new CartItemService();
    
    public CartService() {}
    
    public void addCart(Cart cart) {
        cartDao.addCart(cart);
    }
    
    public void updateCart(Cart cart) {
        cartDao.updateCart(cart);
    }
    
    public Cart getCartByCartId(Integer cartId) {
        return cartDao.getCartByCartId(cartId);
    }
    
    public Cart getCartFromSession(HttpServletRequest request) {
        String httpSessionId = getCartSessionIdFromCookie(request.getCookies());
        return cartDao.getCartByHttpSessionId(httpSessionId);
    }

    public Cart getCartFromSession(HttpSession session) {
        return cartDao.getCartByHttpSessionId(session.getId());
    }

    public String getCartSessionIdFromCookie(Cookie[] cookies) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cartSessionId")) {
                    return cookie.getValue();
                }
            }
        }
        return "";
    }
    
    public BigDecimal calculateCartTotal(Cart cart) {
        BigDecimal total = new BigDecimal(0);
        for (CartItem cartItem : cart.getCartItems()) {
            total = total.add(cartItem.getSubtotal());
        }
        return total;
    }
    
    public void validateCart(Cart cart) {
        for (CartItem cartItem : cart.getCartItems()) {
            cartItem.setSubtotal(cartItemService.calculateSubtotal(cartItem));
        }
        cart.setTotalPrice(calculateCartTotal(cart));
    }
    
    public void initialiseNewCart(Cart cart, HttpSession session) {
        if (session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            cart.setUser(user);
        }
        cart.setCartItems(new LinkedList<CartItem>());
        cart.setHttpSessionId(session.getId());
        
    }
    
    public void retireUsedCart(Cart cart, Cookie[] cookies, HttpSession session) {
        // cant have duplicate sessionIds
        String sessionId = cart.getHttpSessionId();
        cart.setHttpSessionId(null);
        session.removeAttribute("cartSessionId");
        session.removeAttribute("cart");
        cartDao.updateCart(cart);
        
        // Find and delete coookie
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("cartSessionId")) {
                cookie.setMaxAge(0);
            } 
            if (cookie.getValue().equals(sessionId)) {
                cookie.setMaxAge(0);
            }
        }
        
    }
}
