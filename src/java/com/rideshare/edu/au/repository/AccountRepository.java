/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rideshare.edu.au.repository;

import com.rideshare.edu.au.helper.SHA;
import com.rideshare.edu.au.model.Account;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jason
 */
@Stateless
public class AccountRepository {
    @PersistenceContext
    private EntityManager em;
    
    public void create(Account account){
        try {
            String encryptedPassword = SHA.hash256(account.getPassword());
            account.setPassword(encryptedPassword);
            account.setGroupname("Users");
            System.out.println("Signup: " + account.getUsername());
            em.persist(account);
            em.flush();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AccountRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Account read(String username){
        return em.createNamedQuery("findAccountByUsername", Account.class)
                .setParameter("username", username)
                .getSingleResult();
    }
    
    public List<Account> findAll(){
        return em.createNamedQuery("findAll", Account.class)
                .getResultList();
    }
    
    public void update(Account account){
        
    }
    
    public void delete(String username){
        em.createNamedQuery("deleteAccountByUsername", Account.class)
                .setParameter("username", username)
                .executeUpdate();
    }
}
