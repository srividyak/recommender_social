/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.service;

import com.myprojects.myworld.pojos.User;
import com.myprojects.myworld.service.user.UserService;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author srividyak
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserServiceTest {

    @Autowired
    private UserService service;
    
    public UserServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("in setup class");
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        System.out.println("in setup method");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCreateUser() {
        User newUser = new User("srividya", "krishnamurthy", new Date(606322159), false, "vidya.vasishtha5@gmail.com");
        User insertedUser = service.createUser(newUser);
        User resUser = service.getUser(insertedUser.getUuid());
        Assert.assertTrue(resUser.getUuid().equals(insertedUser.getUuid()));
//        Assert.assertTrue(true);
    }
}