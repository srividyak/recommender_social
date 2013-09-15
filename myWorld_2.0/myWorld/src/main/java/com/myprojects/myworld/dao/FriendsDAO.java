/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.dao;

import com.myprojects.myworld.hibernate.pojo.Friends;
import com.myprojects.myworld.hibernate.pojo.Users;
import java.util.List;

/**
 *
 * @author srividyak
 */
public interface FriendsDAO {
    
    public List<Users> getFriends(Users u);
        
    public List<Users> getMutualFriends(Users me, Users friend);
        
    public List<Users> getMutualFriends(Friends friends);
    
    public List<Users> getTopFriends(Users u);
        
    public void handleFriendRelation(Users me, Users friend, String action);
}
