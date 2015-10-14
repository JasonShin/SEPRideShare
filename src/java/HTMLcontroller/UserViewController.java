/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HTMLcontroller;

/**
 *
 * @author NQ
 */

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@Named
@RequestScoped
public class UserViewController {
    
    private String firstname;
    private String lastname;
    private String address;
    private String state;
    private int zipCode;
    private String email;
    private String cPassword;
    private String username;
    private String password;
    private String phone;

    public UserViewController(String firstname, String lastname, String address, String state, int zipCode, String email, String cPassword, String username, String password, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.state = state;
        this.zipCode = zipCode;
        this.email = email;
        this.cPassword = cPassword;
        this.username = username;
        this.password = password;
        this.phone = phone;
    }
    
    
    public void doRegister(ActionEvent actionEvent) {
        
        System.out.println(this.getAddress());
        
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Register Working",  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
}
