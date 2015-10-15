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
    
    @EJB
    private Account account;
    @EJB
    private AccountRepository repos;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    
    
    
    public void signup(){
        
        repos.create(account);
    }
    
    public void login(){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            request.login(account.getUsername(), account.getPassword());
        } catch (ServletException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
