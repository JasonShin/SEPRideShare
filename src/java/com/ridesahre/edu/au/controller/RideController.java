/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridesahre.edu.au.controller;

import com.rideshare.edu.au.model.Ride;
import com.rideshare.edu.au.repository.RideRepository;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Jason
 */
@Named
@RequestScoped
public class RideController {
    
    @EJB
    private RideRepository repos;
    
    private Ride ride;
    
    @PostConstruct
    public void init(){
        ride = new Ride();
    }

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        
        this.ride = ride;
    }
    
    
    
    public void create(){
        
        //ride.setDatePosted(new Date());
        repos.create(ride);
    }
    
}
