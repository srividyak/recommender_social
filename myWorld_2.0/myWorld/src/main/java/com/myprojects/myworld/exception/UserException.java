/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.exception;

/**
 *
 * @author srividyak
 */
public class UserException extends Exception {

    public UserException(Exception e) {
        e.printStackTrace();
    }
}
