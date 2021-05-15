package com.iotbay.shop.service;

import com.iotbay.shop.dao.ItemDao;
import com.iotbay.shop.model.Item;

public class ItemService {
    
    private final ItemDao itemDao = new ItemDao();
    
    public Item getItemByItemId(Integer itemId) {
        return itemDao.getItemByItemId(itemId);
    }

    public void updateItem(Item item) {
        itemDao.updateItem(item);
    }
}
