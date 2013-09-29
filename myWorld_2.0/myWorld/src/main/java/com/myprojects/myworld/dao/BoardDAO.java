/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.dao;

import com.myprojects.myworld.daoimpl.BoardException;
import com.myprojects.myworld.hibernate.pojo.Board;
import java.util.List;

/**
 *
 * @author srividyak
 */
public interface BoardDAO {

    public void create(Board b) throws BoardException;

    public void update(Board b) throws BoardException;

    public List<Board> getBoards() throws BoardException;

    public Board getBoard(String id) throws BoardException;
    
    public void deleteBoard(String id) throws BoardException;
    
}
