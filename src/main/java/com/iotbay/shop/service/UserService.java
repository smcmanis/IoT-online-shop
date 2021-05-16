package com.iotbay.shop.service;

import com.iotbay.shop.dao.EmployeeDao;
import com.iotbay.shop.dao.UserDao;
import com.iotbay.shop.model.Employee;
import com.iotbay.shop.model.User;
import javax.servlet.http.Cookie;

public class UserService {

    private UserDao userDao = new UserDao();
    private EmployeeDao employeeDao = new EmployeeDao();

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

    public boolean isUserEmployee(User user) {
        if (user != null) {
            if (user.isAdmin()) {
                return true;
            }
            for (Employee e : employeeDao.getAllEmployees()) {
                if (e.getUser() != null && e.getUser().getId().equals(user.getId())) {
                    return true;
                }
            }
        }
        

        return false;
    }

    
}
