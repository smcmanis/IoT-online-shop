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
    
    public Cart getCartFromSession(HttpServletRequest request) {
        // Look for cart in session
        Cart cart = cartDao.getCartByHttpSessionId(request.getSession().getId());
        if (cart == null) {
            // Look for cart in cookies
            String httpSessionId = getCartSessionIdFromCookie(request.getCookies());
            cart = cartDao.getCartByHttpSessionId(httpSessionId);
        }
//        if (cart != null) {
//            validateCart(cart);
//        }
        
        return cart;
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
    }
}
