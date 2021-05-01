package com.iotbay.shop.dao;

import com.iotbay.shop.model.Cart;
import com.iotbay.shop.model.CartItem;
import com.iotbay.shop.model.Item;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CartDao extends Dao {
    
    private ItemDao itemDao = new ItemDao();

    public Cart getCartByCartId(Integer cartId) throws SQLException {
        // Dumb original query to get userId. Can do a join and initialise new cart first but not big deal
        String query = "SELECT * FROM carts where id = '" + cartId + "' LIMIT 1;";
        ResultSet rs = executeQuery(query);
        rs.next();
        Integer userId = rs.getInt("user_id");
        
        query = "SELECT * FROM cart_items WHERE cart_id = " + cartId + ";";
        rs = executeQuery(query);
        List cartItems = new LinkedList<CartItem>();
        while (rs.next()) {
            Integer itemId = rs.getInt("item_id");
            Item item = itemDao.getItemByItemId(itemId);
            Integer quantity = rs.getInt("quantity");
            BigDecimal price = rs.getBigDecimal("price");
            BigDecimal subtotal = rs.getBigDecimal("subtotal");
            cartItems.add(new CartItem(cartId, item, quantity, price, subtotal));
        }
        return new Cart(cartId, userId, cartItems);
    }

}
