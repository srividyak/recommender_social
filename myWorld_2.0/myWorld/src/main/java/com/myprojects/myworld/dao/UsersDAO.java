/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.dao;

import com.myprojects.myworld.daoimpl.UserException;
import com.myprojects.myworld.hibernate.pojo.Users;
import java.util.List;

/**
 *
 * @author srividyak
 */
public interface UsersDAO {

    public List<Users> getUsers() throws UserException;
    
    public Users getUser(String uuid) throws UserException;
    
    public void updateUser(Users u) throws UserException;
    
    public void createUser(Users u) throws UserException;
}
