package com.iotbay.shop.service;

import com.iotbay.shop.dao.UserDao;
import com.iotbay.shop.model.User;
import javax.servlet.http.Cookie;

public class UserService {

    private UserDao userDao = new UserDao();
    
    public boolean authenticateUserByCookies(Cookie[] cookies) {
//        // Check user has cookies for user crednetials e.g.
//        Integer userId = null;
//        String password = null;
//        for (Cookie cookie: cookies) {
//            if (cookie.getName().equals("userId")) {
//                try {
//                    userId = Integer.parseInt(cookie.getValue());
//                } catch (Exception e) {
//                    System.out.println("could not parse userId from cookie");
//                }
//            } else if (cookie.getName().equals("password")) {
//                password = cookie.getValue();
//            }
//        } 
//       if (userId != null && password != null) {
//           userService.loginUser(userId, password);
//       }........ etc.
        return false;
    }
    
    public void deactivateUser(User user) {
        user.setActive(false);
        userDao.updateUser(user);
    }
    
    
}
