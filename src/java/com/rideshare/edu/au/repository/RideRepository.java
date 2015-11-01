/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rideshare.edu.au.repository;

import com.rideshare.edu.au.model.Ride;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jason
 */
@Stateless
public class RideRepository {
    
    @PersistenceContext
    private EntityManager em;
    
    
    /**
     * Create new ride into the database
     * @param ride 
     */
    public void create(Ride ride){
        em.persist(ride);
        em.flush();
    }
    
    /**
     * find a ride according to ID
     * @param id
     * @return 
     */
    public Ride findRideById(int id){
        return em.createNamedQuery("findRideById", Ride.class)
                .setParameter("id", id)
                .getSingleResult();
    }
    
    /**
     * Find all Rides regardless of their condition
     * @return 
     */
    public List<Ride> findAll(){
        return em.createNamedQuery("findAllRides", Ride.class)
                .getResultList();
    }
    
    
    
    /**
     * Delete a ride using their ID property
     * @param id 
     */
    public void deleteRideById(int id){
        em.createNamedQuery("deleteRideById", Ride.class)
                .setParameter("id", id)
                .executeUpdate();
    }
}
