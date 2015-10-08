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
public class DriverRepository {
    //@PersistenceContext triggers DB to create tables
    @PersistenceContext
    private EntityManager em;
    
    public void create(Driver driver){
        em.persist(driver);
        em.flush();
    }
    
    public Driver read(String username){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Driver> cq = builder.createQuery(Driver.class);
        Root<Driver> p = cq.from(Driver.class);
        cq.select(p);
        cq.where(builder.equal(p.get(Driver_.username), username));
        
        Driver driver;
        List<Driver> driverList = em.createQuery(cq).getResultList();
        if(driverList.isEmpty()){
            return null;
        }
        driver = driverList.get(0);
        return driver;
    }
    
    public List<Driver> readAll(){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Driver> cq = builder.createQuery(Driver.class);
        Root<Driver> p = cq.from(Driver.class);
        cq.select(p);
        
        List<Driver> driverList = em.createQuery(cq).getResultList();
        return driverList;
    }
    
    public void update(Driver driver){
        
    }
    
    public void delete(String username){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaDelete<Driver> cd = builder.createCriteriaDelete(Driver.class);
        Root<Driver> p = cd.from(Driver.class);
        cd.where(builder.equal(p.get(Driver_.username), username));
        em.createQuery(cd).executeUpdate();
        em.flush();
        
    }
}
