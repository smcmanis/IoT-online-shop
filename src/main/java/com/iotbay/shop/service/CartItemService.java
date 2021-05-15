package com.iotbay.shop.service;

import com.iotbay.shop.dao.CartItemDao;
import com.iotbay.shop.model.Cart;
import com.iotbay.shop.model.CartItem;
import java.math.BigDecimal;

public class CartItemService {

    private CartItemDao cartItemDao = new CartItemDao();

    public void addCartItem(CartItem cartItem) {
        cartItemDao.addCartItem(cartItem);
    }

    public void updateCartItem(CartItem cartItem) {
        cartItemDao.updateCartItem(cartItem);
    }

    public void removeCartItem(CartItem cartItem) {
        cartItemDao.removeCartItemById(cartItem.getId());
    }

    public void removeAllCartItemsFromCart(Cart cart) {
        cartItemDao.removeAllCartItemsFromCart(cart);
    }

    public BigDecimal calculateSubtotal(CartItem cartItem) {
        BigDecimal subtotal = cartItem.getPrice().multiply(new BigDecimal(cartItem.getQuantity()));
        return subtotal;
    }
}
