/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.daoimpl;

import com.myprojects.myworld.dao.FriendsDAO;
import com.myprojects.myworld.hibernate.pojo.Friends;
import com.myprojects.myworld.hibernate.pojo.Users;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 *
 * @author srividyak
 */
public class FriendsDAOImpl implements FriendsDAO {
    
    /** relation
     * 0 => send
     * 1 => accept => friends only in this state
     * 2 => view
     * 3 => decline from me to friend
     * 4 => decline from friend to me
     */

    private HibernateTemplate template;

    public void setTemplate(HibernateTemplate template) throws UserException {
        try {
            this.template = template;
        } catch (Exception e) {
            throw new UserException(e);
        }
    }

    public List<Users> getFriends(Users u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Users> getMutualFriends(Users me, Users friend) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Users> getMutualFriends(Friends friends) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Users> getTopFriends(Users u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Friends getRelation(Users me, Users friend) {
        List<Friends> friends = this.template.find("from Friends where myUuid=? and friendUuid=?", new String[]{me.getUuid(), friend.getUuid()});
        return friends != null && friends.size() > 0 ? friends.get(0) : null;
    }

    /**
     * action from me to friend
     * @param me
     * @param friend
     * @param action 
     */
    public void handleFriendRelation(Users me, Users friend, String action) {
        Session session = this.template.getSessionFactory().openSession();
        String friendsQuery = "";
        Query friendsTblQuery = null, myUserTblQuery = null, friendUserTblQuery = null;
        String myUuid = me.getUuid();
        String friendUuid = friend.getUuid();
        Friends direct = getRelation(me, friend);
        if (direct != null) {
            if (action.equals("send")) {
                if(!direct.getRelation().equals("0") && !direct.getRelation().equals("1")) {
                    friendsQuery = "update friends set relation='0',viewCount=viewCount+1 where myUuid=? and friendUuid=?";
                    friendsTblQuery = session.createQuery(friendsQuery);
                }
            } else if (action.equals("decline")) {
                if(direct.getRelation().equals("1")) {
                    friendsQuery = "update friends set relation='3',viewCount=viewCount+1 where myUuid=? and friendUuid=?";
                    friendsTblQuery = session.createQuery(friendsQuery);
                    myUserTblQuery = session.createQuery("update users set friendsCount=friendsCount-1 where uuid=?");
                    myUserTblQuery.setString(1, myUuid);
                    friendUserTblQuery = session.createQuery("update users set friendsCount=friendsCount-1 where uuid=?");
                    friendUserTblQuery.setString(1, friendUuid);
                }
            } else if (action.equals("view")) {
                friendsQuery = "update friends set viewCount=viewCount+1 where myUuid=? and friendUuid=?";
                friendsTblQuery = session.createQuery(friendsQuery);
            } else if(action.equals("withdraw")) {
                if(direct.getRelation().equals("0")) {
                    friendsQuery = "update friends set relation='2',viewCount=viewCount+1 where myUuid=? and friendUuid=?";
                    friendsTblQuery = session.createQuery(friendsQuery);
                }
            }
            if(friendsTblQuery != null) {
                friendsTblQuery.setString(1, myUuid);
                friendsTblQuery.setString(2, friendUuid);
            }
        } else {
            Friends opposite = getRelation(friend, me);
            if(opposite != null) {
                if (action.equals("send")) {
                    if(!opposite.getRelation().equals("0") && !opposite.getRelation().equals("1")) {
                        
                    }
                } else if (action.equals("accept")) {

                } else if (action.equals("decline")) {

                } else if (action.equals("view")) {

                }
            } else {
                if (action.equals("send")) {
                
                } else if (action.equals("accept")) {

                } else if (action.equals("decline")) {

                } else if (action.equals("view")) {

                }
            }
        }
    }
}
