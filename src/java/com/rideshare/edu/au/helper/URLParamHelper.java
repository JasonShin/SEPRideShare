/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rideshare.edu.au.helper;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Jason
 */
public class URLParamHelper {
    
    /**
     * Acquires current Ride ID
     * @return 
     */
    public static String getRideId(){
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String rid = request.getParameter("rid");
        return rid;
    }
    /**
     * Getting currently logged in username
     * @return 
     */
    public static String getUserName(){
       return FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
    }
}
