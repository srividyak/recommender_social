/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.dao;

import com.myprojects.myworld.exception.PagesException;
import com.myprojects.myworld.hibernate.pojo.Board;
import com.myprojects.myworld.hibernate.pojo.Pages;
import com.myprojects.myworld.hibernate.pojo.Users;
import java.util.List;

/**
 *
 * @author srividyak
 */
public interface PagesDAO {

    public void create(Pages p) throws PagesException;

    public void update(Pages p) throws PagesException;

    public List<Pages> getPages() throws PagesException;

    public List<Pages> searchPages(String pattern) throws PagesException;

    public Pages getPage(String id) throws PagesException;

    public List<Board> getBoards(String id) throws PagesException;

    public List<Board> getTopBoards(String id) throws PagesException;
    
    public List<Pages> getUserPages(String uuid) throws PagesException;
    
    public List<Users> getPageUsers(Pages p) throws PagesException;
    
}
