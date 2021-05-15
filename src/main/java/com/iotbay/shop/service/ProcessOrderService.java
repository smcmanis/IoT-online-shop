package com.iotbay.shop.service;

import com.iotbay.shop.dao.OrderDao;
import com.iotbay.shop.model.Cart;
import com.iotbay.shop.model.CartItem;
import com.iotbay.shop.model.CreditCardPayment;
import com.iotbay.shop.model.Item;
import com.iotbay.shop.model.Order;
import com.iotbay.shop.model.Shipping;
import com.iotbay.shop.model.User;

import java.util.List;
import javax.transaction.Transaction;

public class ProcessOrderService {

    private final CreditCardPaymentService creditCardPaymentService = new CreditCardPaymentService();
    private final ItemService itemService = new ItemService();
    private final CustomerService customerService = new CustomerService();

    private final OrderDao orderDao = new OrderDao();

    public Order processOrder(Order order, Cart cart, CreditCardPayment creditCardPayment, Shipping shipping) throws Exception {
        User customer = cart.getUser();
        return processOrder(order, cart, creditCardPayment, shipping, customer);
    }

    public Order processOrder(Order order, Cart cart, CreditCardPayment creditCardPayment, Shipping shipping, User customer) throws Exception {

        // user can be null for now...
        if (order == null || cart == null || creditCardPayment == null || shipping == null) {
            // Should check each individually and throw custom exceptions for each
            throw new Exception();
        }
        
// Process the payment
        Transaction paymentTransaction = creditCardPaymentService.processPayment(creditCardPayment, order, cart, customer);

        if (order.getOrderStatus() == null) {
            order.setOrderStatus("Submitted");
        }
        if (customer == null || customer.getId() == null) {
            customerService.createCustomer(customer);
        }
        order.setUser(customer);

        order.setCart(cart);
        if (paymentTransaction != null) {
            order.setPaid(true);
            creditCardPayment.setOrder(order);
        } else {
            // ALLOW NULL UNTIL THIS IS SUPPORTED
            order.setPaid(true);
            creditCardPayment.setOrder(order);
        }

        // Process item stock
        List<CartItem> cartItems = order.getCart().getCartItems();
        for (CartItem cartItem : cartItems) {
            Item item = itemService.getItemByItemId(cartItem.getItem().getId());
            if (item == null) {
                throw new Exception();
            }
            int quantity = cartItem.getQuantity();
            if (quantity > item.getQuantity()) {
                throw new Exception();
            }
            item.setQuantity(item.getQuantity() - quantity);
            itemService.updateItem(item);
        }
        
        //Add date/time

        orderDao.addOrder(order);
        
        return order;
    }
    
    public void cancelOrder(Order order) {
        
    }
    
}
