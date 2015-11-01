/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rideshare.edu.au.helper;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author Jason
 */
public class DateHelper {
    
    /**
     * Acquires current date in SQL date format
     * @return 
     */
    public static Date getCurrentSqlDate(){
        Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        return date;
    }
}
