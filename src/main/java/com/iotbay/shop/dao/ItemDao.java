package com.iotbay.shop.dao;

import com.iotbay.shop.model.Item;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemDao extends Dao {

    public Item getItemByItemId(Integer itemId) throws SQLException {
        String query = "SELECT * FROM items where id = '" + itemId + "';";
        ResultSet rs = executeQuery(query);
        rs.next();

        String itemName = rs.getString("item_name");
        Integer quantity = rs.getInt("quantity");
        BigDecimal price = rs.getBigDecimal("price");
        String imageUrl = rs.getString("image_url");
        String category = rs.getString("category");
        return new Item(itemId, itemName, quantity, price, imageUrl, category);
    }

    public List getAllItems() throws SQLException {
        String query = "SELECT * FROM items;";
        ResultSet rs = executeQuery(query);

        List itemList = new LinkedList<>();
        while (rs.next()) {
            Integer itemId = rs.getInt("id");
            String itemName = rs.getString("item_name");
            Integer quantity = rs.getInt("quantity");
            BigDecimal price = rs.getBigDecimal("price");
            String imageUrl = rs.getString("image_url");
            String category = rs.getString("category");
            itemList.add(new Item(itemId, itemName, quantity, price, imageUrl, category));
        }
        return itemList;
    }

    
}
