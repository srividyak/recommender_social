/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld;

import com.google.gson.Gson;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.myprojects.myworld.daoimpl.UsersDAOImpl;
import com.myprojects.myworld.hibernate.pojo.Users;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author srividyak
 */
@Controller
@RequestMapping("/user")
public class test {

    @Autowired
    private UsersDAOImpl u;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getHelloWorld() {
        
        return "done";
    }
    
}
