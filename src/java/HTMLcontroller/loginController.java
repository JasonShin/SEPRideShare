/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTMLcontroller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.awt.event.*;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@Named
@RequestScoped
public class loginController{
    private String username;
    private String password;
    
    public void setDetails(String username, String password){
        this.username = username; 
        this.password = password;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void loginAction(ActionEvent actionEvent) {
        
        //call tryLogin function here
        
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "does this work?",  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
   
    
}

    

