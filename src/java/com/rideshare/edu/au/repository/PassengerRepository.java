/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rideshare.edu.au.repository;

import com.rideshare.edu.au.model.Passenger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jason
 */
@Stateless
public class PassengerRepository {
    
    @PersistenceContext
    private EntityManager em;
    
    //C
    public void create(Passenger passenger){
        em.persist(passenger);
        em.flush();
    }
    
    //R
    public Passenger findByPassengerName(String username){
        return em.createNamedQuery("findPassengerByUsername", Passenger.class)
                .setParameter("username", username)
                .getSingleResult();
    }
    
    public List<Passenger> findAll(){
        return em.createNamedQuery("findAll", Passenger.class)
                .getResultList();
    }
    
    //U
    public void update(Passenger passenger){
        
    }
    
    
    //D
    public void delete(String username){
        em.createNamedQuery("deletePassengerByUsername", Passenger.class)
                .setParameter("username", username)
                .executeUpdate();
    }
    
}
