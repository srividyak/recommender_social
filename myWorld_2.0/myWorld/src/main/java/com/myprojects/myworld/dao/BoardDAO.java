/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.dao;

import com.myprojects.myworld.exception.BoardException;
import com.myprojects.myworld.hibernate.pojo.Board;
import com.myprojects.myworld.hibernate.pojo.Comment;
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
    
    public List<Comment> getComments(String id) throws BoardException;
    
    public List<Comment> getTopComments(String id) throws BoardException;
    
    public List<Board> searchBoards(String pattern) throws BoardException;
    
    public List<Board> getUserBoards(String uuid) throws BoardException;
}
