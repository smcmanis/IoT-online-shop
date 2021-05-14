package com.iotbay.shop.service;

import javax.servlet.http.Cookie;

public class UserService {

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
}
