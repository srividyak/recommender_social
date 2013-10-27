/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.controller.user;

import com.myprojects.myworld.pojos.User;
import com.myprojects.myworld.service.user.UserService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author srividyak
 */
@Controller
@RequestMapping("/user")
public class GetUser {
    
    @Autowired
    private UserService service;
    
    @RequestMapping(value = "{uuid}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Map<String, Object> getUser(@PathVariable String uuid) {
        User u = service.getUser(uuid);
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("statusCode", 0);
        response.put("user", u);
        return response;
    }
}
