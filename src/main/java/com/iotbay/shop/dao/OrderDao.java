package com.iotbay.shop.dao;

import com.iotbay.shop.controller.DBServlet;
import com.iotbay.shop.model.Cart;
import com.iotbay.shop.model.Order;
import com.iotbay.shop.model.User;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

public class OrderDao extends Dao {

    private CartDao cartDao = new CartDao();
    private UserDao userDao = new UserDao();
//    private SessionFactory sessionFactory;

    public OrderDao() {
    }

    public List getOrders() throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM orders;";
        ResultSet rs = executeQuery(query);

        List orders = new ArrayList<>();
        while (rs.next()) {
            Integer orderId = rs.getInt("id");
            Date orderDate = rs.getDate("order_date");
            String orderStatus = rs.getString("order_status");
            BigDecimal totalPrice = rs.getBigDecimal("total_price");
            Integer cartId = rs.getInt("cart_id");
            Integer userId = rs.getInt("user_id");
            Cart cart = cartDao.getCartByCartId(cartId);
            User user = userDao.getUserByUserId(userId);
            orders.add(new Order(orderId, orderDate, orderStatus, totalPrice, cart, user));
        }
        return orders;
    }

    public Order getOrderByOrderId(Integer orderId) throws SQLException {
        String query = "SELECT * FROM orders WHERE id='" + orderId + "';";
        ResultSet rs = executeQuery(query);
        while (rs.next()) {
            Date orderDate = rs.getDate("order_date");
            String orderStatus = rs.getString("order_status");
            BigDecimal totalPrice = rs.getBigDecimal("total_price");
            Integer cartId = rs.getInt("cart_id");
            Integer userId = rs.getInt("user_id");
            Cart cart = cartDao.getCartByCartId(cartId);
            System.out.println("got cart");
            System.out.println(cart.getCartItems());
            User user = userDao.getUserByUserId(userId);
            return new Order(orderId, orderDate, orderStatus, totalPrice, cart, user);

        }
        return null;
    }
//
//    public void addOrder(Order order) {
//        Session session = sessionFactory.openSession();
//        session.saveOrUpdate(order);
//        session.flush();
//        session.close();
//    }
//
//    public double getTotalPrice(Integer cartId) {
//        double totalPrice = 0;
//        Cart cart = cartDao.getCartByCartId(cartId);
//        List<CartItem> cartItems = cart.getCartItems();
//
//        for (CartItem item : cartItems) {
//            totalPrice += item.getPrice().doubleValue();
//        }
//        return totalPrice;
//    }
//}

//    @Override
//    public Optional<Order> get(Integer id
//    ) {
//        return Optional.ofNullable(orders.get((int) id));
//    }
//
//    public List<Order> getAll() {
//        Session session = factory.openSession();
//        Transaction tx = null;
//
//        try {
//            tx = session.beginTransaction();
//            List orders = session.createQuery("FROM orders").list();
//            for (Iterator iterator = orders.iterator(); iterator.hasNext();) {
//                Order order = (Order) iterator.next();
//                System.out.print("First Name: " + order.getOrderStatus());
//                System.out.print("  Last Name: " + order.getUserId());
//                System.out.println("  Salary: " + order.getOrderDate());
//            }
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//
//        return new LinkedList<Order>();
//    }
//
//    @Override
//    public void save(Order order
//    ) {
//        orders.add(order);
//    }
//
//    @Override
//    public void update(Order order, String[] params
//    ) {
//
//    }
//
//    @Override
//    public void delete(Order order
//    ) {
////        orders.removeif()
//    }
}
