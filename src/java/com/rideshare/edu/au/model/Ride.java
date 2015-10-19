/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rideshare.edu.au.model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
    /*@NamedQuery(
            name="updateRide",
            query="UPDATE Ride r "
                    + "SET r.datePosted = :datePosted, r.xloc = :xloc, r.yloc = :yloc "
                    + "WHERE r.id = :id"),*/
    @NamedQuery(
            name="deleteRideById",
            query="DELETE FROM Ride r WHERE r.id = :id"),
    
    @NamedQuery(
            name="findAllRides",
            query="SELECT r FROM Ride r")
})
public class Ride implements Serializable{
    @Id
    @GeneratedValue
    private long id;
    private String startingDestination;
    private String finishedDestination;
    private String phoneNumber;
    private int passengerLimit;
    private Date departureTime;
    private String additionalInfo;
    
    //Foreign key
    private String username;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStartingDestination() {
        return startingDestination;
    }

    public void setStartingDestination(String startingDestination) {
        this.startingDestination = startingDestination;
    }

    public String getFinishedDestination() {
        return finishedDestination;
    }

    public void setFinishedDestination(String finishedDestination) {
        this.finishedDestination = finishedDestination;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPassengerLimit() {
        return passengerLimit;
    }

    public void setPassengerLimit(int passengerLimit) {
        this.passengerLimit = passengerLimit;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
    
    
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
    
    
}
