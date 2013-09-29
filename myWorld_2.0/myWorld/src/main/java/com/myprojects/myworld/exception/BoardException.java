/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.exception;

/**
 *
 * @author srividyak
 */
public class BoardException extends Exception  {
    
    public BoardException(Exception e) {
        e.printStackTrace();
    }
}
