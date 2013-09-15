/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.daoimpl;

import com.myprojects.myworld.dao.UsersDAO;
import com.myprojects.myworld.hibernate.pojo.Friends;
import com.myprojects.myworld.hibernate.pojo.Users;
import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 *
 * @author srividyak
 */
public class UsersDAOImpl implements UsersDAO {

    private HibernateTemplate template;

    public void setTemplate(HibernateTemplate template) throws UserException {
        try {
            this.template = template;
        } catch (Exception e) {
            throw new UserException(e);
        }

    }

    public void updateUser(Users u) throws UserException {
        try {
            u.update(template.getSessionFactory().openSession());
        } catch (Exception e) {
            throw new UserException(e);
        }
    }

    public List<Users> getUsers() throws UserException {
        try {
            return this.template.findByNamedQuery("Users.findAll");
        } catch (Exception e) {
            throw new UserException(e);
        }
    }

    public Users getUser(String uuid) throws UserException {
        try {
            List<Users> users = this.template.find("from Users where uuid=?", uuid);
            if (users != null && users.size() > 0) {
                return users.get(0);
            }
        } catch (Exception e) {
            throw new UserException(e);
        }
        return null;
    }

    public void createUser(Users u) throws UserException {
        try {
            this.template.save(u);
        } catch (Exception e) {
            throw new UserException(e);
        }
    }

}