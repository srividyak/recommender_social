/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.daoimpl;

import com.myprojects.myworld.dao.BoardDAO;
import com.myprojects.myworld.hibernate.pojo.Board;
import java.util.List;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author srividyak
 */
@Transactional
public class BoardDAOImpl implements BoardDAO {

    private HibernateTemplate template;

    public void setTemplate(HibernateTemplate template) throws BoardException {
        try {
            this.template = template;
        } catch (Exception e) {
            throw new BoardException(e);
        }

    }

    public void update(Board b) throws BoardException {
        try {
            Session session = template.getSessionFactory().getCurrentSession();
            b.update(session);
        } catch (Exception e) {
            throw new BoardException(e);
        }
    }

    public void create(Board b) throws BoardException {
        try {
            this.template.save(b);
        } catch (Exception e) {
            throw new BoardException(e);
        }
    }

    public List<Board> getBoards() throws BoardException {
        try {
            return this.template.findByNamedQuery("Board.findAll");
        } catch (Exception e) {
            throw new BoardException(e);
        }

    }

    public Board getBoard(String id) throws BoardException {
        try {
            List<Board> boards = this.template.find("from Board where boardId = ?", id);
            if (boards != null && boards.size() > 0) {
                return boards.get(0);
            }
            return null;
        } catch(Exception e) {
            throw new BoardException(e);
        }
    }

    public void deleteBoard(String id) throws BoardException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
