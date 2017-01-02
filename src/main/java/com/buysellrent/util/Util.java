package com.buysellrent.util;


import java.util.TimeZone;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Util {

	   /**
     * Null check Method
     * 
     * @param txt
     * @return
     */
    public static boolean isNullOREmpty(String txt) {
        return txt == null || txt.trim().length() == 0 ? true : false;
    }
 
    /**
     * Method to construct JSON
     * 
     * @param tag
     * @param status
     * @return
     */
    public static String constructJSON(Object response) {
    	 
          Gson gson = null;
          String json=null;
        try {
        	gson = new GsonBuilder().serializeNulls().create();
            json = gson.toJson(response);

        } catch (Exception e) {
        }
        return json;
    }
 
   
    
    public static java.sql.Timestamp getCurrentTimeStamp() {
    	java.util.Date today = new java.util.Date();
    	TimeZone.setDefault(TimeZone.getTimeZone("Europe/Istanbul"));
    	return new java.sql.Timestamp(today.getTime());
    }
}