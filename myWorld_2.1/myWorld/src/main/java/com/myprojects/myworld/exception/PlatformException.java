/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.exception;

/**
 *
 * @author srividyak
 */
public class PlatformException extends Exception {

    private int statusCode;
    
    private String customMsg;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getCustomMsg() {
        return customMsg;
    }

    public void setCustomMsg(String customMsg) {
        this.customMsg = customMsg;
    }

    public PlatformException(int statusCode, String customMsg) {
        this.statusCode = statusCode;
        this.customMsg = customMsg;
    }
    
    public PlatformException() {
        
    }
}
