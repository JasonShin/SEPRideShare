/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rideshare.edu.au.repository;

import com.rideshare.edu.au.model.Driver;
import com.rideshare.edu.au.model.Driver_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Jason
 */
//Worth noting that @Stateless
@Stateless
public class DriverRepository{
    //@PersistenceContext triggers DB to create tables
    @PersistenceContext
    private EntityManager em;
    
    public void create(Driver driver){
        em.persist(driver);
        em.flush();
    }
    
    public Driver read(String username){
        return em.createNamedQuery("findDriverByUsername", Driver.class)
                .setParameter("username", username)
                .getSingleResult();
    }
    
    public List<Driver> findAll(){
        return em.createNamedQuery("findAll", Driver.class)
                .getResultList();
    }
    
    public void update(Driver driver){
        
    }
    
    public void delete(String username){
        em.createNamedQuery("deleteDriverByUsername", Driver.class)
                .setParameter("username", username)
                .executeUpdate();
    }
}
