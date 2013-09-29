/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.dao;

import com.myprojects.myworld.exception.GroupsException;
import com.myprojects.myworld.hibernate.pojo.Board;
import com.myprojects.myworld.hibernate.pojo.Groups;
import com.myprojects.myworld.hibernate.pojo.Users;
import java.util.List;

/**
 *
 * @author srividyak
 */
public interface GroupsDAO {
    
    public void create(Groups g) throws GroupsException;
    
    public void update(Groups g) throws GroupsException;
    
    public List<Groups> getGroups() throws GroupsException;
    
    public List<Groups> getUserGroups(String uuid) throws GroupsException;
    
    public List<Groups> getTopGroups() throws GroupsException;
    
    public List<Users> getGroupUsers(Groups g) throws GroupsException;
    
    public List<Board> getBoards(Groups g) throws GroupsException;
    
    public List<Board> getTopBoards(Groups g) throws GroupsException;
    
    public Groups getGroup(String id) throws GroupsException;
    
}
