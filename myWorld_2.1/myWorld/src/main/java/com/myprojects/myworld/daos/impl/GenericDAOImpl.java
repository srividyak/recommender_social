/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.daos.impl;

import com.myprojects.myworld.daos.GenericDAO;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author srividyak
 */
@Component
public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

    @Autowired
    protected HibernateTemplate template;

    public T getDAO(String idName, String idValue, String entityName) {
        List<T> daos = template.find("from " + entityName + " where " + idName + " = ?", idValue);
        return daos.get(0);
    }

    @Override
    public void createDAO(Object t) {
        Session session = template.getSessionFactory().getCurrentSession();
        session.save(t);
    }

    @Override
    public void updateDAO(Object t) {
        
    }
}
