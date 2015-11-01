/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridesahre.edu.au.controller;

import com.rideshare.edu.au.helper.DateHelper;
import com.rideshare.edu.au.helper.RequestHelper;
import com.rideshare.edu.au.helper.URLParamHelper;
import com.rideshare.edu.au.model.Account;
import com.rideshare.edu.au.model.Ride;
import com.rideshare.edu.au.repository.AccountRepository;
import com.rideshare.edu.au.repository.RideRepository;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
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
    
    @EJB
    private AccountRepository accountRepos;
    
    private Ride ride;
    
    /**
     * Creating new ride object within post construct dependency injection lifecycle
     */
    @PostConstruct
    public void init(){
        ride = new Ride();
    }

    /**
     * Get the current ride
     * @return 
     */
    public Ride getRide() {
        return ride;
    }

    /**
     * Setting the current temp ride
     * @param ride 
     */
    public void setRide(Ride ride) {
        
        this.ride = ride;
    }
    
    /**
     * Find a ride according to ride id passed in as query string
     * @return 
     */
    public Ride findRide(){
        if(URLParamHelper.getRideId() != null){
            return repos.findRideById(Integer.parseInt(URLParamHelper.getRideId()));
        } else {
            return null;
        }
        
    }
    
    /**
     * Delete a ride according to ride id passed in as query string
     * @return 
     */
    public String delete(){
        repos.deleteRideById(Integer.parseInt(URLParamHelper.getRideId()));
        return "/MyRides.xhtml?faces-redirect=true";
    }
    
    /**
     * Create a new ride with account detail including phone number and username
     * @return 
     */
    public String create(){
        ride.setUsername(RequestHelper.getUsername());
        ride.setDepartureTime(DateHelper.getCurrentSqlDate());
        Account account = accountRepos.read(URLParamHelper.getUserName());
        ride.setPhoneNumber(account.getPhone());
        repos.create(ride);
        return "/index.xhtml?faces-redirect=true";
    }
    
}
