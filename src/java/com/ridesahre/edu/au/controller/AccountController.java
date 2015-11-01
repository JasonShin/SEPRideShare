/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ridesahre.edu.au.controller;

import com.rideshare.edu.au.model.Account;
import com.rideshare.edu.au.repository.AccountRepository;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Jason
 */
@Named
@RequestScoped
public class AccountController {
    
    private Account account;
    @EJB
    private AccountRepository repos;

    /**
     * Initiating account bean that is going hold temporary data from forms
     */
    @PostConstruct
    public void init(){
        account = new Account();
    }
    
    /**
     * Getting temp account data holder object
     * @return 
     */
    public Account getAccount() {
        return account;
    }
    
    /**
     * Setting temp account data holder object
     * @param account 
     */
    public void setAccount(Account account) {
        this.account = account;
    }
    
    
    /**
     * Signup a new account, which simply invokes create method of repository
     */
    public void signup(){
        
        repos.create(account);
    }
    
    /**
     * Logs out from the server by calling container based logout method
     */
    public void logout(){
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            request.logout();
        } catch (ServletException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Login logic based on container technology of J2EE 
     */
    public void login(){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        System.out.println("trying to login");
        try {
            
            request.login(account.getUsername(), account.getPassword());
        } catch (ServletException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
