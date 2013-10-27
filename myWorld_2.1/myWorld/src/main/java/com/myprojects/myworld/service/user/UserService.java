/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.service.user;

import com.myprojects.myworld.daos.user.impl.UserDAOImpl;
import com.myprojects.myworld.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author srividyak
 */
@Component
@Transactional
public class UserService {
    
    @Autowired
    private UserDAOImpl userDAOImpl;
    
    public User getUser(String uuid) {
        return userDAOImpl.getDAO("uuid", uuid, "User");
    }
    
    public User createUser(User u) {
        userDAOImpl.createDAO(u);
        return u;
    }
    
    public User updateUser(User u) {
        userDAOImpl.updateDAO(u);
        return u;
    }
}
