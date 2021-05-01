package com.iotbay.shop.dao;

import com.iotbay.shop.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends Dao {

    public User getUserByUserId(Integer userId) throws SQLException {
        String query = "SELECT * FROM users WHERE id ='" + userId + "';";
        ResultSet rs = executeQuery(query);
        rs.next();
        String email = rs.getString("email");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String phone = rs.getString("phone_number");
        String password = rs.getString("password_plaintext");
        String salt = rs.getString("salt");
        String passhash = rs.getString("passhash");
        boolean active = rs.getBoolean("active");
        boolean employee = rs.getBoolean("is_employee");
        boolean admin = rs.getBoolean("is_admin");
        return new User(userId, firstName, lastName, email, password);
    }
}
