/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.exception;

/**
 *
 * @author srividyak
 */
public class PagesException extends Exception {
    
    public PagesException(Exception e) {
        e.printStackTrace();
    }
}
