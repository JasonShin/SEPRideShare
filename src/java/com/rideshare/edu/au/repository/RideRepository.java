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
    
    
    //C
    public void create(Ride ride){
        em.persist(ride);
        em.flush();
    }
    
    //R
    public Ride findRideById(int id){
        return em.createNamedQuery("findRideById", Ride.class)
                .setParameter("id", id)
                .getSingleResult();
    }
    
    public List<Ride> findAll(){
        return em.createNamedQuery("findAllRides", Ride.class)
                .getResultList();
    }
    
    
    //U
    public void updateRide(Ride ride){
        em.createNamedQuery("updateRide", Ride.class)
                .setParameter("id", ride.getId())
                .executeUpdate();
    }
    
    //D
    public void deleteRideById(int id){
        em.createNamedQuery("deleteRideById", Ride.class)
                .setParameter("id", id)
                .executeUpdate();
    }
}
