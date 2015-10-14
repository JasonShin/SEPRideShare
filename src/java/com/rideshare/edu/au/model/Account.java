/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rideshare.edu.au.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Jason
 */
//User can either become driver or passenger
@Entity
@NamedQueries({
    @NamedQuery(
            name="findAccountByUsername",
            query="SELECT a "
                    + "FROM Account a "
                    + "WHERE :username = a.username"),
    @NamedQuery(
            name="findAll",
            query="SELECT a FROM Account a"),
    @NamedQuery(
            name="deleteAccountByUsername",
            query="DELETE FROM Account a "
                    + "WHERE :username = a.username")
})
public class Account {
    @Id
    private String username;
    private String password;
    private String phone;
    private String email;
    private boolean postRide;
    private boolean readRide;
    private boolean deleteRide;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPostRide() {
        return postRide;
    }

    public void setPostRide(boolean postRide) {
        this.postRide = postRide;
    }

    public boolean isReadRide() {
        return readRide;
    }

    public void setReadRide(boolean readRide) {
        this.readRide = readRide;
    }

    public boolean isDeleteRide() {
        return deleteRide;
    }

    public void setDeleteRide(boolean deleteRide) {
        this.deleteRide = deleteRide;
    }
    
    
    
    
}
