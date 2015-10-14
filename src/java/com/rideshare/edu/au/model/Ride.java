/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rideshare.edu.au.model;

import java.io.Serializable;
import java.sql.Date;
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
            name="findRideById",
            query="SELECT r "
                    + "FROM Ride r "
                    + "WHERE :id = r.id"),
    @NamedQuery(
            name="updateRide",
            query="UPDATE Ride r "
                    + "SET r.datePosted = :datePosted, r.xLocation = :xLocation, r.yLocation = :yLocation "
                    + "WHERE r.id = :id"),
    @NamedQuery(
            name="deleteRideById",
            query="DELETE FROM Ride r WHERE r.id = :id")
})
public class Ride implements Serializable{
    @Id
    private long id;
    private Date datePosted;
    private int xLocation;
    private int yLocation;
    //Foreign key
    private String username;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public int getxLocation() {
        return xLocation;
    }

    public void setxLocation(int xLocation) {
        this.xLocation = xLocation;
    }

    public int getyLocation() {
        return yLocation;
    }

    public void setyLocation(int yLocation) {
        this.yLocation = yLocation;
    }
    
    
}
