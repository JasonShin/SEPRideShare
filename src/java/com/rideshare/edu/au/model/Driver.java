/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rideshare.edu.au.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Jason
 */
@Entity
@NamedQueries({
    @NamedQuery(
            name="findDriverByUsername",
            query="SELECT d "
                    + "FROM Driver d "
                    + "WHERE :username = d.username"),
    @NamedQuery(
            name="findAll",
            query="SELECT d FROM Driver d"),
    @NamedQuery(
            name="deleteDriverByUsername",
            query="DELETE FROM Driver d "
                    + "WHERE :username = d.username")
})
public class Driver implements Serializable{
    @Id
    private String username;
    private String password;
    private String phone;
    private String email;
    private boolean postRide;
    private boolean readRide;
    private boolean deleteRide;
    private int carLocation;
    private int numSeats;
    

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

    public int getCarLocation() {
        return carLocation;
    }

    public void setCarLocation(int carLocation) {
        this.carLocation = carLocation;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }
    
    
}
