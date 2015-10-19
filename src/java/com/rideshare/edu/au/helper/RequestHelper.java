/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rideshare.edu.au.helper;

import javax.faces.context.FacesContext;

/**
 *
 * @author Jason
 */
public class RequestHelper {
    public static String getUsername(){
        return FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
    }
}
