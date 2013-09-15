/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myprojects.myworld.hibernate.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author srividyak
 */
@Embeddable
public class FriendsPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "myUuid")
    private String myUuid;
    @Basic(optional = false)
    @Column(name = "friendUuid")
    private String friendUuid;

    public FriendsPK() {
    }

    public FriendsPK(String myUuid, String friendUuid) {
        this.myUuid = myUuid;
        this.friendUuid = friendUuid;
    }

    public String getMyUuid() {
        return myUuid;
    }

    public void setMyUuid(String myUuid) {
        this.myUuid = myUuid;
    }

    public String getFriendUuid() {
        return friendUuid;
    }

    public void setFriendUuid(String friendUuid) {
        this.friendUuid = friendUuid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (myUuid != null ? myUuid.hashCode() : 0);
        hash += (friendUuid != null ? friendUuid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FriendsPK)) {
            return false;
        }
        FriendsPK other = (FriendsPK) object;
        if ((this.myUuid == null && other.myUuid != null) || (this.myUuid != null && !this.myUuid.equals(other.myUuid))) {
            return false;
        }
        if ((this.friendUuid == null && other.friendUuid != null) || (this.friendUuid != null && !this.friendUuid.equals(other.friendUuid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.myprojects.myworld.hibernate.pojo.FriendsPK[ myUuid=" + myUuid + ", friendUuid=" + friendUuid + " ]";
    }
    
}
