/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.daos.user.impl;

import com.myprojects.myworld.daos.impl.GenericDAOImpl;
import com.myprojects.myworld.daos.user.UserDAO;
import com.myprojects.myworld.pojos.User;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author srividyak
 */
@Component
public class UserDAOImpl extends GenericDAOImpl<User> implements UserDAO {

    @Override
    public User getUserByEmail(String emailId) {
        List<User> users = template.find("from User where email=?", emailId);
        return users.get(0);
    }
    
}
