    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iotbay.shop.model;

/**
 *
 * @author namlo
 */
public class User {
    private String fname;
    private String lname;
    private String email;
    private String password;
    
    //constructor that initialise the fields
    public User(String fname, String lname, String email, String password){
        this.fname = fname;
        this.lname= lname;
        this.email = email;
        this.password = password;
    }
    
    //inserts getters/setters

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}


