package com.iotbay.shop.dao;

import com.iotbay.shop.model.Cart;
import com.iotbay.shop.model.CartItem;
import com.iotbay.shop.model.Order;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


//@Repository
public class OrderDao {

    private CartDao cartDao;
    private SessionFactory sessionFactory;
    
    public OrderDao() {
        cartDao
    }

    public void getOrders() {

        Cart c = cartDao.getCartByCartId(1);
        System.out.println(c.getId());
//        System.out.println(c.getTotalPrice());
        System.out.println(c.getCartItems());
    }

    public void addOrder(Order order) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(order);
        session.flush();
        session.close();
    }

    public double getTotalPrice(Integer cartId) {
        double totalPrice = 0;
        Cart cart = cartDao.getCartByCartId(cartId);
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems) {
            totalPrice += item.getPrice().doubleValue();
        }
        return totalPrice;
    }
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
