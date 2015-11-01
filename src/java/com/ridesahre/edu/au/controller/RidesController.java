/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridesahre.edu.au.controller;

import com.rideshare.edu.au.model.Ride;
import com.rideshare.edu.au.repository.RideRepository;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Jason
 */
@Named
@RequestScoped
public class RidesController {
    
    @EJB
    private RideRepository repos;
    
    /**
     * Get all rides stored in the database
     * @return 
     */
    public List<Ride> getRideList(){
        return repos.findAll();
    }
}
