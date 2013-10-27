/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.controller.user;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.myprojects.myworld.controller.BaseController;
import com.myprojects.myworld.pojos.User;
import com.myprojects.myworld.service.user.UserService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author srividyak
 */
@Controller
@RequestMapping("/user/create")
public class CreateUser extends BaseController {

    @Autowired
    private UserService service;

    /**
     * 
     * @param body
     * @return Map containing uuid and statusCode
     */
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public Map<String,Object> createUser(@RequestBody String body) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        Map<String, Object> response = new HashMap<String, Object>();
        User u = gson.fromJson(body, User.class);
        service.createUser(u);
        response.put("uuid", u.getUuid());
        response.put("statusCode", 0);
        return response;
    }
    
}
