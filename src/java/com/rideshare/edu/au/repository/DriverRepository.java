/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rideshare.edu.au.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
