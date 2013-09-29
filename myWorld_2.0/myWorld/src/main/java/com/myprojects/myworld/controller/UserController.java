/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.myprojects.myworld.exception.UserException;
import com.myprojects.myworld.daoimpl.UsersDAOImpl;
import com.myprojects.myworld.hibernate.pojo.Users;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author srividyak
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UsersDAOImpl userDaoObj;

    @RequestMapping(value = "{uuid}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getUser(@PathVariable String uuid) {
        try {
            Users user = userDaoObj.getUser(uuid);
            return user != null ? user.toString() : "{\"error\":1,\"message\": \"no such user exists\"}";
        } catch (UserException ex) {
            return "{\"error\":1,\"message\":" + ex.getMessage() + "}";
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public String createUser(@RequestBody String body) {
        try {
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
            Users u = gson.fromJson(body, Users.class);
            this.userDaoObj.createUser(u);
            //TODO: custom response json renderer to be written
            return "{\"success\":1}";
        } catch (UserException ex) {
            //TODO: error handling to be streamlined
            return "{\"error\":1,\"message\":" + ex.getMessage() + "}";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public String updateUser(@RequestBody String body) {
        try {
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
            Users u = gson.fromJson(body, Users.class);
            if (u.getFriendsCount() != null || u.getDisabled() != null) {
                return "{\"error\":1,\"message\": \"not allowed to increment friendsCount or disabled through this API\"}";
            }
            this.userDaoObj.updateUser(u);
            return "{\"success\":1}";
        } catch (UserException ex) {
            return "{\"error\":1,\"message\":" + ex.getMessage() + "}";
        }
    }

    @RequestMapping(value = "{uuid}", method = RequestMethod.DELETE, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public String disableUser(@PathVariable String uuid) {
        try {
            Users u = new Users(uuid);
            u.setDisabled("true");
            this.userDaoObj.updateUser(u);
            return "{\"success\":1}";
        } catch (UserException ex) {
            return "{\"error\":1,\"message\":" + ex.getMessage() + "}";
        }
    }
    
    @RequestMapping(value = "{myUuid}/friend/{friendUuid}", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public String handleFriendRequest(@PathVariable String myUuid, @PathVariable String friendUuid, @RequestBody String body) {
        Gson gson = new Gson();
        //myUuid may send/accept/decline friendUuid
        HashMap<String, String> map = gson.fromJson(body, HashMap.class);
        String action = map.get("action");
        if(action.equals("send")) {
            
        } else if(action.equals("accept")) {
            
        } else if(action.equals("decline")) {
            
        } else {
            
        }
        return "";
    }
}
