/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.daos;

/**
 *
 * @author srividyak
 */
public interface GenericDAO<T> {
    T getDAO(String idName, String idValue, String entityName);
    
    void createDAO(T t);
    
    void updateDAO(T t);
}
