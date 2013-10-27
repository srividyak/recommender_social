/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.daos.user;

import com.myprojects.myworld.daos.GenericDAO;
import com.myprojects.myworld.pojos.User;
import java.util.List;

/**
 *
 * @author srividyak
 */
public interface UserDAO extends GenericDAO<User> {

    User getUserByEmail(String id);
}
