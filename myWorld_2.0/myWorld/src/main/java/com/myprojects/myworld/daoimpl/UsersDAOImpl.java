/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.daoimpl;

import com.myprojects.myworld.exception.UserException;
import com.myprojects.myworld.dao.UsersDAO;
import com.myprojects.myworld.hibernate.pojo.Users;
import java.util.List;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author srividyak
 */
//@Transactional
//@Service
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
            Session session = template.getSessionFactory().getCurrentSession();
            u.update(session);
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

    public List<Users> searchUsers(String key) throws UserException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
