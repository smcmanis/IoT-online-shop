package com.iotbay.shop.controller.order;

import com.iotbay.shop.dao.CreditCardDao;
import com.iotbay.shop.dao.ShippingDao;
import com.iotbay.shop.model.Cart;
import com.iotbay.shop.model.CreditCard;
import com.iotbay.shop.model.Payment;
import com.iotbay.shop.model.Order;
import com.iotbay.shop.model.Shipment;
import com.iotbay.shop.model.ShipmentDetails;
import com.iotbay.shop.model.User;
import com.iotbay.shop.service.CartService;
import com.iotbay.shop.service.ProcessOrderService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet(name = "ProcessOrderServlet", urlPatterns = {"/ProcessOrderServlet"})
public class ProcessOrderServlet extends HttpServlet {
    
    private final CartService cartService = new CartService();
    private final CreditCardDao creditCardDao = new CreditCardDao();
    private final ShippingDao shippingDao = new ShippingDao();
    private final ProcessOrderService processOrderService = new ProcessOrderService();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Cart cart = (Cart) request.getSession().getAttribute("cart");
            cart = cartService.getCartByCartId(cart.getId());
            
            // Get card details from form....
            CreditCard card = creditCardDao.getCreditCardByCreditCardId(2); // dummy for now
            Payment payment = new Payment();
            
            User user = (User) request.getSession().getAttribute("user");
            if (user == null) {
                user = new User();
            }
            // Get shipping details from form...
//            Shipment shipment = shipmentDao.getShippingByShippingId(2); // dummy for now
            ShipmentDetails shipmentDetails = new ShipmentDetails();
            
            // Create and initialise order (should be done in OrderService)
            Order order = new Order();
            order.setShipmentDetails(shipmentDetails);

            order.setTotalPrice(cart.getTotalPrice()); // just use cart for now, but should calculate seperatly
            
            boolean orderSuccessful = false;
            try {
                order = processOrderService.processOrder(order, cart, payment, user);
                orderSuccessful = true;
                System.out.println("order successful is true");
                request.getSession().setAttribute("orderId", order.getId());
            } catch (Exception e) {
                // deal with errors etc. should dispatch to a proper failed order servlet...
                System.out.println(e.getMessage());
                 System.out.println("order successful is false");
            }
            
            if (orderSuccessful) {
                // clear cart ... 
                
                HttpSession session = request.getSession();
                user.getOrders().add(order);
                
                cartService.retireUsedCart(cart, request.getCookies(), session);
                request.setAttribute("order", order);
                request.getRequestDispatcher("/orderSubmitted.jsp").forward(request, response);
            }
        } catch (IOException | ServletException e) {
            System.out.println(e.getMessage());
            request.getRequestDispatcher("/customer/order/checkout").forward(request, response);
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
