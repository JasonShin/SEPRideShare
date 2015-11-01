/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridesahre.edu.au.controller;

import com.rideshare.edu.au.helper.DateHelper;
import com.rideshare.edu.au.helper.RequestHelper;
import com.rideshare.edu.au.helper.URLParamHelper;
import com.rideshare.edu.au.model.Ride;
import com.rideshare.edu.au.repository.RideRepository;
import java.sql.Date;
import java.util.Calendar;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

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
    
    public Ride findRide(){
        if(URLParamHelper.getRideId() != null){
            return repos.findRideById(Integer.parseInt(URLParamHelper.getRideId()));
        } else {
            return null;
        }
        
    }
    
    
    public String create(){
        ride.setUsername(RequestHelper.getUsername());
        ride.setDepartureTime(DateHelper.getCurrentSqlDate());
        repos.create(ride);
        return "/index.xhtml?faces-redirect=true";
    }
    
}
